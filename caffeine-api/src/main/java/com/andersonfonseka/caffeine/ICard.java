package com.andersonfonseka.caffeine;

public interface ICard extends IComponente {
	
	public String getTitulo();
	
	public String getTexto();
	
	public String getImagem();
	
	public void setBotao(IBotao botao);
	
}
