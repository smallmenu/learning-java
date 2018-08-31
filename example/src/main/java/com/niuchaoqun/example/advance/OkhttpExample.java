package com.niuchaoqun.example.advance;

import com.niuchaoqun.example.advance.okhttp.MyCookieJar;
import okhttp3.*;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OkhttpExample {
    public static void run(String[] args) {
        try {
            cookie();
        } catch (IOException e) {
            e.printStackTrace();
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
