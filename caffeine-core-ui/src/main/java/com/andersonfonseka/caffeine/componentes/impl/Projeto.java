package com.andersonfonseka.caffeine.componentes.impl;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IPagina;

import lombok.Data;
import lombok.EqualsAndHashCode;

@ApplicationScoped
@EqualsAndHashCode(callSuper=false)
public abstract @Data class Projeto extends Componente {

	private static final long serialVersionUID = -220945867939169696L;

	@Inject
	private IComponenteFabrica componenteFabrica;
	
	private String titulo;

	private Class<? extends IPagina> paginaInicial;

	private Map<String, Class<? extends IPagina>> paginas = new HashMap<String, Class<? extends IPagina>>();

	public Projeto() {}

	@Override
	public String getTemplate() {
		return "project";
	}

	public Projeto adicionar(Class<? extends IPagina> page) {
		this.paginas.put(page.getName(), page);
		return this;
	}

	public IPagina obterPaginaPeloId(String id) {
		return componenteFabrica.criarPagina(id);
		
	}

	public IPagina getPaginaInicial() {
		return obterPaginaPeloId(this.paginaInicial.getName());
	}

}
