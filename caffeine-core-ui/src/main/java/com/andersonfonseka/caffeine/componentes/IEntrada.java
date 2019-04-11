package com.andersonfonseka.caffeine.componentes;

import java.util.List;

public interface IEntrada extends IComponente {
	
	public void setValor(String pValor);
	
	public List<String> validar();

}
