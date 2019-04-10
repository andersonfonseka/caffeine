package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IRotulo;

import lombok.Data;

@Model
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

	
}
