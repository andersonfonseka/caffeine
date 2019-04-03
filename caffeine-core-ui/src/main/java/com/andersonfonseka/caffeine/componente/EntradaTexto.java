package com.andersonfonseka.caffeine.componente;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class EntradaTexto extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340908969483338598L;

	private Integer size;
	
	private Integer maxLength;
	
	@Override
	public String getTemplate() {
		return "inputtext";
	}

}
