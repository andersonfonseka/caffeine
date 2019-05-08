package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaArquivo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaArquivo extends Entrada implements IEntradaArquivo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439811151946472472L;
	
	EntradaOculta entradaOculta;
	
	public EntradaArquivo() {
		
		entradaOculta = new EntradaOculta();
		entradaOculta.setId(this.getId() +"_hidden");
		adicionar(entradaOculta);
	}
	
	@Override
	public String getTemplate() {
		return "inputfile";
	}
	
	

}
