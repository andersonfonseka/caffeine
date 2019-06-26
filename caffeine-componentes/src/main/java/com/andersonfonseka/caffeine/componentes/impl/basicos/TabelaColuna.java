package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.ITabelaColuna;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class TabelaColuna extends Componente implements ITabelaColuna {

	private static final long serialVersionUID = 1L;

	private String titulo;
	
	private String campo;
	
	private boolean selecionavel;
	
	private TabelaColuna() {}
	
	public String getValor() {
		return "";
	}

	@Override
	public String getTemplate() {
		return null;
	}
	
	public static class Builder {

		private String titulo;
		
		private String campo;
		
		private boolean selecionavel;

		public Builder(String titulo, String campo, boolean selecionavel) {
			super();
			this.titulo = titulo;
			this.campo = campo;
			this.selecionavel = selecionavel;
		}

		public ITabelaColuna build() {

			TabelaColuna tabelaColuna = new TabelaColuna();
			
			tabelaColuna.setTitulo(titulo);
			tabelaColuna.setCampo(campo);
			tabelaColuna.setSelecionavel(selecionavel);
			
			return tabelaColuna;

		}
	}
}
