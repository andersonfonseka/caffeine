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
	
	private EntradaCheckbox() {}
	
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
	
	public static class Builder {
		
		String titulo;
		String valor;
		boolean obrigatorio;
		
		public Builder(String titulo, String valor, boolean obrigatorio) {
			super();
			this.titulo = titulo;
			this.valor = valor;
			this.obrigatorio = obrigatorio;
		}
		
		public IEntradaCheckbox build() {
			
			EntradaCheckbox entradaCheckbox = new EntradaCheckbox();
			entradaCheckbox.setTitulo(titulo);
			entradaCheckbox.setObrigatorio(obrigatorio);
			entradaCheckbox.setValor(valor);
			
			return entradaCheckbox;
			
		}
		
		
	}

}
