package com.andersonfonseka.caffeine.componentes.impl;

import com.andersonfonseka.caffeine.componentes.IEntradaSenha;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data class EntradaSenha extends Entrada implements IEntradaSenha {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 592825479279322462L;
	
	EntradaSenha(){}
	
	@Override
	public String getTemplate() {
		return "inputpassword";
	}
	
}
