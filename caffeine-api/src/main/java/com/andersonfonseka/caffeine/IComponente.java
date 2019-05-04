package com.andersonfonseka.caffeine;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IComponente extends Serializable {

	void setComponenteFabrica(IComponenteFabrica componenteFabrica);
	
	String getId();
	
	List<IComponente> getComponentes();
	
	void setParent(String parentName);
	
	String getParent();
	
	IComponente adicionar(IComponente component);
	
	String gerarSaida();
	
	String getTemplate();
	
	void aoCarregar(Map<String, Object> parametros);

}
