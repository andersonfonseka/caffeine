package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.ITabela;

public class Tabela extends Componente implements ITabela {

	private static final long serialVersionUID = 1L;

	@Override
	public String getTemplate() {
		return "table";
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}

}
