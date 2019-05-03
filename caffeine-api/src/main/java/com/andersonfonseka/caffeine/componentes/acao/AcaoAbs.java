package com.andersonfonseka.caffeine.componentes.acao;

import com.andersonfonseka.caffeine.IResposta;

import lombok.Getter;

public abstract class AcaoAbs {
	
	private @Getter Object source;
	
	public AcaoAbs(Object source) {
		super();
		this.source = source;
	}
	
	public abstract IResposta execute();

}
