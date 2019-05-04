package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IFormulario;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Formulario extends Componente implements IFormulario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getTemplate() {
		return "form";
	}

	
	
}
