package com.andersonfonseka.caffeine.componente;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class EntradaArquivo extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439811151946472472L;

	private Integer size;
	
	private Integer maxLength;
	
	@Override
	public String getTemplate() {
		return "inputfile";
	}

	
}
