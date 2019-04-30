package com.andersonfonseka.caffeine.componentes.impl.mock;

import java.util.Map;

import javax.enterprise.context.SessionScoped;

import com.andersonfonseka.caffeine.componentes.impl.basicos.Projeto;

@SessionScoped
public class ClienteProjeto extends Projeto {
	
	private static final long serialVersionUID = 1L;

	public ClienteProjeto() {
		setTitulo("Caffeine Hello World!");
		setPaginaInicial(AcessoPagina.class);
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
}
