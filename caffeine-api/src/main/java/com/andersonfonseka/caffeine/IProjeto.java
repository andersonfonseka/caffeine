package com.andersonfonseka.caffeine;

public interface IProjeto extends IComponente {
	
	void setTitulo(String titulo);
	
	IPagina obterPaginaPeloId(String id);
	
	IPagina getPaginaInicial();
	
	void setPaginaInicial(Class<? extends IPagina> pagina);
	
	String getTitulo();
	
}
