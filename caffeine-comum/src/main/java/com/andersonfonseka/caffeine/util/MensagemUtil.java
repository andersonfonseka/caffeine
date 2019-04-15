package com.andersonfonseka.caffeine.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class MensagemUtil {

	private Properties properties = new Properties();
	
	public MensagemUtil() {
		try {
			properties.load(MensagemUtil.class.getResourceAsStream("/messages.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getMensagemPropriedades(String key, String...args) {
		MessageFormat format = new MessageFormat(properties.getProperty(key));
		return format.format(args);
	}
	
	public String getMensagemTexto(String message) {
		return message;
	}
	
}
