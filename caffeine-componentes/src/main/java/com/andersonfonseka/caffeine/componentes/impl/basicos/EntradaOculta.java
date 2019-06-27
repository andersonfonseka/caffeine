package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaOculta;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaOculta extends Entrada implements IEntradaOculta {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340908969483338598L;
	
	private EntradaOculta() {}
	
	@Override
	public String getTemplate() {
		return "inputhidden";
	}

	public static class Builder {

		String id;
		String valor;

		public Builder(String id, String valor) {
			super();
			this.id = id;
			this.valor = valor;
		}

		public IEntradaOculta build() {
			EntradaOculta entradaOculta = new EntradaOculta();
			entradaOculta.setId(id);
			entradaOculta.setValor(valor);
			
			return entradaOculta;
		}
	}
}
