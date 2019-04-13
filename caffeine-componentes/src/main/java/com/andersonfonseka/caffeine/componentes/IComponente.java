package com.andersonfonseka.caffeine.componentes;

import java.util.List;

public interface IComponente {

	void setComponenteFabrica(IComponenteFabrica componenteFabrica);
	
	String getId();
	
	List<IComponente> getComponentes();
	
	void setParent(String parentName);
	
	String getParent();
	
	IComponente adicionar(IComponente component);
	
	String gerarSaida();
	
	String getTemplate();

}
