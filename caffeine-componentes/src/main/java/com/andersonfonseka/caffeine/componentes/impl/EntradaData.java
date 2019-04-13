package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.DateValidator;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntradaData;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Model
@EqualsAndHashCode(callSuper=false)
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
	public List<String> validar() {
		
		List<String> mensagens = new ArrayList<String>();
		
		mensagens.addAll(super.validar());	
		
		DateValidator dateValidator = DateValidator.getInstance();
		
		if (!dateValidator.isValid(getValor(), getPattern())){
			mensagens.add(new MensagemUtil().getMessage("DATEFIELD", getTitulo()));	
		}
		
		return mensagens;
	}

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}

}
