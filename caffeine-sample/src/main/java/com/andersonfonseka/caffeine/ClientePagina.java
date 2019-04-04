package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.andersonfonseka.caffeine.componente.Botao;
import com.andersonfonseka.caffeine.componente.Conteiner;
import com.andersonfonseka.caffeine.componente.Endereco;
import com.andersonfonseka.caffeine.componente.EntradaAreaTexto;
import com.andersonfonseka.caffeine.componente.EntradaArquivo;
import com.andersonfonseka.caffeine.componente.EntradaData;
import com.andersonfonseka.caffeine.componente.EntradaEmail;
import com.andersonfonseka.caffeine.componente.EntradaNumero;
import com.andersonfonseka.caffeine.componente.EntradaTexto;
import com.andersonfonseka.caffeine.componente.Formulario;
import com.andersonfonseka.caffeine.componente.OpcaoSelecao;
import com.andersonfonseka.caffeine.componente.Pagina;
import com.andersonfonseka.caffeine.componente.Selecao;
import com.andersonfonseka.caffeine.componente.acao.Acao;
import com.andersonfonseka.caffeine.servlet.Resposta;

@RequestScoped
public class ClientePagina extends Pagina {
	
	private static final long serialVersionUID = 1L;

	private EntradaEmail txtEmail = new EntradaEmail();
	
	public ClientePagina() {
		
		setTitulo("Cliente");
		
		Formulario form = new Formulario(); 
		EntradaTexto txtFirstName = new EntradaTexto();
		EntradaTexto txtLastName  = new EntradaTexto();
		
		EntradaData txtDoB = new EntradaData();
		Selecao selGender = new Selecao();
		EntradaNumero txDependentes = new EntradaNumero();
		EntradaAreaTexto txtDescription = new EntradaAreaTexto();
		EntradaArquivo txtFile = new EntradaArquivo();
		
		Botao btnApply = new Botao();
		Botao btnCancel = new Botao();
		
		final Conteiner conteiner = new Conteiner(6);
		
		txtFirstName.setTitulo("Primeiro nome");
		txtFirstName.setObrigatorio(true);

		txtLastName.setTitulo("Ultimo nome");
		txtLastName.setObrigatorio(true);
		
		txtEmail.setTitulo("E-mail");
		txtEmail.setObrigatorio(true);

		txtDoB.setTitulo("Data de nascimento");
		txtDoB.setPattern("yyyy-MM-dd");
		
		txDependentes.setTitulo("Dependentes");
		
		selGender.setObrigatorio(true);
		selGender.setTitulo("Genero");
		selGender.add(new OpcaoSelecao("1", "Masculino"));
		selGender.add(new OpcaoSelecao("2", "Feminino"));
		
		txtDescription.setObrigatorio(true);
		txtDescription.setTitulo("Observacoes");
		txtDescription.setRows(5);
		
		txtFile.setObrigatorio(true);
		txtFile.setTitulo("CV");
		
		btnApply.setTitulo("Enviar");
		
		btnApply.setAcao(new Acao(form) {
			public Resposta execute() {
				
				Resposta pageResponse = new Resposta();
				pageResponse.setPageUrl(ClientePagina.class.getName());
				
				return pageResponse;
			}
		});
		
		btnCancel.setTitulo("Cancelar");
		btnCancel.setImediato(true);
		
		btnCancel.setAcao(new Acao(form) {
			public Resposta execute() {
				
				Resposta pageResponse = new Resposta();
				pageResponse.setPageUrl(AcessoPagina.class.getName());
				
				return pageResponse;
			}
		});
		
		add(form);
		
		Endereco endereco = new Endereco();
		
		form.add(conteiner);
		
		conteiner.add(0, txtFirstName)
					.add(0, txtLastName)
					.add(1, txtEmail)
					.add(1, txtDoB)
					.add(2, selGender)
					.add(2, txDependentes)
					.add(3, txtDescription);
		
		endereco.getConteiner()
					.add(3, btnApply)
					.add(3, btnCancel);
		
		form.add(endereco.getConteiner());
		
	}
	

	@Override
	public void aoCarregar(Map<String, String> parameters) {

		if(parameters == null)
			return;
		
		this.txtEmail.setValor(parameters.get("EntradaEmail1"));
	}
	
}
