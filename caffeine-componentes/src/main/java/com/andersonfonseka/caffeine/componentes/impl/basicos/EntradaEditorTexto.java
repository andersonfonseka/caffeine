package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IEntradaEditorTexto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class EntradaEditorTexto extends Entrada implements IEntradaEditorTexto {

	private static final long serialVersionUID = 804581724923409128L;

	private Integer rows;
	
	@Override
	public String getTemplate() {
		return "inputtexteditor";
	}
	
}
