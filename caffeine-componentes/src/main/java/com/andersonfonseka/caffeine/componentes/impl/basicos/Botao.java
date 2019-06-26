package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Botao extends Componente implements IBotao {

	private static final long serialVersionUID = 1L;

	private String titulo;
	
	private String estilo = "";

	private Componente origem;

	private transient AcaoAbs acao;
	
	private boolean imediato = false;
	
	private Botao() {}
	
	@Override
	public String getTemplate() {
		return "button";
	}
	
	public String getEstilo() {
		
		if (this.estilo.trim().length() == 0) {
			return "btn-primary";
		}
		
		return this.estilo;
	}

	public IResposta doClick() {
		return this.acao.execute();
	}

	public static class Builder {
		
		String titulo;
		AcaoAbs acao;
		boolean imediato;
		public Builder(String titulo, AcaoAbs acao, boolean imediato) {
			super();
			this.titulo = titulo;
			this.acao = acao;
			this.imediato = imediato;
		}
		
		public IBotao build() {
			
			Botao botao = new Botao();
			  botao.setImediato(imediato);
			  botao.setTitulo(titulo);
			  botao.setAcao(acao);
		
			  return botao;
			
		}
		
	}
	
}
