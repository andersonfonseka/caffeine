package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.validator.routines.IntegerValidator;

import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaNumero extends Entrada implements IEntradaNumero {

	private static final long serialVersionUID = -4340908969483338598L;
	
	EntradaNumero(){}
	
	@Override
	public String getTemplate() {
		return "inputnumber";
	}
	
	public List<String> validar() {
		
		List<String> mensagens = new ArrayList<String>();
		
		mensagens.addAll(super.validar());	
		
		IntegerValidator integerValidator = IntegerValidator.getInstance();
		
		if (!integerValidator.isValid(getValor())) {
			mensagens.add(new MensagemUtil().getMensagemPropriedades("NUMBERFIELD", getTitulo()));
		}
		
		return mensagens;
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {
		// TODO Auto-generated method stub
		
	}

}
