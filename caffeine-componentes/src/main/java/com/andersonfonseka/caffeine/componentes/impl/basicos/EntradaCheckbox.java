package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaCheckbox;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class EntradaCheckbox extends Entrada implements IEntradaCheckbox {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340908969483338598L;
	
	private boolean checked = false;
	
	@Override
	public String getTemplate() {
		return "checkbox";
	}

	@Override
	public void setChecked(boolean value) {
		this.checked = value;
	}

	@Override
	public boolean isChecked() {
		return this.checked;
	}

}
