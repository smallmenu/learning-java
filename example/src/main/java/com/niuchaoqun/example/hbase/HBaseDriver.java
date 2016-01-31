package com.niuchaoqun.example.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class HBaseDriver {
	private static class SingletonHolder {
		private static final HBaseDriver INSTANCE = new HBaseDriver();
	}

	private static Configuration config = null;

	private HBaseDriver() {
		config = HBaseConfiguration.create();
	}

	public static final HBaseDriver getSingleton() {
		return SingletonHolder.INSTANCE;
	}

	public Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			connection = ConnectionFactory.createConnection(config);
		} catch (Exception e) {
			throw new Exception("HBase Connection Exception:" + e.getMessage());
		}

		return connection;
	}

	public void closeConnection(Connection connection) throws Exception {
		if (connection != null) {
			try {
				connection.close();
			} finally {
				connection = null;
			}
		}
	}
}
