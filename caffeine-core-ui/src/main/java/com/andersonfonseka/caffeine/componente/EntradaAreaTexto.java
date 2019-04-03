package com.andersonfonseka.caffeine.componente;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class EntradaAreaTexto extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	private Integer maxLength;
	
	@Override
	public String getTemplate() {
		return "inputtextarea";
	}

	
}
