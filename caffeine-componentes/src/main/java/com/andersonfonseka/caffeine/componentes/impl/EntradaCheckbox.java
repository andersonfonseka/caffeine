package com.andersonfonseka.caffeine.componentes.impl;

import com.andersonfonseka.caffeine.componentes.IEntradaCheckbox;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaCheckbox extends Entrada implements IEntradaCheckbox {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340908969483338598L;
	
	EntradaCheckbox(){}
	
	@Override
	public String getTemplate() {
		return "checkbox";
	}

}
