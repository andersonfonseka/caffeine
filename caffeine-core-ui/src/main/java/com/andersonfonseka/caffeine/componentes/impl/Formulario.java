package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IFormulario;

import lombok.Data;

@Model
public @Data class Formulario extends Componente implements IFormulario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Formulario(){}
	
	@Override
	public String getTemplate() {
		return "form";
	}

	
}
