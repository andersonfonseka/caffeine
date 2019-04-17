package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IRotulo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Rotulo extends Componente implements IRotulo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4099784173983962979L;
	
	private String titulo;
	
	Rotulo(){}
	
	@Override
	public String getTemplate() {
		return "label";
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}
}
