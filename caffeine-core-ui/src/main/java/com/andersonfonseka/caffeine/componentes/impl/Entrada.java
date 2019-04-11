package com.andersonfonseka.caffeine.componentes.impl;

import com.andersonfonseka.caffeine.componentes.validador.IValidador;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;

public abstract @Data class Entrada extends Componente implements IValidador {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String titulo;
	
	private String valor = "";
	
	private boolean obrigatorio;
	
	private Integer tamanho;
	
	private Integer comprimentoMaximo;

	@Override
	public String validar() {
		if (obrigatorio && valor.trim().length() == 0) {
			return new MensagemUtil().getMessage("REQUIREDFIELD", getTitulo());
		}
		return "";
	}

}
