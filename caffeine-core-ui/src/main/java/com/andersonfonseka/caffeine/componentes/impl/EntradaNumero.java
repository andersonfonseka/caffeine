package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IEntradaNumero;

import lombok.Data;

@Model
public @Data class EntradaNumero extends Entrada implements IEntradaNumero {

	private static final long serialVersionUID = -4340908969483338598L;
	
	EntradaNumero(){}
	
	@Override
	public String getTemplate() {
		return "inputnumber";
	}

}
