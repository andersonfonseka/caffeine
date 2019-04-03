package com.andersonfonseka.caffeine.data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.andersonfonseka.caffeine.util.ConnectionUtil;

public class ConnectionManager {
	
	private Connection conn = null;
	private DatabaseMetaData dbmd = null;
	
	public ConnectionManager() throws Exception {
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		conn = DriverManager.getConnection(connectionUtil.getURL(), connectionUtil.getUsername(), connectionUtil.getPassword());
		dbmd = conn.getMetaData();
	}

	public DatabaseMetaData getDatabaseMetaData() {
		return dbmd;
	}
	
	public void close() {
		
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
	}
	
}
