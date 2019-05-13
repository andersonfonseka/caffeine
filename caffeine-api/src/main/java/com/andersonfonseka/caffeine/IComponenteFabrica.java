package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.inject.spi.BeanManager;

import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;

public interface IComponenteFabrica {

	ICard criarCard(String imagem, String titulo, String texto);
	
	IMenu criarMenu(String titulo);
	
	IMenuItem criarMenuItem(String titulo, AcaoAbs acao);
	
	ITabela criarTabela(String id);
	
	ITabelaColuna criarTabelaColuna(String titulo, String campo);
	
	ITabelaColuna criarTabelaColuna(String titulo, String campo, boolean selecionavel);
	
	void setBeanManager(BeanManager beanManager);
	
	IProjeto criarProjeto(String id);

	IResposta criarResposta();
	
	IBotao criarBotao(String titulo, AcaoAbs acao, boolean imediato);
	
	IBotao criarBotaoCancelar(Class<? extends IPagina> paginaDestino);
	
	IConteiner criarConteiner(Integer rows);
	
	IFormulario criarFormulario();
	
	IPagina criarPagina(String id);
	
	IEndereco criarEndereco(IPagina pagina);
	
	IEntradaAreaTexto criarEntradaAreaTexto(String titulo, boolean obrigatorio, int linhas);
	
	IEntradaData criarEntradaData(String titulo, String pattern, boolean obrigatorio);
	
	IEntradaTexto criarEntradaTexto(String titulo, boolean obrigatorio);
	
	IEntradaArquivo criarEntradaArquivo(String titulo, boolean obrigatorio);
	
	IEntradaEmail criarEntradaEmail(String titulo, boolean obrigatorio);
	
	IEntradaNumero criarEntradaNumero(String titulo, boolean obrigatorio);
	
	IEntradaSenha criarEntradaSenha(String titulo, boolean obrigatorio);
	
	IRotulo criarRotulo(String titulo);
	
	IOpcaoSelecao criarOpcaoSelecao(String valor, String rotulo);

	IEntradaCheckbox criarEntradaCheckbox(String titulo, String valor, boolean obrigatorio);
	
	IEntradaCheckbox criarEntradaCheckbox(String id, String titulo, String valor, boolean obrigatorio);
	
	ISelecao criarSelecao(String titulo, boolean obrigatorio);

	ISelecao criarSelecao(String titulo, AcaoAbs acao, boolean imediato);

	IEntradaOculta criarEntradaOculta(String valor);
	
	IEntradaOculta criarEntradaOculta(String id, String valor);

	IAcesso criarAcesso(IPagina pagina, Map<String, String> usuarios, Class<? extends IPagina> paginaDestino);

	ITipoValor criarTipoValor(IPagina pagina, ISelecao selecaoTipo);
}
