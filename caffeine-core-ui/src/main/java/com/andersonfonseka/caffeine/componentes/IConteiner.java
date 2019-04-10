package com.andersonfonseka.caffeine.componentes;

import java.util.List;

import com.andersonfonseka.caffeine.componentes.impl.Conteiner;

public interface IConteiner extends IComponente {
	
	public Conteiner add(Integer row, IComponente component);
	
	public List<IComponente> get(Integer row);
	
}
