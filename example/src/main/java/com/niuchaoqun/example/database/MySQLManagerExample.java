package com.niuchaoqun.example.database;

import java.sql.Connection;

import com.niuchaoqun.database.MySQL117_3307;
import com.niuchaoqun.database.MySQLManager;

public class MySQLManagerExample {
	public static void run(String[] args) {
		MySQLManager.getSingleton();
//		System.out.println(MySQLManager.options);
//		MySQLManager.setOptions("1", "2", "3");
//		System.out.println(MySQLManager.options);
//		MySQL117_3307 mySQL117_3307 = new MySQL117_3307();
//		MySQLManager.setOptions(mySQL117_3307);
		System.out.println(MySQLManager.options);

		try {
			Connection connection1 = MySQLManager.getConnection();
			Connection connection2 = MySQLManager.getConnection();
			System.out.println(connection1);
			System.out.println(connection2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
