package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.inject.spi.BeanManager;

import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;

public interface IComponenteFabrica {
	
	void setBeanManager(BeanManager beanManager);
	
	IProjeto criarProjeto(String id);
	
	IBotao criarBotaoCancelar(Class<? extends IPagina> paginaDestino);
	
	IConteiner criarConteiner(Integer rows);
	
	IPagina criarPagina(String id);
	
	IEndereco criarEndereco(IPagina pagina);

	IAcesso criarAcesso(IPagina pagina, Map<String, String> usuarios, Class<? extends IPagina> paginaDestino);

	ITipoValor criarTipoValor(IPagina pagina, ISelecao selecaoTipo);

	// ---------------------------------------------------------------------------------------
	
	IOpcaoSelecao criarOpcaoSelecao(String valor, String rotulo);
	
	ISelecao criarSelecao(String titulo, boolean obrigatorio);

	ISelecao criarSelecao(String titulo, AcaoAbs acao, boolean imediato);

	IEntradaOculta criarEntradaOculta(String valor);
	
	IEntradaOculta criarEntradaOculta(String id, String valor);

}
