package com.andersonfonseka.caffeine;

import java.util.List;

public interface ITabela extends IComponente {

	List getDados();
	
	void setDados(List<?> dados);
	
	public ITabela adicionaColuna(ITabelaColuna tabelaColuna);
}
