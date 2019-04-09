package com.andersonfonseka.caffeine.componentes.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public abstract @Data class Pagina extends Componente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5766132691862009035L;

	private String titulo;
	
	private List<String> mensagens = new ArrayList<String>();
	
	public Pagina() {
		internalId = 1;
	}
	
	@Override
	public String getTemplate() {
		return "page";
	}
	
	public void adicionaMensagem(String message) {
		if (message.length() > 0) {
			this.mensagens.add(message);	
		}
	}
	
	
	public abstract void aoCarregar(Map<String, String> parametros);
	
	
}
