package com.andersonfonseka.caffeine.componentes;

import java.util.List;

import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;

public interface IConteiner extends IComponente {
	
	public Conteiner adicionar(Integer row, IComponente component);
	
	public List<IComponente> get(Integer row);
	
}
