package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.List;

import org.apache.commons.validator.routines.IntegerValidator;

import com.andersonfonseka.caffeine.IEntradaNumero;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaNumero extends Entrada implements IEntradaNumero {

	private static final long serialVersionUID = -4340908969483338598L;
	
	@Override
	public String getTemplate() {
		return "inputnumber";
	}
	
	private EntradaNumero() {}
	
	public List<String> validar() {
			
		getMensagens().addAll(super.validar());	
		
		IntegerValidator integerValidator = IntegerValidator.getInstance();
		
		if (!integerValidator.isValid(getValor())) {
			getMensagens().add(new MensagemUtil().getMensagemPropriedades("NUMBERFIELD", getTitulo()));
		}
		
		return getMensagens();
	}
	
	public static class Builder {
		
		String titulo;
		boolean obrigatorio;
		
		public Builder(String titulo, boolean obrigatorio) {
			super();
			this.titulo = titulo;
			this.obrigatorio = obrigatorio;
		}
		
		public IEntradaNumero build() {
			
			EntradaNumero entradaNumero = new EntradaNumero();
			entradaNumero.setTitulo(titulo);
			entradaNumero.setObrigatorio(obrigatorio);
			
			return entradaNumero;

		}
	}
}
