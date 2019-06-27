package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.inject.spi.BeanManager;

public interface IComponenteFabrica {
	
	void setBeanManager(BeanManager beanManager);
	
	IProjeto criarProjeto(String id);
	
	IBotao criarBotaoCancelar(Class<? extends IPagina> paginaDestino);
	
	IConteiner criarConteiner(Integer rows);
	
	IPagina criarPagina(String id);
	
	IEndereco criarEndereco(IPagina pagina);

	IAcesso criarAcesso(IPagina pagina, Map<String, String> usuarios, Class<? extends IPagina> paginaDestino);

	ITipoValor criarTipoValor(IPagina pagina, ISelecao selecaoTipo);

}
