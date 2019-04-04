package com.andersonfonseka.caffeine.componente;

import com.andersonfonseka.caffeine.componente.validador.Validador;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

public abstract @Data class Entrada extends Componente implements Validador {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String titulo;
	
	private String valor = "";
	
	private boolean obrigatorio;

	@Override
	public String validate() {
		
		if (obrigatorio && valor.trim().length() == 0) {
			return MensagemUtil.getInstance().getMessage("REQUIREDFIELD", getTitulo());
		}
		return "";
	}

}
