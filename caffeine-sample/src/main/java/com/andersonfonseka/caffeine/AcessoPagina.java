package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaSenha;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.IAcao;
import com.andersonfonseka.caffeine.componentes.impl.Pagina;
import com.andersonfonseka.caffeine.util.MensagemUtil;

@RequestScoped
public class AcessoPagina extends Pagina {
	
	@Inject
	private MensagemUtil mensagemUtil;
	
	private IEntradaEmail txtEmail;
	
	private IEntradaSenha txtSenha;

	private static final long serialVersionUID = 1L;

	public AcessoPagina() {}

	@PostConstruct
	public void post() {
		
		setTitulo("Acesso");
		
		txtEmail = getComponenteFabrica().criarEntradaEmail("Email", true);
		
		txtSenha = getComponenteFabrica().criarEntradaSenha("Senha", true);

		
		final IFormulario form = getComponenteFabrica().criarFormulario();
		IConteiner conteiner = getComponenteFabrica().criarConteiner(3);

		IBotao button = getComponenteFabrica().criarBotao("Conectar", new IAcao(form) {
			public IResposta execute() {

				IResposta pageResponse = getComponenteFabrica().criarResposta();
				
				IEntradaEmail inputText = (IEntradaEmail) obterPorId(form, txtEmail.getId()).get();
				IEntradaSenha inputPassword = (IEntradaSenha) obterPorId(form, txtSenha.getId()).get();
				
				if (inputText.getValor().equals("anderson.fonseka@gmail.com") &&
						inputPassword.getValor().equals("123456")) {

					pageResponse.setPageUrl(ClientePagina.class.getName());
				
				} else {
				
					pageResponse.adicionar(mensagemUtil.getMessage("INVALIDACCESS", inputText.getValor()));
					pageResponse.setPageUrl(AcessoPagina.class.getName());
				
				}
				
				return pageResponse;
			}
		}, true);
		
		button.setImediato(false);

		conteiner.
				adicionar(0, txtEmail).
				adicionar(1, txtSenha).
				adicionar(2, button);

		form.
			adicionar(conteiner);

		adicionar(form);

		
	}

	@Override
	public void aoCarregar(Map<String, String> parameters) {

		if (parameters == null)
			return;
		
		this.txtEmail.setValor(parameters.get("EntradaEmail1"));
		this.txtSenha.setValor(parameters.get("EntradaSenha2"));
		
	}

}
