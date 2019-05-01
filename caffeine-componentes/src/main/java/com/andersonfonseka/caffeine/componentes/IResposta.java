package com.andersonfonseka.caffeine.componentes;

import java.util.List;
import java.util.Map;

public interface IResposta {

	void adicionar(String message);
	
	Class<?extends IPagina> getPageUrl();
	
	void setPageUrl(Class<? extends IPagina> clazz);
	
	List<String> getMensagens();
	
	void setAtributo(String chave, Object valor);
	
	Map<String, Object> getAtributo();
	
}
