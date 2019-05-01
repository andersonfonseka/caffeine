package com.andersonfonseka.caffeine.componentes.impl.compostos;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper=false)
public class Endereco extends Conteiner implements IEndereco {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	IComponenteFabrica componenteFabrica;
	
	IPagina pagina;
	
	IEntradaTexto logradouro;
	
	IEntradaNumero numero;

	IEntradaTexto complemento;

	IEntradaTexto bairro;
	
	private ISelecao estado;
	
	private ISelecao cidade; 
	
	public Endereco(IComponenteFabrica componenteFabrica, IPagina pagina) {
		super(4);
		this.componenteFabrica = componenteFabrica;
		this.pagina = pagina;
		post();
	}
	
	@PostConstruct
	public void post() {
		
		logradouro = componenteFabrica.criarEntradaTexto("Logradouro", true);
		
		numero = componenteFabrica.criarEntradaNumero("Numero", false);

		complemento = componenteFabrica.criarEntradaTexto("Complemento", false);
		
		bairro = componenteFabrica.criarEntradaTexto("Bairro", false);
		
		estado = componenteFabrica.criarSelecao("UF", new AcaoAbs(this) {
			
			@Override
			public IResposta execute() {
				IResposta resposta = componenteFabrica.criarResposta();
				resposta.setPageUrl(pagina.getClass());
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
	public void aoCarregar(Map<String, Object> parametros) {
		
		estado.setValor(String.valueOf(parametros.get(estado.getId())));

		cidade = componenteFabrica.criarSelecao("Cidade", true);
		
		if (estado.getSelecionado() == null) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao(" ", "Selecione..."));
		} else if (estado.getSelecionado().getValor().equals("1")) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("1", "Recife"));
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("2", "Olinda"));
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("3", "Paulista"));
		} else if (estado.getSelecionado().getValor().equals("2")) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("4", "S�o Paulo"));
		} else if (estado.getSelecionado().getValor().equals("3")) {
			cidade.adicionar(componenteFabrica.criarOpcaoSelecao("5", "Rio de Janeiro"));
		}
		
		adicionar(2, cidade);
		
	}

	public IEntradaTexto getLogradouro() {
		return logradouro;
	}

	public IEntradaNumero getNumero() {
		return numero;
	}

	public IEntradaTexto getComplemento() {
		return complemento;
	}

	public IEntradaTexto getBairro() {
		return bairro;
	}

	public ISelecao getEstado() {
		return estado;
	}

	public ISelecao getCidade() {
		return cidade;
	}

}