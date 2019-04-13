package com.andersonfonseka.caffeine.componentes.impl;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.ISelecao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Selecao extends Entrada implements ISelecao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6966867488997712703L;
	
	private OpcaoSelecao selected;
	
	Selecao() {
		adicionar(new OpcaoSelecao("", "Selecione..."));
	}
	
	private OpcaoSelecao getSelected() {
		
		for(IComponente component: getComponentes()) {
			OpcaoSelecao selectOption = (OpcaoSelecao) component;
			if (selectOption.getValor().equals(getValor())) {
				selectOption.setSelecionado(true);
				this.selected = selectOption;
				break;
			}
		} 
		
		return this.selected;
	}
	
	@Override
	public String getTemplate() {
		return "select";
	}

	@Override
	public void setValor(String value) {
		super.setValor(value);
		getSelected();
	}
	
}
