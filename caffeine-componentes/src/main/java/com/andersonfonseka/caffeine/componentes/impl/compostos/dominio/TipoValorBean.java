package com.andersonfonseka.caffeine.componentes.impl.compostos.dominio;

import lombok.Data;

public @Data class TipoValorBean {
	
	private String tipo;
	
	private String valor;

	@Override
	public String toString() {
		return tipo + "#" + valor + ";";
	}
	
}
