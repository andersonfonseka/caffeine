package com.andersonfonseka.caffeine.componentes.impl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.ISelecao;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper=false)
public @Data class Endereco extends Conteiner implements IEndereco {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	IComponenteFabrica componenteFabrica;
	
	Endereco(IComponenteFabrica componenteFabrica) {
		super(4);
		this.componenteFabrica = componenteFabrica;
		post();
	}
	
	@PostConstruct
	public void post() {
		
		IEntradaTexto logradouro = componenteFabrica.criarEntradaTexto("Logradouro", true);
		
		IEntradaNumero numero = componenteFabrica.criarEntradaNumero("Numero", false);

		IEntradaTexto complemento = componenteFabrica.criarEntradaTexto("Complemento", false);
		
		IEntradaTexto bairro = componenteFabrica.criarEntradaTexto("Bairro", false);
		
		IEntradaTexto cidade = componenteFabrica.criarEntradaTexto("Cidade", true);
		
		ISelecao uf = componenteFabrica.criarSelecao("UF", true);
		uf.adicionar(componenteFabrica.criarOpcaoSelecao("1", "PE"));
		uf.adicionar(componenteFabrica.criarOpcaoSelecao("2", "SP"));
		uf.adicionar(componenteFabrica.criarOpcaoSelecao("3", "RJ"));
		
		adicionar(0, logradouro);
		adicionar(0, numero);
		adicionar(1, complemento);
		adicionar(1, bairro);
		adicionar(2, cidade);
		adicionar(2, uf);
	}

	@Override
	public IConteiner getConteiner() {
		return this;
	}

}
