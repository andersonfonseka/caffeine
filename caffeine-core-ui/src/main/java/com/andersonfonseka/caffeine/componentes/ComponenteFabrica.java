package com.andersonfonseka.caffeine.componentes;

import com.andersonfonseka.caffeine.componentes.acao.Acao;

public abstract class ComponenteFabrica {
	
	public static ComponenteFabrica obterInstancia() {
		return new ComponenteFabricaImpl();
	}

	public abstract IBotao criarBotao(String titulo, Acao acao, boolean imediato);
	
	
}
