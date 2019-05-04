package com.andersonfonseka.caffeine;

import java.util.List;

public interface ITipoValor extends IConteiner {
	
	public IEntradaTexto getTxValor();

	public IBotao getBtnAdicionar();
	
	public ISelecao getSelTipo();
	
	public List getListaValores();
	
}
