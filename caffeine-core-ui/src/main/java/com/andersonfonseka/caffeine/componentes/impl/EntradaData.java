package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.DateValidator;

import com.andersonfonseka.caffeine.componentes.IEntradaData;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

@Model
public @Data class EntradaData extends Entrada implements IEntradaData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3955625665174027266L;
	private String pattern;
	
	EntradaData(){}
	
	@Override
	public String getTemplate() {
		return "inputdate";
	}
	
	@Override
	public String validar() {
		
		DateValidator dateValidator = DateValidator.getInstance();
		
		if (!dateValidator.isValid(getValor(), getPattern())){
			return new MensagemUtil().getMessage("DATEFIELD", getTitulo());	
		}
		
		return "";
	}

}
