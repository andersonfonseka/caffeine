package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IFormulario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Model
@EqualsAndHashCode(callSuper=false)
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

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}

	
}
