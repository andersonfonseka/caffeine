package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaAreaTexto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaAreaTexto extends Entrada implements IEntradaAreaTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	private EntradaAreaTexto() {}
	
	@Override
	public String getTemplate() {
		return "inputtextarea";
	}
	
	public static class Builder {
		
		String titulo;
		boolean obrigatorio;
		int linhas;
		
		public Builder(String titulo, boolean obrigatorio, int linhas) {
			super();
			this.titulo = titulo;
			this.obrigatorio = obrigatorio;
			this.linhas = linhas;
		}
		
		public IEntradaAreaTexto build() {
			
			EntradaAreaTexto entradaAreaTexto = new EntradaAreaTexto();
			entradaAreaTexto.setTitulo(titulo);
			entradaAreaTexto.setObrigatorio(obrigatorio);
			entradaAreaTexto.setRows(linhas);
			
			return entradaAreaTexto;

			
		}
		
	}
	
}
