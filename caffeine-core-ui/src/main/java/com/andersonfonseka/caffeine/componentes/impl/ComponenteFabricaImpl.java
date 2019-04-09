package com.andersonfonseka.caffeine.componentes.impl;

import com.andersonfonseka.caffeine.componentes.ComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.acao.Acao;

public class ComponenteFabricaImpl extends ComponenteFabrica {

	public IBotao criarBotao(String titulo, Acao acao, boolean imediato) {
		
		Botao botao = new Botao();
			  botao.setImediato(imediato);
			  botao.setTitulo(titulo);
			  botao.setAcao(acao);
		
		return botao;
	}
	
	
}
