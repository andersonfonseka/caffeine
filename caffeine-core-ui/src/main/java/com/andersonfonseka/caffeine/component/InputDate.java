package com.andersonfonseka.caffeine.component;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.DateValidator;

import com.andersonfonseka.caffeine.util.MessageUtil;

import lombok.Data;

@Model
public @Data class InputDate extends Input {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3955625665174027266L;
	private String pattern;
	
	@Override
	public String getTemplate() {
		return "inputdate";
	}
	
	@Override
	public String validate() {
		
		DateValidator dateValidator = DateValidator.getInstance();
		
		if (!dateValidator.isValid(getValue(), getPattern())){
			return MessageUtil.getInstance().getMessage("DATEFIELD", getTitle());	
		}
		
		return "";
	}

}
