package com.andersonfonseka.caffeine.componentes;

import java.util.List;

public interface IResposta {

	void adicionar(String message);
	
	String getPageUrl();
	
	void setPageUrl(String endereco);
	
	List<String> getMensagens();
	
}
