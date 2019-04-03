package com.andersonfonseka.caffeine.componente;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.EmailValidator;

import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

@Model
public @Data class EntradaEmail extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9151902940785641660L;

	private Integer size;
	
	private Integer maxLength;
	
	@Override
	public String getTemplate() {
		return "inputemail";
	}
	
	@Override
	public String validate() {
		
		EmailValidator emailValidator = EmailValidator.getInstance();
		
		if (!emailValidator.isValid(getValue())){
			return MensagemUtil.getInstance().getMessage("EMAILFIELD", getTitle());	
		}
		
		return "";
	}

}
