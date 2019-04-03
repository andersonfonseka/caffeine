package com.andersonfonseka.fastui.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class MessageUtil {

	private Properties properties = new Properties();
	
	private static MessageUtil INSTANCE;
	
	public MessageUtil() {
		try {
			properties.load(MessageUtil.class.getResourceAsStream("/messages.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MessageUtil getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MessageUtil();
		}
		return INSTANCE;
	}
	
	public String getMessage(String key, String...args) {
		MessageFormat format = new MessageFormat(properties.getProperty(key));
		return format.format(args);
	}
	
	public String getMessage(String message) {
		return message;
	}
	
}
