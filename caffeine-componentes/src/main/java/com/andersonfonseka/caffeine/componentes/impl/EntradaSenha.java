package com.andersonfonseka.caffeine.componentes.impl;

import java.util.List;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntradaSenha;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Model
@EqualsAndHashCode(callSuper=false)
@Data class EntradaSenha extends Entrada implements IEntradaSenha {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 592825479279322462L;
	
	EntradaSenha(){}
	
	@Override
	public String getTemplate() {
		return "inputpassword";
	}

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}
}
