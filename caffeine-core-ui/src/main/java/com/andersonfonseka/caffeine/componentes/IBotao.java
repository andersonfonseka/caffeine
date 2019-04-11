package com.andersonfonseka.caffeine.componentes;

public interface IBotao extends IComponente {
	
	public IResposta doClick();
	
	void setImediato(boolean imediato);
	
}
