package com.niuchaoqun.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Response {
	private int code;
	private String msg;
	private HashMap<String, String> data1;
	private List<ResponseData> data2 = new ArrayList<ResponseData>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HashMap<String, String> getData1() {
		return data1;
	}

	public void setData1(HashMap<String, String> data1) {
		this.data1 = data1;
	}

	public List<ResponseData> getData2() {
		return data2;
	}

	public void setData2(List<ResponseData> data2) {
		this.data2 = data2;
	}

	public void addData2(ResponseData rd) {
		data2.add(rd);
	}
}