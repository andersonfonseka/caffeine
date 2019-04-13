package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntradaArquivo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Model
@EqualsAndHashCode(callSuper=false)
public @Data class EntradaArquivo extends Entrada implements IEntradaArquivo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439811151946472472L;
	
	EntradaArquivo(){}
	
	@Override
	public String getTemplate() {
		return "inputfile";
	}

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}

	
}
