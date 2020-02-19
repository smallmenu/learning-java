package com.niuchaoqun.vendor;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Nlpai {
    public static void main(String[] args) {
        //String token = getToken();

        System.out.println(zhaotoubiao());
    }

    public static String zhaotoubiao() {
        OkHttpClient client = new OkHttpClient();
        //创建表单请求参数
        String in = "由上海欣声招标服务中心有限公司组织的上海市交通委交通行业舆情监测（项目编号:SHXM-00-20191216-1271,预算编号：00-20-00413，项目总金额：680000.00）的竞争性磋商方式的采购，于2019-12-20 16:00:00在上海市政府采购网发布采购信息，在上海市河南中路382弄1号717室评审。\n" +
                "\n" +
                "经评审委员会评审，并经采购人确认，本次成交结果公布如下：\n" +
                "\n" +
                "一、成交日期：2019.12.31\n" +
                "\n" +
                "二、成交信息：\n" +
                "包为“上海市交通委交通行业舆情监测”的成交供应商：上海嘉道信息技术有限公司，成交供应商地址：嘉定工业区普惠路333号3幢1073室，成交金额：668082元\n" +
                "\n" +
                "三、主要成交标的的名称、规格型号、数量、单价、服务要求：\n" +
                "\n" +
                "    \n" +
                "交通行业舆情监测\n" +
                "\n" +
                "四、评标委员会成员：\n" +
                "\n" +
                "    杨潇慧,于杨曜,华兆增\n" +
                "\n" +
                "五、其他\n" +
                "\n" +
                "    代理收费标准：\n" +
                "\n" +
                "    招标代理机构根据《招标代理收费管理暂行办法》（计价格【2002】1980号）以及《国家发展改革委办公厅关于招标代理服务收费有关问题的通知》（发改办价格【2003】857）规定的服务类收费标准向中标人按中标价收取招标代理服务费。\n" +
                "\n" +
                "    代理收费金额：\n" +
                "\n" +
                "    1.02万元\n" +
                "\n" +
                "如对评标结果有异议，请于本评标结果公布之日起7个工作日内以书面形式向上海欣声招标服务中心有限公司提出质疑。";
        String url = "http://www.nlpai.cn/api/zhaotoubiaoxinxitiqu";
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("token", getToken());
        builder.add("in", in);
        builder.add("url", url);
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getToken() {
        MediaType contentType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        String url = "http://www.nlpai.cn/platform/gettoken";
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accesskey", "8dcb4414537d4b97901ef5e16cd41139");
        jsonObject.put("accesskeysecret", "fe0a48d087f246e59e4d17b85de4fb75");
        StringBuffer sb = new StringBuffer();
        //设置表单参数
        for (String key : jsonObject.keySet()) {
            sb.append(key + "=" + jsonObject.get(key) + "&");
        }
        RequestBody bodys = RequestBody.create(contentType, sb.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(bodys)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            String token = response.body().string();
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return null;
    }
}
