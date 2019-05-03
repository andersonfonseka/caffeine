package com.andersonfonseka.caffeine;

import java.util.List;
import java.util.Optional;

public interface IPagina extends IComponente {

	String getTituloProjeto();
	
	void setTituloProjeto(String titulo);
	
	Optional<IComponente> obterPorId(IComponente component, String id);

	void adicionaMensagem(String message);
	
	void setMensagens(List<String> mensagens);
	
	List<String> getMensagens();
	
}
