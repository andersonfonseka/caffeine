package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IEntradaAreaTexto;

import lombok.Data;

@Model
public @Data class EntradaAreaTexto extends Entrada implements IEntradaAreaTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	private Integer maxLength;
	
	EntradaAreaTexto(){}
	
	@Override
	public String getTemplate() {
		return "inputtextarea";
	}

	
}
