package com.andersonfonseka.caffeine.servlet;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public @Data class Resposta {
	
	List<String> messages = new ArrayList<String>();
	
	String pageUrl;

	public void adicionar(String message) {
		this.messages.add(message);
	}
	
}
