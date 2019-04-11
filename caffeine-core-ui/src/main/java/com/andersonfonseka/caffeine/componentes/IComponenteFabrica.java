package com.andersonfonseka.caffeine.componentes;

import java.util.Optional;

import com.andersonfonseka.caffeine.componentes.acao.IAcao;

public interface IComponenteFabrica {

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
}
