package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.caffeine.componentes.IResposta;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Resposta implements IResposta {
	
	List<String> mensagens = new ArrayList<String>();
	
	String pageUrl;
	
	protected Resposta() {}

	public void adicionar(String message) {
		this.mensagens.add(message);
	}
	
}
