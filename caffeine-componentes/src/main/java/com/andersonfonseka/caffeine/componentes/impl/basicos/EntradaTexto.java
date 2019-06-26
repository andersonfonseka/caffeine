package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaTexto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaTexto extends Entrada implements IEntradaTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340908969483338598L;
	
	private EntradaTexto() {}
	
	@Override
	public String getTemplate() {
		return "inputtext";
	}
	
	public static class Builder {
		
		String titulo;
		boolean obrigatorio;
		
		public Builder(String titulo, boolean obrigatorio) {
			super();
			this.titulo = titulo;
			this.obrigatorio = obrigatorio;
		}
		
		public IEntradaTexto build() {
			
			EntradaTexto entradaTexto = new EntradaTexto();
			entradaTexto.setTitulo(titulo);
			entradaTexto.setObrigatorio(obrigatorio);
			
			return entradaTexto;
		}
	}
}
