package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.validator.routines.EmailValidator;

import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data class EntradaEmail extends Entrada implements IEntradaEmail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9151902940785641660L;
	
	EntradaEmail(){}
	
	@Override
	public String getTemplate() {
		return "inputemail";
	}
	
	@Override
	public List<String> validar() {
		
		List<String> mensagens = new ArrayList<String>();
		
		mensagens.addAll(super.validar());	
		
		EmailValidator emailValidator = EmailValidator.getInstance();
		
		if (!emailValidator.isValid(getValor())){
			mensagens.add(new MensagemUtil().getMensagemPropriedades("EMAILFIELD", getTitulo()));	
		}
		
		return mensagens;
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {
		// TODO Auto-generated method stub
		
	}

}
