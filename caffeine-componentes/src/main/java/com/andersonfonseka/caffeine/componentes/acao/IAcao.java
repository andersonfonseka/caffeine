package com.andersonfonseka.caffeine.componentes.acao;

import com.andersonfonseka.caffeine.componentes.IResposta;

import lombok.Getter;

public abstract class IAcao {
	
	private @Getter Object source;
	
	public IAcao(Object source) {
		super();
		this.source = source;
	}
	
	public abstract IResposta execute();

}
