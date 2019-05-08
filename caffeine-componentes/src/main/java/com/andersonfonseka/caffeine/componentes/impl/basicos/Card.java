package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.ICard;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Card extends Componente implements ICard {

	private static final long serialVersionUID = 4099784173983962979L;
	
	private String titulo;
	
	private String texto;
	
	private String imagem;
	
	@Override
	public String getTemplate() {
		return "card";
	}
}
