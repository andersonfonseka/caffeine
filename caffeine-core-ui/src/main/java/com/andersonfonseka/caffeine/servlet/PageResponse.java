package com.andersonfonseka.caffeine.servlet;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public @Data class PageResponse {
	
	List<String> messages = new ArrayList<String>();
	
	String pageUrl;

	public void addMessage(String message) {
		this.messages.add(message);
	}
	
}
