package com.andersonfonseka.caffeine.componentes.impl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEndereco;

import lombok.Data;

public @Data class Endereco extends Componente implements IEndereco {
	
	private IConteiner conteiner;
	
	@Inject
	IComponenteFabrica componenteFabrica;
	
	Endereco(IComponenteFabrica componenteFabrica) {
		this.componenteFabrica = componenteFabrica;
		post();
	}
	
	@PostConstruct
	public void post() {
		
		conteiner = componenteFabrica.criarConteiner(4);
		
		EntradaTexto logradouro = new EntradaTexto();
		logradouro.setTitulo("Logradouro");
		
		EntradaNumero numero = new EntradaNumero();
		numero.setTitulo("Numero");

		EntradaTexto complemento = new EntradaTexto();
		complemento.setTitulo("Complemento");
		
		EntradaTexto bairro = new EntradaTexto();
		bairro.setTitulo("Bairro");
		
		EntradaTexto cidade = new EntradaTexto();
		cidade.setTitulo("Cidade");
		
		Selecao uf = new Selecao();
		uf.setTitulo("UF");
		uf.adicionar(new OpcaoSelecao("1", "PE"));
		uf.adicionar(new OpcaoSelecao("2", "SP"));
		uf.adicionar(new OpcaoSelecao("3", "RJ"));
		
		conteiner.adicionar(0, logradouro);
		conteiner.adicionar(0, numero);
		conteiner.adicionar(1, complemento);
		conteiner.adicionar(1, bairro);
		conteiner.adicionar(2, cidade);
		conteiner.adicionar(2, uf);
		
	}

	@Override
	public String getTemplate() {
		return null;
	}

}
