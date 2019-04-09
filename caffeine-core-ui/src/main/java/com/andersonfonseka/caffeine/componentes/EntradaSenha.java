package com.andersonfonseka.caffeine.componentes;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class EntradaSenha extends Entrada {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 592825479279322462L;

	private Integer size;
	
	private Integer maxLength;
	
	@Override
	public String getTemplate() {
		return "inputpassword";
	}

}
