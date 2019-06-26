package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaEditorTexto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaEditorTexto extends Entrada implements IEntradaEditorTexto {

	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	private EntradaEditorTexto() {}
	
	@Override
	public String getTemplate() {
		return "inputtexteditor";
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
		
		public IEntradaEditorTexto build() {
			
			EntradaEditorTexto entradaEditorTexto = new EntradaEditorTexto();
			entradaEditorTexto.setTitulo(titulo);
			entradaEditorTexto.setObrigatorio(obrigatorio);
			entradaEditorTexto.setRows(linhas);
			
			return entradaEditorTexto;
			
		}
		
		
	}
	
}
