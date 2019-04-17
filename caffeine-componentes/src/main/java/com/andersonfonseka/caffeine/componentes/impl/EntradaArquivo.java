package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IEntradaArquivo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaArquivo extends Entrada implements IEntradaArquivo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439811151946472472L;
	
	EntradaArquivo(){}
	
	@Override
	public String getTemplate() {
		return "inputfile";
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}

}
