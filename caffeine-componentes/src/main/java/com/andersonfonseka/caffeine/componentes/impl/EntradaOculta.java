package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IEntradaOculta;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaOculta extends Entrada implements IEntradaOculta {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340908969483338598L;
	
	EntradaOculta(){}
	
	@Override
	public String getTemplate() {
		return "inputhidden";
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}

}
