package com.andersonfonseka.caffeine.componentes.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IAcesso;
import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaSenha;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper=false)
public @Data class Acesso extends Conteiner implements IAcesso {
	
	private static final long serialVersionUID = 1L;
	
	private MensagemUtil mensagemUtil = new MensagemUtil();
	
	@Inject
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	IComponenteFabrica componenteFabrica;
	
	private IEntradaEmail txtEmail;

	private IEntradaSenha txtSenha;
	
	private IBotao botaoAcesso;
	
	private IPagina pagina;
	
	private Class paginaDestino;
	
	private  Map<String, String> usuarios;
	
	Acesso(IComponenteFabrica componenteFabrica, IPagina pagina, Map<String, String> usuarios, Class paginaDestino) {
		
		super(4);
		this.componenteFabrica = componenteFabrica;
		this.pagina = pagina;
		this.paginaDestino = paginaDestino;
		this.usuarios = usuarios;
		post();
	
	}
	
	@PostConstruct
	public void post() {

		txtEmail = componenteFabrica.criarEntradaEmail("Email", true);

		txtSenha = componenteFabrica.criarEntradaSenha("Senha", true);

		botaoAcesso = componenteFabrica.criarBotao("Conectar", new AcaoAbs(pagina) {
			public IResposta execute() {

				IResposta pageResponse = componenteFabrica.criarResposta();

				IEntradaEmail inputText = (IEntradaEmail) pagina.obterPorId(pagina, txtEmail.getId()).get();
				IEntradaSenha inputPassword = (IEntradaSenha) pagina.obterPorId(pagina, txtSenha.getId()).get();

				 if (usuarios.containsKey(inputText.getValor()) && 
						 usuarios.get(inputText.getValor()).equals(inputPassword.getValor())) {
					pageResponse.setPageUrl(paginaDestino.getName());

				} else {

					pageResponse.adicionar(mensagemUtil.getMensagemPropriedades("INVALIDACCESS", inputText.getValor()));
					pageResponse.setPageUrl(pagina.getClass().getName());

				}

				return pageResponse;
			}
		}, true);

		botaoAcesso.setImediato(false);

		adicionar(0, txtEmail).
		adicionar(1, txtSenha).
		adicionar(3, botaoAcesso);

	}

	@Override
	public IConteiner getConteiner() {
		return this;
	}
	
	@Override
	public void aoCarregar(Map<String, String> parametros) {
		super.aoCarregar(parametros);
	}

}
