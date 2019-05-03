package com.andersonfonseka.caffeine;

import java.util.List;

public interface IEntrada extends IComponente {
	
	void setValor(String pValor);
	
	String getValor();
	
	List<String> validar();
	
	boolean isObrigatorio();

}
