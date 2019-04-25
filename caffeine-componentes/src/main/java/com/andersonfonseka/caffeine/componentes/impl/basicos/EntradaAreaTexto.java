package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.componentes.IEntradaAreaTexto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaAreaTexto extends Entrada implements IEntradaAreaTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	public EntradaAreaTexto(){}
	
	@Override
	public String getTemplate() {
		return "inputtextarea";
	}
	
}
