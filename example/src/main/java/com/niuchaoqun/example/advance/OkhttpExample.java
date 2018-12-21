package com.niuchaoqun.example.advance;

import com.niuchaoqun.example.advance.okhttp.MyCookieJar;
import com.niuchaoqun.example.thread.Thread1Example;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class OkhttpExample {

    public static OkHttpClient client;

    public static Authenticator proxyAuthenticator;

    public static AtomicLong counter = new AtomicLong(0);

    public static void run(String[] args) {
        try {
            proxy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void zdy() throws IOException {
        Authenticator proxyAuthenticator = (route, r) -> {
            String credential = Credentials.basic("squid", "SuosiSquid147!$&");
            return r.request().newBuilder()
                    .header("Proxy-Authorization", credential)
                    .build();
        };

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("129.28.67.78", 31283)))
                .proxyAuthenticator(proxyAuthenticator)
                .build();

        Response response = client.newCall(new Request.Builder()
                .url("http://s.zdaye.com/?api=201810301907575055&adr=%C9%BD%B6%AB%2C%D5%E3%BD%AD%2C%BD%AD%CB%D5%2C%B0%B2%BB%D5%2C%C9%CF%BA%A3%2C%B1%B1%BE%A9%2C%BD%AD%CE%F7&px=1")
                .build())
                .execute();

        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            if (body != null) {
                String html = body.string();
                System.out.println(html);
                String[] proxys = html.split("\\r\\n");

                for (String proxyStr : proxys) {
                    String[] proxy = proxyStr.split(":");
                    String proxyHost = proxy[0];
                    int proxyPort = Integer.parseInt(proxy[1]);

                    long start = System.currentTimeMillis();
                    client = new OkHttpClient()
                            .newBuilder()
                            .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)))
                            .proxyAuthenticator(proxyAuthenticator)
                            .connectTimeout(10000, TimeUnit.MILLISECONDS)
                            .build();

                    Response result = client.newCall(new Request.Builder()
                            .url("http://weixin.sogou.com/api/share?timestamp=1540871117&signature=qIbwY*nI6KU9tBso4VCd8lYSesxOYgLcHX5tlbqlMR8N6flDHs4LLcFgRw7FjTAOe-gypz8ZZla3SEcKJlU4vJMR35WXX-hWsS7Bl7GVYOMZ6*P2vljh*k9Tz0ibRBGreRpky1wSf1L5ndmlRr4fXi0lmg6yg64yMILiLrcqqTljI1caK*4a78DeAHJoNYCnIjgpXXW0-rCWRBskOfkPGxkZSFfzMa1TxFQwd3fZZoM=")
                            .build())
                            .execute();
                    long time = System.currentTimeMillis() - start;

                    if (result.isSuccessful()) {
                        String data = result.body().string();
                        if (!data.contains("访问过于频繁")) {
                            System.out.println(time + ",success,"+proxyPort);
                        } else {
                            System.out.println("访问过于频繁");
                        }
                    } else {
                        System.out.println("error");
                    }
                }
            }
        }
    }


    public static void proxy() throws IOException {

        String proxyHost = "125.119.40.102";

        String url = "http://weixin.sogou.com/api/share?timestamp=1540871117&signature=qIbwY*nI6KU9tBso4VCd8lYSesxOYgLcHX5tlbqlMR8N6flDHs4LLcFgRw7FjTAOe-gypz8ZZla3SEcKJlU4vJMR35WXX-hWsS7Bl7GVYOMZ6*P2vljh*k9Tz0ibRBGreRpky1wSf1L5ndmlRr4fXi0lmg6yg64yMILiLrcqqTljI1caK*4a78DeAHJoNYCnIjgpXXW0-rCWRBskOfkPGxkZSFfzMa1TxFQwd3fZZoM=";

        proxyAuthenticator = (route, r) -> {
            String credential = Credentials.basic("squid", "SuosiSquid147!$&");
            return r.request().newBuilder()
                    .header("Proxy-Authorization", credential)
                    .build();
        };

        client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                //.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, 31283)))
                //.proxyAuthenticator(proxyAuthenticator)
                .build();

        RunnableThread runnableThread = new RunnableThread();
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(runnableThread, "r" + i);
            thread.start();
        }
    }

    public static class RunnableThread implements Runnable {
        private static final Logger logger = LoggerFactory.getLogger(RunnableThread.class);

        @Override
        public void run() {
            String url = "https://www.360kan.com/dianshi/list.php?cat=104";

            while (true) {
                Request request = new Request.Builder()
                        .url(url)
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36")
                        .build();

                long start = System.currentTimeMillis();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                long time = System.currentTimeMillis() - start;

                long index = counter.incrementAndGet();
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        String data = null;
                        try {
                            data = body.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (data.contains("延禧攻略")) {
                            logger.info("{}, {}ms, {}", index, time, "success");
                        } else {
                            logger.info("{}, {}ms, {}", index, time, "访问过于频繁");
                        }
                    }
                } else {
                    logger.info("{}, {}ms, {}", index, time, "error");
                }
            }

        }
    }

    public static void simple() throws IOException {
        //OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url("http://www.ncq8.com/test.php")
                .header("X-TEST", "test")
                .header("User-Agent", "Chrome")
                .build();


        Response response = client.newCall(request).execute();

        // 响应代码
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }
        int httpCode = response.code();
        System.out.println("Status Code:" + httpCode);

        // 单个响应头
        String server = response.header("Server");
        System.out.println("Server:" + server);

        // 响应头数组
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            System.out.println(headers.name(i) + ":" +headers.value(i));
        }

        // 正文
        ResponseBody body = response.body();
        System.out.println(body.contentType().charset());
        System.out.println(body.contentType().type());
        System.out.println(body.contentLength());
        System.out.println(body.string());
    }

    public static void cookie() throws IOException {
        MyCookieJar cookieJar = new MyCookieJar();

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .build();

        long tc = System.currentTimeMillis();
        String url = "http://weixin.sogou.com/antispider/util/seccode.php?tc=" + tc;

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        Request request2 = new Request.Builder()
                .url("http://www.ncq8.com/test.php")
                .header("X-TEST", "test")
                .header("User-Agent", "Chrome")
                .build();
        Response response2 = client.newCall(request2).execute();

        System.out.println(cookieJar.getCookies());
        System.out.println(response2.body().string());


    }
}
