package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IEntradaTexto;

import lombok.Data;

@Model
public @Data class EntradaTexto extends Entrada implements IEntradaTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340908969483338598L;
	
	EntradaTexto(){}
	
	@Override
	public String getTemplate() {
		return "inputtext";
	}

}
