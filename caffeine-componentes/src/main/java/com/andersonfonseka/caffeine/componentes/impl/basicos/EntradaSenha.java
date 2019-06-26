package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaSenha;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaSenha extends Entrada implements IEntradaSenha {
	
	private static final long serialVersionUID = 592825479279322462L;
	
	private EntradaSenha() {}
	
	@Override
	public String getTemplate() {
		return "inputpassword";
	}
	
	public static class Builder {
		
		String titulo;
		boolean obrigatorio;
		
		public Builder(String titulo, boolean obrigatorio) {
			super();
			this.titulo = titulo;
			this.obrigatorio = obrigatorio;
		}
		
		public IEntradaSenha build() {
			
			EntradaSenha entradaSenha = new EntradaSenha();
			entradaSenha.setTitulo(titulo);
			entradaSenha.setObrigatorio(obrigatorio);
			
			return entradaSenha;

		}
	}
	
}
