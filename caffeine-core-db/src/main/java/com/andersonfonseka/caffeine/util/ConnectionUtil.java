package com.andersonfonseka.caffeine.util;

import java.util.Properties;

public class ConnectionUtil {
	
	private Properties properties;
	
	public ConnectionUtil() throws Exception {
		this.properties = new Properties();
		this.properties.load(ConnectionUtil.class.getResourceAsStream("/database.properties"));
	}
	
	public String getURL() {
		return this.properties.getProperty("URL").trim();
	}
	
	public String getUsername() {
		return this.properties.getProperty("USERNAME").trim();
	}

	
	public String getPassword() {
		return this.properties.getProperty("PASSWORD").trim();
	}


}
