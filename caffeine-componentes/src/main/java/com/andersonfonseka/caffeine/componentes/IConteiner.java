package com.andersonfonseka.caffeine.componentes;

import java.util.List;

import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;

public interface IConteiner extends IComponente {
	
	String COLUNAS = "colunas";
	
	String HORIZONTAL = "horizontal";
	
	public void setOrientacao(String orientacao);
	
	public Conteiner adicionar(Integer row, IComponente component);
	
	public List<IComponente> get(Integer row);
	
}
