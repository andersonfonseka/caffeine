package com.andersonfonseka.caffeine;

import javax.enterprise.context.SessionScoped;

import com.andersonfonseka.caffeine.componentes.Projeto;

@SessionScoped
public class ClienteProjeto extends Projeto {
	
	private static final long serialVersionUID = 1L;

	public ClienteProjeto() {
		setTitulo("Caffeine Hello World!");
		setPaginaInicial(AcessoPagina.class);
	}
}
