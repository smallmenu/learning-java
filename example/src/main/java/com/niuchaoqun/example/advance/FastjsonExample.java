package com.niuchaoqun.example.advance;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.niuchaoqun.example.Response;
import com.niuchaoqun.example.ResponseData;

public class FastjsonExample {
	public static void run(String[] args) {
		simpleExample();
		jsonObject();
	}

	public static void simpleExample() {

		// Array [1,2,3]
		int[] ints1 = { 1, 2, 3 };
		String intsjson = JSON.toJSONString(ints1);
		int[] ints2 = JSON.parseObject(intsjson, int[].class);
		System.out.println(intsjson);
		System.out.println(ints2.length);
		System.out.println("=====");

		// String Array ["1","2","3"]
		// such as Gson

		// Collection {"k1":"v1","k2":"v2","k3":"v3"}
		// such as Gson

		// Collection {"age":50,"name":"\u4E2D\u6587","salary":8000}
		// 可以处理中文转码，兼容IE6
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "中文");
		jsonObject.put("age", 50);
		jsonObject.put("salary", new BigDecimal(8000));
		String text = JSON.toJSONString(jsonObject, SerializerFeature.BrowserCompatible);
		System.out.println(text);
		JSONObject po = JSON.parseObject(text, JSONObject.class);
		for (Entry<String, Object> p : po.entrySet()) {
			System.out.println(p.getKey() + ":" + p.getValue());
		}
		System.out.println("=====");

		// 不规范的Json字符串： [1,"2"]
		JSONArray jsonA1 = new JSONArray();
		jsonA1.add(1);
		jsonA1.add("2");
		String json = JSON.toJSONString(jsonA1);
		System.out.println(json);

		JSONArray pa1 = JSON.parseArray(json);
		for (Object object : pa1) {
			System.out.println(object);
		}
		System.out.println("=====");

		// 不规范的Json字符串： [1,"2",{"age":10,"name":"zhang"},{"age":11,"name":"li"}]
		// Fastjson 能很好的处理这种情况，不需要额外的class
		JSONArray jsonA2 = new JSONArray();
		JSONObject jsonO1 = new JSONObject();
		JSONObject jsonO2 = new JSONObject();
		jsonO1.put("name", "zhang");
		jsonO1.put("age", 10);
		jsonO2.put("name", "li");
		jsonO2.put("age", 11);
		jsonA2.add(1);
		jsonA2.add("2");
		jsonA2.add(jsonO1);
		jsonA2.add(jsonO2);
		String jsonCollection = JSON.toJSONString(jsonA2);
		System.out.println(jsonCollection);


		/**
		 * Json 解析
		 * 可以解析为内置对象 JSONObject
		 */
		JSONArray pa2 = JSON.parseArray(jsonCollection);
		int one = (int) pa2.get(0);
		String two = (String) pa2.get(1);
		JSONObject object1 = (JSONObject) pa2.get(2);
		JSONObject object2 = (JSONObject) pa2.get(3);
		System.out.println(one);
		System.out.println(two);
		for (Entry<String, Object> p : object1.entrySet()) {
			System.out.println(p.getKey() + ":" + p.getValue());
		}
		for (Entry<String, Object> p : object2.entrySet()) {
			System.out.println(p.getKey() + ":" + p.getValue());
		}
		System.out.println("=====");

	}

	public static void jsonObject() {
		// encode
		Response response = new Response();
		response.setCode(0);
		response.setMsg("ok");

		HashMap<String, String> data1 = new HashMap<String, String>();
		data1.put("key", "中文");
		response.setData1(data1);

		ResponseData rd1 = new ResponseData();
		ResponseData rd2 = new ResponseData();
		rd1.setS("string1");
		rd1.setI(1);
		rd1.setB(true);
		rd1.setN(null);
		rd2.setS("string2");
		rd2.setI(2);
		rd2.setB(false);
		rd2.setN("null");
		response.addData2(rd1);
		response.addData2(rd2);

		// 处理null值，编码中文
		String json = JSON.toJSONString(response, SerializerFeature.BrowserCompatible,
				SerializerFeature.WriteMapNullValue);
		System.out.println(json);
		System.out.println("=====");

		// Fastjson 解析object不能是内部Class，否则会出现解析异常
		System.out.println(json);
		Response responseJSON = JSON.parseObject(json, Response.class);
		int code = responseJSON.getCode();
		String msg = responseJSON.getMsg();
		HashMap<String, String> data3 = responseJSON.getData1();
		List<ResponseData> data4 = responseJSON.getData2();
		System.out.println("code:" + code);
		System.out.println("msg:" + msg);
		for (Entry<String, String> d : data3.entrySet()) {
			System.out.println(d.getKey() + ":" + d.getValue());
		}

		for (ResponseData d : data4) {
			System.out.println("s:" + d.getS() + ",i:" + d.getI() + ",b:" + d.isB());
			System.out.println(d.getN() == null ? "yes" : "no");
		}
	}
}
