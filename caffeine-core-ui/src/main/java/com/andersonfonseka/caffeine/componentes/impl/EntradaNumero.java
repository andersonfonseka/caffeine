package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.IntegerValidator;

import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

@Model
public @Data class EntradaNumero extends Entrada implements IEntradaNumero {

	private static final long serialVersionUID = -4340908969483338598L;
	
	EntradaNumero(){}
	
	@Override
	public String getTemplate() {
		return "inputnumber";
	}
	
	@Override
	public String validar() {
		
		if (isObrigatorio() && getValor().trim().length() == 0) {
			return new MensagemUtil().getMessage("REQUIREDFIELD", getTitulo());
		}
		
		IntegerValidator integerValidator = IntegerValidator.getInstance();
		
		if (!integerValidator.isValid(getValor())) {
			return new MensagemUtil().getMessage("NUMBERFIELD", getTitulo());
		}
		
		
		return "";
	}

}
