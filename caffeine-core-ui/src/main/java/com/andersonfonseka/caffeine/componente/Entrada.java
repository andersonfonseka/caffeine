package com.andersonfonseka.caffeine.componente;

import com.andersonfonseka.caffeine.componente.validador.Validador;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

public abstract @Data class Entrada extends Componente implements Validador {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String title;
	
	private String value = "";
	
	private boolean required;

	@Override
	public String validate() {
		
		if (required && value.trim().length() == 0) {
			return MensagemUtil.getInstance().getMessage("REQUIREDFIELD", getTitle());
		}
		return "";
	}

}
