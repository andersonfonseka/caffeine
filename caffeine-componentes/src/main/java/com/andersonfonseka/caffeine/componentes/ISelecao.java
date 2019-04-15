package com.andersonfonseka.caffeine.componentes;

import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;

public interface ISelecao extends IEntrada, IAcao {
	
	IOpcaoSelecao getselecionado();
	
	AcaoAbs getAcao();

}
