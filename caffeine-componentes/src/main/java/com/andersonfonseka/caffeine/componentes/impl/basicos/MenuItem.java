package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IMenuItem;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public @Data class MenuItem extends Componente implements IMenuItem {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private transient AcaoAbs acao;

	private boolean imediato = true;

	private MenuItem() {}
	
	@Override
	public String getTemplate() {
		return "menuitem";
	}

	public IResposta doClick() {
		return this.acao.execute();
	}

	public static class Builder {

		String titulo;
		
		transient AcaoAbs acao;

		boolean imediato = true;

		public Builder(String titulo, AcaoAbs acao, boolean imediato) {
			super();
			this.titulo = titulo;
			this.acao = acao;
			this.imediato = imediato;
		}

		public IMenuItem build() {

			MenuItem menuItem = new MenuItem();
			menuItem.setTitulo(titulo);
			menuItem.setAcao(acao);
			menuItem.setImediato(imediato);
			
			return menuItem;
		}
	}

}
