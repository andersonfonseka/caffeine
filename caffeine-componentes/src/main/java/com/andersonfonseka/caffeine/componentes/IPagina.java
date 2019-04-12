package com.andersonfonseka.caffeine.componentes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPagina extends IComponente {
	
	Optional<IComponente> obterPorId(IComponente component, String id);

	void adicionaMensagem(String message);
	
	void aoCarregar(Map<String, String> parametros);
	
	void setMensagens(List<String> mensagens);
	
	List<String> getMensagens();
	
}
