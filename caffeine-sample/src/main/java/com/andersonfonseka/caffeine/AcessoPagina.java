package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.andersonfonseka.caffeine.componente.Botao;
import com.andersonfonseka.caffeine.componente.EntradaEmail;
import com.andersonfonseka.caffeine.componente.EntradaSenha;
import com.andersonfonseka.caffeine.componente.Formulario;
import com.andersonfonseka.caffeine.componente.GridLayout;
import com.andersonfonseka.caffeine.componente.Pagina;
import com.andersonfonseka.caffeine.componente.acao.Acao;
import com.andersonfonseka.caffeine.servlet.PaginaResposta;
import com.andersonfonseka.caffeine.util.MensagemUtil;

@RequestScoped
public class AcessoPagina extends Pagina {
	
	private EntradaEmail txtEmail = new EntradaEmail();
	
	private EntradaSenha txtPassword = new EntradaSenha();

	private static final long serialVersionUID = 1L;

	public AcessoPagina() {

		setTitulo("Login Form");
		
		final Formulario form = new Formulario();
		GridLayout gridLayout = new GridLayout(3);

		Botao button = new Botao();

		txtEmail.setTitle("Email");
		txtEmail.setRequired(true);

		txtPassword.setTitle("Password");
		txtPassword.setRequired(true);

		button.setTitulo("Apply");

		button.setAcao(new Acao(form) {
			public PaginaResposta execute() {

				PaginaResposta pageResponse = new PaginaResposta();
				
				EntradaEmail inputText = (EntradaEmail) findById(form, txtEmail.getId()).get();
				EntradaSenha inputPassword = (EntradaSenha) findById(form, txtPassword.getId()).get();
				
				if (inputText.getValue().equals("anderson.fonseka@gmail.com") &&
						inputPassword.getValue().equals("123456")) {

					pageResponse.setPageUrl(ClientePagina.class.getName());

				} else {

					pageResponse.addMessage(MensagemUtil.getInstance().getMessage("Invalid access input!"));
					pageResponse.setPageUrl(AcessoPagina.class.getName());
					
				}
				
				
				return pageResponse;
			}
		});

		gridLayout.
				add(0, txtEmail).
				add(1, txtPassword).
				add(2, button);

		form.
			add(gridLayout);

		add(form);
		
	}

	@Override
	public void aoCarregar(Map<String, String> parameters) {

		if (parameters == null)
			return;
	
		
		this.txtEmail.setValue(parameters.get("InputEmail1"));
		this.txtPassword.setValue(parameters.get("InputPassword2"));
		
	}

}
