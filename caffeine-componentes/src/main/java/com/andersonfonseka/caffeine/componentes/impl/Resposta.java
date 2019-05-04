package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IResposta;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Resposta implements IResposta {
	
	private List<String> mensagens = new ArrayList<>();
	
	private Map<String, Object> atributo = new HashMap<>();
	
	private Class<? extends IPagina> pageUrl;
	
	protected Resposta() {}

	public void adicionar(String message) {
		this.mensagens.add(message);
	}

	@Override
	public void setAtributo(String chave, Object valor) {
		this.atributo.put(chave, valor);
	}
	
}
