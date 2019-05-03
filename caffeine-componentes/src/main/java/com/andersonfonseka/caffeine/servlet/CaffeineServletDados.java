package com.andersonfonseka.caffeine.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.caffeine.IProjeto;

import lombok.Data;

public @Data class CaffeineServletDados {

	private HttpServletRequest req;
	private HttpServletResponse resp;
	private IProjeto project;
	private String op;
	private String componentId;
	
	

}
