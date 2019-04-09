package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.acao.Acao;
import com.andersonfonseka.caffeine.servlet.Resposta;

import lombok.Data;

@Model
public @Data class Botao extends Componente implements IBotao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String titulo;

	private Componente origem;

	private Acao acao;
	
	private boolean imediato;
	
	@Override
	public String getTemplate() {
		return "button";
	}

	public Resposta doClick() {
		return this.acao.execute();
	}

}
