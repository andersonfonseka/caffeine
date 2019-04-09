package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class Rotulo extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4099784173983962979L;
	private String title;
	
	@Override
	public String getTemplate() {
		return "label";
	}

	
}
