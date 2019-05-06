package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IMenuItem;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class MenuItem extends Componente implements IMenuItem {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private transient AcaoAbs acao;
	
	private boolean imediato = true;
	
	@Override
	public String getTemplate() {
		return "menuitem";
	}

	public IResposta doClick() {
		return this.acao.execute();
	}

}
