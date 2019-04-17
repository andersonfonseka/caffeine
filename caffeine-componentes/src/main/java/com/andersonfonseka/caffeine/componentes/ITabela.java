package com.andersonfonseka.caffeine.componentes;

import java.util.List;

public interface ITabela extends IComponente {

	void setDados(List dados);
	
	public ITabela adicionaColuna(ITabelaColuna tabelaColuna);
}
