package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;

import com.andersonfonseka.caffeine.IEntradaEmail;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaEmail extends Entrada implements IEntradaEmail {

	private static final long serialVersionUID = -9151902940785641660L;
	
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

}
