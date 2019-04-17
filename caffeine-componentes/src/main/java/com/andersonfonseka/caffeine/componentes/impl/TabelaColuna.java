package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.ITabelaColuna;

import lombok.Data;

public @Data class TabelaColuna extends Componente implements ITabelaColuna {

	private String titulo;
	
	private String campo;
	
	private String valor;
	
	TabelaColuna(){}
	
	public String getValor() {
		return "";
	}

	@Override
	public String getTemplate() {
		return null;
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}
	
	
}
