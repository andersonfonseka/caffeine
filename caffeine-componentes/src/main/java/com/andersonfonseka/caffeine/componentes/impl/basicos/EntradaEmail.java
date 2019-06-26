package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;

import com.andersonfonseka.caffeine.IEntradaEmail;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public @Data class EntradaEmail extends Entrada implements IEntradaEmail {

	private static final long serialVersionUID = -9151902940785641660L;

	@Override
	public String getTemplate() {
		return "inputemail";
	}

	@Override
	public List<String> validar() {

		getMensagens().addAll(super.validar());

		EmailValidator emailValidator = EmailValidator.getInstance();

		if (!emailValidator.isValid(getValor())) {
			getMensagens().add(new MensagemUtil().getMensagemPropriedades("EMAILFIELD", getTitulo()));
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

		public IEntradaEmail build() {

			EntradaEmail entradaEmail = new EntradaEmail();
			entradaEmail.setTitulo(titulo);
			entradaEmail.setObrigatorio(obrigatorio);

			return entradaEmail;
		}

	}
}
