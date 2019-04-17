package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;

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
	
	private IPagina pagina;
	
	private ISelecao estado;
	
	Endereco(IComponenteFabrica componenteFabrica, IPagina pagina) {
		super(4);
		this.componenteFabrica = componenteFabrica;
		this.pagina = pagina;
		post();
	}
	
	@PostConstruct
	public void post() {
		
		IEntradaTexto logradouro = componenteFabrica.criarEntradaTexto("Logradouro", true);
		
		IEntradaNumero numero = componenteFabrica.criarEntradaNumero("Numero", false);

		IEntradaTexto complemento = componenteFabrica.criarEntradaTexto("Complemento", false);
		
		IEntradaTexto bairro = componenteFabrica.criarEntradaTexto("Bairro", false);
		
		estado = componenteFabrica.criarSelecao("UF", new AcaoAbs(this) {
			
			@Override
			public IResposta execute() {
				IResposta resposta = componenteFabrica.criarResposta();
				resposta.setPageUrl(pagina.getClass().getName());
				
				return resposta;
			}
		}, true);
		
		estado.setImediato(true);
		
		estado.adicionar(componenteFabrica.criarOpcaoSelecao("1", "PE"));
		estado.adicionar(componenteFabrica.criarOpcaoSelecao("2", "SP"));
		estado.adicionar(componenteFabrica.criarOpcaoSelecao("3", "RJ"));

		
		
		adicionar(0, logradouro);
		adicionar(0, numero);
		adicionar(1, complemento);
		adicionar(1, bairro);
		adicionar(2, estado);
	}

	@Override
	public IConteiner getConteiner() {
		return this;
	}
	
	@Override
	public void aoCarregar(Map<String, String> parametros) {
		
		estado.setValor(parametros.get(estado.getId()));

		ISelecao cidade = componenteFabrica.criarSelecao("Cidade", true);
		
		if (estado.getValor() == null) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao(" ", "Selecione..."));
		} else if (estado.getSelecionado().getValor().equals("1")) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("1", "Recife"));
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("2", "Olinda"));
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("3", "Paulista"));
		} else if (estado.getSelecionado().getValor().equals("2")) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("4", "São Paulo"));
		} else if (estado.getSelecionado().getValor().equals("3")) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("5", "Rio de Janeiro"));
		}
		
		adicionar(2, cidade);
		
		
	}
	

}
