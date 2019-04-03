package com.andersonfonseka.caffeine.componente.acao;

import com.andersonfonseka.caffeine.servlet.PaginaResposta;

import lombok.Getter;

public abstract class Acao {
	
	private @Getter Object source;
	
	public Acao(Object source) {
		super();
		this.source = source;
	}
	
	public abstract PaginaResposta execute();

}
