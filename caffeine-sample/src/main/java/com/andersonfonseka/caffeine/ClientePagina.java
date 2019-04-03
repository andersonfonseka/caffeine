package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.swing.Action;

import com.andersonfonseka.caffeine.componente.Botao;
import com.andersonfonseka.caffeine.componente.EntradaAreaTexto;
import com.andersonfonseka.caffeine.componente.EntradaArquivo;
import com.andersonfonseka.caffeine.componente.EntradaData;
import com.andersonfonseka.caffeine.componente.EntradaEmail;
import com.andersonfonseka.caffeine.componente.EntradaTexto;
import com.andersonfonseka.caffeine.componente.Formulario;
import com.andersonfonseka.caffeine.componente.Conteiner;
import com.andersonfonseka.caffeine.componente.OpcaoSelecao;
import com.andersonfonseka.caffeine.componente.Pagina;
import com.andersonfonseka.caffeine.componente.Selecao;
import com.andersonfonseka.caffeine.componente.acao.Acao;
import com.andersonfonseka.caffeine.servlet.PaginaResposta;
import com.andersonfonseka.caffeine.servlet.PaginaResposta;

@RequestScoped
public class ClientePagina extends Pagina {
	
	private static final long serialVersionUID = 1L;

	private EntradaEmail txtEmail = new EntradaEmail();
	
	public ClientePagina() {
		setTitulo("Customer Form");
		
		Formulario form = new Formulario(); 
		EntradaTexto txtFirstName = new EntradaTexto();
		EntradaTexto txtLastName  = new EntradaTexto();
		
		EntradaData txtDoB = new EntradaData();
		Selecao selGender = new Selecao();
		EntradaAreaTexto txtDescription = new EntradaAreaTexto();
		EntradaArquivo txtFile = new EntradaArquivo();
		
		Botao btnApply = new Botao();
		Botao btnCancel = new Botao();
		
		final Conteiner conteiner = new Conteiner(6);
		
		txtFirstName.setTitle("First Name");
		txtFirstName.setRequired(true);

		txtLastName.setTitle("Last Name");
		txtLastName.setRequired(true);
		
		txtEmail.setTitle("E-mail");
		txtEmail.setRequired(true);

		txtDoB.setTitle("Date of birth");
		txtDoB.setPattern("yyyy-MM-dd");
		
		selGender.setRequired(true);
		selGender.setTitle("Gender");
		selGender.add(new OpcaoSelecao("1", "Male"));
		selGender.add(new OpcaoSelecao("2", "Female"));
		
		txtDescription.setRequired(true);
		txtDescription.setTitle("Description");
		txtDescription.setRows(5);
		
		txtFile.setRequired(true);
		txtFile.setTitle("CV/Resume");
		
		btnApply.setTitulo("Apply");
		
		btnApply.setAcao(new Acao(form) {
			public PaginaResposta execute() {
				
				PaginaResposta pageResponse = new PaginaResposta();
				pageResponse.setPageUrl(ClientePagina.class.getName());
				
				return pageResponse;
			}
		});
		
		btnCancel.setTitulo("Cancel");
		btnCancel.setImediato(true);
		
		btnCancel.setAcao(new Acao(form) {
			public PaginaResposta execute() {
				
				PaginaResposta pageResponse = new PaginaResposta();
				pageResponse.setPageUrl(AcessoPagina.class.getName());
				
				return pageResponse;
			}
		});
		
		add(form);
		form.add(conteiner);
		
		conteiner.add(0, txtFirstName)
					.add(1, txtLastName)
					.add(2, txtEmail)
					.add(2, txtDoB)
					.add(3, selGender)
					.add(4, txtDescription)
					.add(5, btnApply)
				    .add(5, btnCancel);
	}
	

	@Override
	public void aoCarregar(Map<String, String> parameters) {

		if(parameters == null)
			return;
		
		this.txtEmail.setValue(parameters.get("InputEmail1"));
	}
	
}
