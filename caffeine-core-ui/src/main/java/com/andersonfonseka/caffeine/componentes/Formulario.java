package com.andersonfonseka.caffeine.componentes;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class Formulario extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;

	@Override
	public String getTemplate() {
		return "form";
	}

	
}
