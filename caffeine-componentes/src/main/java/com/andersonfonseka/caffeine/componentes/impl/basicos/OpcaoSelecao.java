package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.List;
import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IOpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class OpcaoSelecao extends Componente implements IOpcaoSelecao {

	private static final long serialVersionUID = -5853745218310142769L;

	private String valor;
	
	private String rotulo;
	
	private boolean selecionado;

	public OpcaoSelecao(String valor, String rotulo) {
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
	public boolean isObrigatorio() {
		return false;
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
}