package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.caffeine.componentes.validador.IValidador;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public abstract @Data class Entrada extends Componente implements IValidador {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String titulo;
	
	private String valor = "";
	
	private boolean obrigatorio;
	
	private Integer tamanho;
	
	private Integer comprimentoMaximo;
	
	@Override
	public List<String> validar() {
		
		List<String> mensagens = new ArrayList<String>();
		
		if (obrigatorio && valor.trim().length() == 0) {
			mensagens.add(new MensagemUtil().getMensagemPropriedades("REQUIREDFIELD", getTitulo()));
		}
		return mensagens;
	}

}
