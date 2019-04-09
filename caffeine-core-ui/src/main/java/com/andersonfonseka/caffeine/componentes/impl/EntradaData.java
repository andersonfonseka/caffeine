package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.DateValidator;

import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

@Model
public @Data class EntradaData extends Entrada {

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
		
		if (!dateValidator.isValid(getValor(), getPattern())){
			return MensagemUtil.getInstance().getMessage("DATEFIELD", getTitulo());	
		}
		
		return "";
	}

}
