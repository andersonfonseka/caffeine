package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import org.apache.commons.validator.routines.IntegerValidator;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Model
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
			mensagens.add(new MensagemUtil().getMessage("NUMBERFIELD", getTitulo()));
		}
		
		return mensagens;
	}

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}

}
