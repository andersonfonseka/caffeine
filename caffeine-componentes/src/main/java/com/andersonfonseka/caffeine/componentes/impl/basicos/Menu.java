package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IMenu;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Menu extends Componente implements IMenu {

	private static final long serialVersionUID = 1L;

	private String titulo;
	
	private Menu() {}
	
	@Override
	public String getTemplate() {
		return "menu";
	}
	
	public static class Builder {
		
		String titulo;
		
		public Builder(String titulo) {
			super();
			this.titulo = titulo;
		}
		
		public IMenu build() {

			Menu menu = new Menu();
			menu.setTitulo(titulo);
			return menu;
		}
		
	}

}
