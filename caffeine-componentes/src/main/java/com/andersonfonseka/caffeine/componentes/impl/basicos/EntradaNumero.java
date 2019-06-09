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
	
	public List<String> validar() {
			
		getMensagens().addAll(super.validar());	
		
		IntegerValidator integerValidator = IntegerValidator.getInstance();
		
		if (!integerValidator.isValid(getValor())) {
			getMensagens().add(new MensagemUtil().getMensagemPropriedades("NUMBERFIELD", getTitulo()));
		}
		
		return getMensagens();
	}

}
