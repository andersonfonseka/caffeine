package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.ISelecao;

import lombok.Data;

@Model
public @Data class Selecao extends Entrada implements ISelecao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6966867488997712703L;
	
	private OpcaoSelecao selected;
	
	Selecao() {
		add(new OpcaoSelecao("", "Selecione..."));
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
