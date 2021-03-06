package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.DateValidator;

import com.andersonfonseka.caffeine.IEntradaData;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public @Data class EntradaData extends Entrada implements IEntradaData {

	private static final long serialVersionUID = -3955625665174027266L;

	private String pattern;

	@Override
	public String getTemplate() {
		return "inputdate";
	}

	@Override
	public List<String> validar() {

		List<String> mensagens = new ArrayList<>();

		mensagens.addAll(super.validar());

		DateValidator dateValidator = DateValidator.getInstance();

		if (!dateValidator.isValid(getValor(), getPattern())) {
			mensagens.add(new MensagemUtil().getMensagemPropriedades("DATEFIELD", getTitulo()));
		}

		return mensagens;
	}

	public static class Builder {

		String titulo;
		String pattern;
		boolean obrigatorio;

		public Builder(String titulo, String pattern, boolean obrigatorio) {
			super();
			this.titulo = titulo;
			this.pattern = pattern;
			this.obrigatorio = obrigatorio;
		}

		public IEntradaData build() {

			EntradaData entradaData = new EntradaData();
			entradaData.setTitulo(titulo);
			entradaData.setPattern(pattern);
			entradaData.setObrigatorio(obrigatorio);

			return entradaData;
		}
	}
}
