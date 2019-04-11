package com.andersonfonseka.caffeine.componentes;

import java.util.List;

public interface IComponente {

	String getId();
	
	List<IComponente> getComponentes();
	
	void setParent(String parentName);
	
	String getParent();
	
	IComponente adicionar(IComponente component);
	
	String gerarSaida();
	
	String getTemplate();

}
