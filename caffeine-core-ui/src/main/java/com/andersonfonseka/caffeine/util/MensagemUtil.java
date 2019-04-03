package com.andersonfonseka.caffeine.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class MensagemUtil {

	private Properties properties = new Properties();
	
	private static MensagemUtil INSTANCE;
	
	public MensagemUtil() {
		try {
			properties.load(MensagemUtil.class.getResourceAsStream("/messages.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MensagemUtil getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MensagemUtil();
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
