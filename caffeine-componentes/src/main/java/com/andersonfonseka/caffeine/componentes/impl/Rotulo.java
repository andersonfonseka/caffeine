package com.andersonfonseka.caffeine.componentes.impl;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IRotulo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
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

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}

	
}
