package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IMenu;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Menu extends Componente implements IMenu {

	private static final long serialVersionUID = 1L;

	private String titulo;
	
	@Override
	public String getTemplate() {
		return "menu";
	}

}
