package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.Map;

import com.andersonfonseka.caffeine.ITabelaColuna;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class TabelaColuna extends Componente implements ITabelaColuna {

	private static final long serialVersionUID = 1L;

	private String titulo;
	
	private String campo;
	
	private boolean selecionavel;
	
	public String getValor() {
		return "";
	}

	@Override
	public String getTemplate() {
		return null;
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
	
	
}
