package com.andersonfonseka.caffeine.component;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class InputFile extends Input {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439811151946472472L;

	private Integer size;
	
	private Integer maxLength;
	
	@Override
	public String getTemplate() {
		return "inputfile";
	}

	
}
