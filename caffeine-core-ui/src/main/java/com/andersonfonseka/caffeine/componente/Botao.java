package com.andersonfonseka.caffeine.componente;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componente.acao.Acao;
import com.andersonfonseka.caffeine.servlet.PaginaResposta;

import lombok.Data;

@Model
public @Data class Botao extends Componente {

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

	public PaginaResposta doClick() {
		return this.acao.execute();
	}

}
