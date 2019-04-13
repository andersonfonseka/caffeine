package com.andersonfonseka.caffeine.componentes.impl;

import java.util.List;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IOpcaoSelecao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class OpcaoSelecao extends Componente implements IOpcaoSelecao {

	private static final long serialVersionUID = -5853745218310142769L;

	private String valor;
	
	private String rotulo;
	
	private boolean selecionado;

	OpcaoSelecao(String valor, String rotulo) {
		super();
		this.valor = valor;
		this.rotulo = rotulo;
	}

	@Override
	public List<String> validar() {
		return null;
	}

	@Override
	public String getTemplate() {
		return null;
	}

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}
	
}
