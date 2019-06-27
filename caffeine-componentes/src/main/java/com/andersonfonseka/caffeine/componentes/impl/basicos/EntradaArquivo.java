package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaArquivo;
import com.andersonfonseka.caffeine.IEntradaOculta;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaArquivo extends Entrada implements IEntradaArquivo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439811151946472472L;
	
	IEntradaOculta entradaOculta;
	
	private EntradaArquivo() {
		entradaOculta = new EntradaOculta.Builder(this.getId() +"_hidden", "").build();
		adicionar(entradaOculta);
	}
	
	@Override
	public String getTemplate() {
		return "inputfile";
	}
	
	public static class Builder {
		
		String titulo;
		boolean obrigatorio;
		
		public Builder(String titulo, boolean obrigatorio) {
			super();
			this.titulo = titulo;
			this.obrigatorio = obrigatorio;
		}

		public IEntradaArquivo build() {
			
			EntradaArquivo entradaArquivo = new EntradaArquivo();
			entradaArquivo.setTitulo(titulo);
			entradaArquivo.setObrigatorio(obrigatorio);
			
			return entradaArquivo;
		}
		
	}

}
