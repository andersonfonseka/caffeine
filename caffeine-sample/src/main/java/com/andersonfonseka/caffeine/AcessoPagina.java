package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.andersonfonseka.caffeine.componentes.Botao;
import com.andersonfonseka.caffeine.componentes.Conteiner;
import com.andersonfonseka.caffeine.componentes.EntradaEmail;
import com.andersonfonseka.caffeine.componentes.EntradaSenha;
import com.andersonfonseka.caffeine.componentes.Formulario;
import com.andersonfonseka.caffeine.componentes.Pagina;
import com.andersonfonseka.caffeine.componentes.acao.Acao;
import com.andersonfonseka.caffeine.servlet.Resposta;
import com.andersonfonseka.caffeine.util.MensagemUtil;

@RequestScoped
public class AcessoPagina extends Pagina {
	
	private EntradaEmail txtEmail = new EntradaEmail();
	
	private EntradaSenha txtSenha = new EntradaSenha();

	private static final long serialVersionUID = 1L;

	public AcessoPagina() {

		setTitulo("Acesso");
		
		final Formulario form = new Formulario();
		Conteiner gridLayout = new Conteiner(3);

		Botao button = new Botao();

		txtEmail.setTitulo("Email");
		txtEmail.setObrigatorio(true);

		txtSenha.setTitulo("Senha");
		txtSenha.setObrigatorio(true);

		button.setTitulo("Conectar");

		button.setAcao(new Acao(form) {
			public Resposta execute() {

				Resposta pageResponse = new Resposta();
				
				EntradaEmail inputText = (EntradaEmail) findById(form, txtEmail.getId()).get();
				EntradaSenha inputPassword = (EntradaSenha) findById(form, txtSenha.getId()).get();
				
				if (inputText.getValor().equals("anderson.fonseka@gmail.com") &&
						inputPassword.getValor().equals("123456")) {

					pageResponse.setPageUrl(ClientePagina.class.getName());

				} else {

					pageResponse.addMessage(MensagemUtil.getInstance().getMessage("INVALIDACCESS", inputText.getValor()));
					pageResponse.setPageUrl(AcessoPagina.class.getName());
					
				}
				
				
				return pageResponse;
			}
		});

		gridLayout.
				add(0, txtEmail).
				add(1, txtSenha).
				add(2, button);

		form.
			add(gridLayout);

		add(form);
		
	}

	@Override
	public void aoCarregar(Map<String, String> parameters) {

		if (parameters == null)
			return;
	
		
		this.txtEmail.setValor(parameters.get("EntradaEmail1"));
		this.txtSenha.setValor(parameters.get("EntradaSenha2"));
		
	}

}
