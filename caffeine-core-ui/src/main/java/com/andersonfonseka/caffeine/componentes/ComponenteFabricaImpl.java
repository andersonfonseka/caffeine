package com.andersonfonseka.caffeine.componentes;

import com.andersonfonseka.caffeine.componentes.acao.Acao;
import com.andersonfonseka.caffeine.componentes.impl.Botao;

public class ComponenteFabricaImpl extends ComponenteFabrica {

	public IBotao criarBotao(String titulo, Acao acao, boolean imediato) {
		
		Botao botao = new Botao();
			  botao.setImediato(imediato);
			  botao.setTitulo(titulo);
			  botao.setAcao(acao);
		
		return botao;
	}
	
	
}
