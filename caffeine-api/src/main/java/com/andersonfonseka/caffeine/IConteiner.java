package com.andersonfonseka.caffeine;

import java.util.List;

public interface IConteiner extends IComponente {
	
	String COLUNAS = "colunas";
	
	String HORIZONTAL = "horizontal";
	
	public void setOrientacao(String orientacao);
	
	public IConteiner adicionar(Integer row, IComponente component);
	
	public List<IComponente> get(Integer row);
	
}
