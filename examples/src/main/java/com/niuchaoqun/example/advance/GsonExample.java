package com.niuchaoqun.example.advance;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.niuchaoqun.example.Response;
import com.niuchaoqun.example.ResponseData;
import com.niuchaoqun.example.User;

public class GsonExample {
	
	public static void run(String[] args) {

		simpleExample();

		jsonObject();
	}

	@SuppressWarnings("unchecked")
	public static void simpleExample() {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		// Array [1,2,3]
		int[] ints1 = { 1, 2, 3 };
		String intsjson = gson.toJson(ints1);
		int[] ints2 = gson.fromJson(intsjson, int[].class);
		System.out.println(intsjson);
		System.out.println(ints2.length);

		// String Array ["1","2","3"]
		String[] strings1 = { "1", "2", "3" };
		String stringsjson = gson.toJson(strings1);
		String[] strings2 = gson.fromJson(intsjson, String[].class);
		System.out.println(stringsjson);
		System.out.println(strings2.length);
		System.out.println("=====");

		// Collection {"k1":"v1","k2":"v2","k3":"v3"}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("k1", "中文");
		map.put("k2", "v2");
		map.put("k3", "v3");
		String mapjson = gson.toJson(map);
		System.out.println(mapjson);
		// Decode
		Type collectionType = new TypeToken<HashMap<String, String>>() {
		}.getType();
		HashMap<String, String> jsonMap = gson.fromJson(mapjson, collectionType);
		for (Entry<String, String> entry : jsonMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println("=====");

		// Collection [1,"2",{"name":"zhang","age":10},{"name":"li","age":11}]
		// 并不建议的做法
		@SuppressWarnings("rawtypes")
		Collection collection = new ArrayList();
		collection.add(1);
		collection.add("2");
		collection.add(new User("zhang", 10));
		collection.add(new User("li", 11));
		String jsonCollection = gson.toJson(collection);
		System.out.println(jsonCollection);

		// decode is difficult
		JsonArray jsonArray = parser.parse(jsonCollection).getAsJsonArray();
		int one = jsonArray.get(0).getAsInt();
		String two = jsonArray.get(1).getAsString();
		JsonObject jso1 = jsonArray.get(2).getAsJsonObject();
		JsonObject jso2 = jsonArray.get(3).getAsJsonObject();
		User user1 = gson.fromJson(jso1, User.class);
		User user2 = gson.fromJson(jso2, User.class);
		System.out.println(one);
		System.out.println(two);
		System.out.println("name:" + user1.getName() + "-age:" + user1.getAge());
		System.out.println("name:" + user2.getName() + "-age:" + user2.getAge());
		System.out.println("=====");
	}

	public static void jsonDecode() {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		String json1 = "[1,2,3]";
		int[] ints = gson.fromJson(json1, int[].class);
		System.out.println(json1);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
		JsonArray jsonArray1 = parser.parse(json1).getAsJsonArray();
		int one1 = gson.fromJson(jsonArray1.get(0), int.class);
		int two1 = gson.fromJson(jsonArray1.get(1), int.class);
		int three1 = gson.fromJson(jsonArray1.get(2), int.class);
		System.out.println(one1 + "," + two1 + "," + three1);
		System.out.println("=====");

		String json2 = "[1,\"2\"]";
		JsonArray jsonArray2 = parser.parse(json2).getAsJsonArray();
		int one2 = gson.fromJson(jsonArray2.get(0), int.class);
		String two2 = gson.fromJson(jsonArray2.get(1), String.class);
		int one3 = jsonArray2.get(0).getAsInt();
		String two3 = jsonArray2.get(1).getAsString();
		System.out.println(json2);
		System.out.println(one2 + "," + two2);
		System.out.println(one3 + "," + two3);
		System.out.println("=====");

		String json3 = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		JsonObject jsonObject1 = parser.parse(json3).getAsJsonObject();
		String k1 = jsonObject1.get("k1").getAsString();
		String k2 = jsonObject1.get("k2").getAsString();
		System.out.println(json3);
		System.out.println("k1:" + k1 + "," + "k2:" + k2);
		System.out.println("=====");

		String json5 = "{\"code\":0,\"data1\":{\"key\":\"value\"},\"msg\":\"ok\"}";
		JsonObject jsonObject3 = parser.parse(json5).getAsJsonObject();
		int code = jsonObject3.get("code").getAsInt();
		String msg = jsonObject3.get("msg").getAsString();
		JsonObject data1 = jsonObject3.get("data1").getAsJsonObject();
		String data1value = data1.get("key").getAsString();

		System.out.println(json5);
		System.out.println("code:" + code);
		System.out.println("msg:" + msg);
		System.out.println("data1:key:" + data1value);
	}

	public static void jsonObject() {
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
		rd2.setN("");
		response.addData2(rd1);
		response.addData2(rd2);

		// 处理null值，但暂时不知怎么处理中文转码
		Gson gson1 = new GsonBuilder().serializeNulls().create();
		String json = gson1.toJson(response);
		System.out.println(json);
		System.out.println("=====");

		// 可以解析为内部类，但是不建议这么做
		Gson gson2 = new Gson();
		Response responseJson = gson2.fromJson(json, Response.class);

		int code = responseJson.getCode();
		String msg = responseJson.getMsg();
		HashMap<String, String> data3 = responseJson.getData1();
		List<ResponseData> data4 = responseJson.getData2();

		System.out.println(json);
		System.out.println("code:" + code);
		System.out.println("msg:" + msg);
		for (Entry<String, String> d : data3.entrySet()) {
			System.out.println(d.getKey() + ":" + d.getValue());
		}

		for (ResponseData d : data4) {
			System.out.println("s:" + d.getS() + ",i:" + d.getI() + ",b:" + d.isB() + ",n:" + d.getN());
		}

	}
}
