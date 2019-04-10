package com.andersonfonseka.caffeine.componentes;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.acao.Acao;

@Model
public interface ComponenteFabrica {

	IBotao criarBotao(String titulo, Acao acao, boolean imediato);
	
	IConteiner criarConteiner(Integer rows);
	
	IFormulario criarFormulario();
	
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
}
