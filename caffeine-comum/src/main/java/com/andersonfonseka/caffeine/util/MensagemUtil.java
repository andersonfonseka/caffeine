package com.andersonfonseka.caffeine.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MensagemUtil {

	private static final Logger log = Logger.getLogger(MensagemUtil.class.getName());
	
	private Properties properties = new Properties();
	
	public MensagemUtil() {
		try {
			properties.load(MensagemUtil.class.getResourceAsStream("/messages.properties"));
		} catch (IOException e) {
			log.log(Level.WARNING, e.getMessage());
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
