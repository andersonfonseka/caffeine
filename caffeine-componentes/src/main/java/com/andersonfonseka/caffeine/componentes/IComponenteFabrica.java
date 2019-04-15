package com.andersonfonseka.caffeine.componentes;

import javax.enterprise.inject.spi.BeanManager;

import com.andersonfonseka.caffeine.componentes.acao.IAcao;

public interface IComponenteFabrica {
	
	void setBeanManager(BeanManager beanManager);
	
	IProjeto criarProjeto(String id);

	IResposta criarResposta();
	
	IBotao criarBotao(String titulo, IAcao acao, boolean imediato);
	
	IConteiner criarConteiner(Integer rows);
	
	IFormulario criarFormulario();
	
	IPagina criarPagina(String id);
	
	IEndereco criarEndereco();
	
	IEntradaAreaTexto criarEntradaAreaTexto(String titulo, boolean obrigatorio, int linhas);
	
	IEntradaData criarEntradaData(String titulo, String pattern, boolean obrigatorio);
	
	IEntradaTexto criarEntradaTexto(String titulo, boolean obrigatorio);
	
	IEntradaArquivo criarEntradaArquivo(String titulo, boolean obrigatorio);
	
	IEntradaEmail criarEntradaEmail(String titulo, boolean obrigatorio);
	
	IEntradaNumero criarEntradaNumero(String titulo, boolean obrigatorio);
	
	IEntradaSenha criarEntradaSenha(String titulo, boolean obrigatorio);
	
	IRotulo criarRotulo(String titulo);
	
	ISelecao criarSelecao(String titulo, boolean obrigatorio);
	
	IOpcaoSelecao criarOpcaoSelecao(String valor, String rotulo);

	IEntradaCheckbox criarEntradaCheckbox(String titulo, String valor, boolean obrigatorio);
	
	IEntradaCheckbox criarEntradaCheckbox(String id, String titulo, String valor, boolean obrigatorio);
}
