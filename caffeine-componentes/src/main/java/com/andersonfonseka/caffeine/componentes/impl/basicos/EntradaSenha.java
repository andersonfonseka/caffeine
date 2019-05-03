package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaSenha;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaSenha extends Entrada implements IEntradaSenha {
	
	private static final long serialVersionUID = 592825479279322462L;
	
	public EntradaSenha(){}
	
	@Override
	public String getTemplate() {
		return "inputpassword";
	}
	
}
