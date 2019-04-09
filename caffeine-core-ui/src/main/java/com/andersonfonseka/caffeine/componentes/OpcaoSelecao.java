package com.andersonfonseka.caffeine.componentes;

import lombok.Data;

public @Data class OpcaoSelecao extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853745218310142769L;

	private String value;
	
	private String label;
	
	private boolean selected;

	public OpcaoSelecao(String value, String label) {
		super();
		this.value = value;
		this.label = label;
	}
	
	
	
}
