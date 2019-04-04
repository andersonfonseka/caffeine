package com.andersonfonseka.caffeine.componente;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class Selecao extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6966867488997712703L;

	private Integer size;
	
	private Integer maxLength;
	
	private OpcaoSelecao selected;
	
	public Selecao() {
		add(new OpcaoSelecao("", "Selecione..."));
	}
	
	private OpcaoSelecao getSelected() {
		
		for(Componente component: getComponents()) {
			OpcaoSelecao selectOption = (OpcaoSelecao) component;
			if (selectOption.getValue().equals(getValor())) {
				selectOption.setSelected(true);
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
		// TODO Auto-generated method stub
		super.setValor(value);
		getSelected();
	}

	
	
}
