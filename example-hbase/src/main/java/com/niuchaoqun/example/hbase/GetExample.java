package com.niuchaoqun.example.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class GetExample {
	public static final String TABLE_NAME = "test:content_m";

	public static TableName tableName = null;

	public static Configuration config = null;

	public GetExample() {
		config = HBaseConfiguration.create();
		//config.set("hbase.zookeeper.quorum", "localhost");
		config.set("hbase.zookeeper.quorum", "192.168.0.91,192.168.0.92,192.168.0.93");
		config.set("hbase.zookeeper.property.clientPort", "2181");
		config.set("hbase.client.retries.number", "3");
		tableName = TableName.valueOf(TABLE_NAME);
	}

	public void getValue() throws Exception {
		Connection connection = null;
		Table table = null;

		try {
			connection = ConnectionFactory.createConnection(config);
			table = connection.getTable(tableName);
			Get get = new Get(Bytes.toBytes("10000000"));
			get.setCacheBlocks(true);
			get.addFamily(Bytes.toBytes("data"));
			get.addColumn(Bytes.toBytes("data"), Bytes.toBytes("InfoUrl"));

			long startTime = System.currentTimeMillis();
			Result result = table.get(get);
			long endTime = System.currentTimeMillis();
			System.out.println("time:" + (endTime - startTime) + "ms");
			
			System.out.println(Bytes.toString(result.getValue(Bytes.toBytes("data"), Bytes.toBytes("InfoUrl"))));
		} finally {
			if (connection != null)
				connection.close();
			if (table != null)
				table.close();
		}
	}

	public void getRow() throws Exception {
		Connection connection = null;
		Table table = null;

		try {
			connection = ConnectionFactory.createConnection(config);
			table = connection.getTable(tableName);
			Get get = new Get(Bytes.toBytes("5599000"));
			get.setCacheBlocks(true);

			long startTime = System.currentTimeMillis();
			Result result = table.get(get);
			long endTime = System.currentTimeMillis();

			System.out.println("time:" + (endTime - startTime) + "ms");
			for (Cell cell : result.rawCells()) {
				System.out.println("RowKey:" + Bytes.toString(CellUtil.cloneRow(cell)) + "/"
						+ Bytes.toString(CellUtil.cloneQualifier(cell)) + ":"
						+ Bytes.toString(CellUtil.cloneValue(cell)));
			}
		} finally {
			if (connection != null)
				connection.close();
			if (table != null)
				table.close();
		}
	}
}
