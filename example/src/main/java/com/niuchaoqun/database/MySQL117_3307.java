package com.niuchaoqun.database;

public class MySQL117_3307 implements MySQLConnection {
	private String url = "jdbc:mysql://192.168.0.117:3307/db_companyinfomation?useUnicode=true&characterEncoding=UTF8";
	private String user = "dahaiyang";
	private String password = "dahaiyang2016";

	@Override
	public String getUrl() {
		return this.url;
	}

	@Override
	public String getUser() {
		return this.user;
	}

	@Override
	public String getPassword() {
		return this.password;
	}
}
