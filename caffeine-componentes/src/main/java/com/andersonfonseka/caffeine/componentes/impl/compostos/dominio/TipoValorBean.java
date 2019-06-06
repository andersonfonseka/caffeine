package com.andersonfonseka.caffeine.componentes.impl.compostos.dominio;

import java.util.UUID;

import lombok.Data;

public @Data class TipoValorBean {
	
	private String id = UUID.randomUUID().toString();
	
	private String tipo;
	
	private String valor;

	@Override
	public String toString() {
		return getId() + "#" + getTipo() + "#" + getValor() + ";";
	}
	
}
