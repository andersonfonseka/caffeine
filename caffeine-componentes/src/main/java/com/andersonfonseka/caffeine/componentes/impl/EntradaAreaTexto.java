package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IEntradaAreaTexto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaAreaTexto extends Entrada implements IEntradaAreaTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	EntradaAreaTexto(){}
	
	@Override
	public String getTemplate() {
		return "inputtextarea";
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}
	
}
