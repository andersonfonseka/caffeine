package com.andersonfonseka.caffeine.componentes.impl;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.IAcao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Botao extends Componente implements IBotao {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private Componente origem;

	private IAcao acao;
	
	private boolean imediato = false;
	
	Botao(){}
	
	@Override
	public String getTemplate() {
		return "button";
	}

	public IResposta doClick() {
		return this.acao.execute();
	}

}
