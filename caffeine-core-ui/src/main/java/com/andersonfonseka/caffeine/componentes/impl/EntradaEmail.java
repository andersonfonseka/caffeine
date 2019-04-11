package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.EmailValidator;

import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

@Model
public @Data class EntradaEmail extends Entrada implements IEntradaEmail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9151902940785641660L;
	
	EntradaEmail(){}
	
	@Override
	public String getTemplate() {
		return "inputemail";
	}
	
	@Override
	public String validar() {
		
		EmailValidator emailValidator = EmailValidator.getInstance();
		
		if (!emailValidator.isValid(getValor())){
			return new MensagemUtil().getMessage("EMAILFIELD", getTitulo());	
		}
		
		return "";
	}

}
