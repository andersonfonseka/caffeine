package com.andersonfonseka.caffeine.componentes;

import java.util.List;

public interface IComponente {

	String getId();
	
	List<IComponente> getComponentes();
	
	void setParent(String parentName);
	
	IComponente add(IComponente component);
	
	String doRender();
	
}
