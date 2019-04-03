package com.andersonfonseka.caffeine.component;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class InputTextArea extends Input {

	/**
	 * 
	 */
	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	private Integer maxLength;
	
	@Override
	public String getTemplate() {
		return "inputtextarea";
	}

	
}
