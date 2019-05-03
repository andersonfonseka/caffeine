package com.andersonfonseka.caffeine;

import java.util.List;

import com.andersonfonseka.caffeine.componentes.ConteinerEnum;

public interface IConteiner extends IComponente {
	
	public void setOrientacao(ConteinerEnum orientacao);
	
	public IConteiner adicionar(Integer row, IComponente component);
	
	public List<IComponente> get(Integer row);
	
}
