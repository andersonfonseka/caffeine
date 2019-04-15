package com.andersonfonseka.caffeine.componentes;

import java.util.List;
import java.util.Map;

public interface IComponente {

	void setComponenteFabrica(IComponenteFabrica componenteFabrica);
	
	String getId();
	
	List<IComponente> getComponentes();
	
	void setParent(String parentName);
	
	String getParent();
	
	IComponente adicionar(IComponente component);
	
	String gerarSaida();
	
	String getTemplate();
	
	void aoCarregar(Map<String, String> parametros);

}
