package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.andersonfonseka.caffeine.IEntrada;
import com.andersonfonseka.caffeine.componentes.impl.Componente;
import com.andersonfonseka.caffeine.util.MensagemUtil;
import com.andersonfonseka.caffeine.validador.IValidador;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public abstract @Data class Entrada extends Componente implements IEntrada, IValidador {
	
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
	
	public void aoCarregar(Map<String, Object> parametros) {
		if (parametros.containsKey(this.getId())) {
			this.setValor(String.valueOf(parametros.get(this.getId())));	
		}
	}

}
