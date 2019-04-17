package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IEntradaTexto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
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

	@Override
	public void aoCarregar(Map<String, String> parametros) {}

}
