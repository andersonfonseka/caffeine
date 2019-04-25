package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Botao extends Componente implements IBotao {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private Componente origem;

	private AcaoAbs acao;
	
	private boolean imediato = false;
	
	public Botao(){}
	
	@Override
	public String getTemplate() {
		return "button";
	}

	public IResposta doClick() {
		return this.acao.execute();
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}

}
