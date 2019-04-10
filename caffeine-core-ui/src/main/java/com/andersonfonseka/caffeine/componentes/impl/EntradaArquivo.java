package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IEntradaArquivo;

import lombok.Data;

@Model
public @Data class EntradaArquivo extends Entrada implements IEntradaArquivo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439811151946472472L;

	private Integer size;
	
	private Integer maxLength;
	
	EntradaArquivo(){}
	
	@Override
	public String getTemplate() {
		return "inputfile";
	}

	
}
