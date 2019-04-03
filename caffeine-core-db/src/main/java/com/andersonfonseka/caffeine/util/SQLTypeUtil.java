package com.andersonfonseka.caffeine.util;

import java.util.Properties;

public class SQLTypeUtil {
	
	private Properties properties;
	
	public SQLTypeUtil() throws Exception {
		this.properties = new Properties();
		this.properties.load(SQLTypeUtil.class.getResourceAsStream("/sqltypes.properties"));
	}
	
	public String getType(String key) {
		return this.properties.getProperty(key).trim();
	}

}
