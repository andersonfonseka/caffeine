package com.andersonfonseka.caffeine.componentes.impl;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.ComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IEntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.IEntradaArquivo;
import com.andersonfonseka.caffeine.componentes.IEntradaData;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.IEntradaSenha;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.IOpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.IRotulo;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.acao.Acao;

@Model
public class ComponenteFabricaImpl implements ComponenteFabrica {

	public IBotao criarBotao(String titulo, Acao acao, boolean imediato) {
		
		Botao botao = new Botao();
			  botao.setImediato(imediato);
			  botao.setTitulo(titulo);
			  botao.setAcao(acao);
		
		return botao;
	}
	
	public IConteiner criarConteiner(Integer rows) {
		Conteiner conteiner = new Conteiner(rows);
		return conteiner;
	}

	public IFormulario criarFormulario() {
		Formulario formulario = new Formulario();
		return formulario;
	}
	
	public IEndereco criarEndereco() {
		return new Endereco();
	}

	@Override
	public IEntradaAreaTexto criarEntradaAreaTexto(String titulo, boolean obrigatorio, int linhas) {
		
		EntradaAreaTexto entradaAreaTexto = new EntradaAreaTexto();
		entradaAreaTexto.setTitulo(titulo);
		entradaAreaTexto.setObrigatorio(obrigatorio);
		entradaAreaTexto.setRows(linhas);
		
		return entradaAreaTexto;
	}

	@Override
	public IEntradaData criarEntradaData(String titulo, String pattern, boolean obrigatorio) {
		
		EntradaData entradaData = new EntradaData();
		entradaData.setTitulo(titulo);
		entradaData.setPattern(pattern);
		entradaData.setObrigatorio(obrigatorio);
		
		return entradaData;
	}

	@Override
	public IEntradaTexto criarEntradaTexto(String titulo, boolean obrigatorio) {

		EntradaTexto entradaTexto = new EntradaTexto();
		entradaTexto.setTitulo(titulo);
		entradaTexto.setObrigatorio(obrigatorio);
		
		return entradaTexto;
	}

	@Override
	public IEntradaArquivo criarEntradaArquivo(String titulo, boolean obrigatorio) {

		EntradaArquivo entradaArquivo = new EntradaArquivo();
		entradaArquivo.setTitulo(titulo);
		entradaArquivo.setObrigatorio(obrigatorio);
		
		return entradaArquivo;
	}

	@Override
	public IEntradaEmail criarEntradaEmail(String titulo, boolean obrigatorio) {

		EntradaEmail entradaEmail = new EntradaEmail();
		entradaEmail.setTitulo(titulo);
		entradaEmail.setObrigatorio(obrigatorio);
		
		return entradaEmail;
	}

	@Override
	public IEntradaNumero criarEntradaNumero(String titulo, boolean obrigatorio) {

		EntradaNumero entradaNumero = new EntradaNumero();
		entradaNumero.setTitulo(titulo);
		entradaNumero.setObrigatorio(obrigatorio);
		
		return entradaNumero;
	}

	@Override
	public IEntradaSenha criarEntradaSenha(String titulo, boolean obrigatorio) {
		
		EntradaSenha entradaSenha = new EntradaSenha();
		entradaSenha.setTitulo(titulo);
		entradaSenha.setObrigatorio(obrigatorio);
		
		return entradaSenha;
	}

	@Override
	public IRotulo criarRotulo(String titulo) {
		
		Rotulo rotulo = new Rotulo();
		rotulo.setTitulo(titulo);
		
		return rotulo;
	}

	@Override
	public ISelecao criarSelecao(String titulo, boolean obrigatorio) {

		Selecao selecao = new Selecao();
		selecao.setTitulo(titulo);
		selecao.setObrigatorio(obrigatorio);
		
		return selecao;
	}

	@Override
	public IOpcaoSelecao criarOpcaoSelecao(String valor, String rotulo) {
		OpcaoSelecao opcaoSelecao = new OpcaoSelecao(valor, rotulo);
		return opcaoSelecao;
	}
	
}
