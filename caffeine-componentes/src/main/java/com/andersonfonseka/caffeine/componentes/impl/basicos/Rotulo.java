package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.Map;

import com.andersonfonseka.caffeine.IRotulo;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Rotulo extends Componente implements IRotulo {

	private static final long serialVersionUID = 4099784173983962979L;
	
	private String titulo;
	
	private boolean negrito;
	
	public Rotulo(){}
	
	@Override
	public String getTemplate() {
		return "label";
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
}
