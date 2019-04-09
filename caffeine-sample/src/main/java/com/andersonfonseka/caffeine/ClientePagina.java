package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.andersonfonseka.caffeine.componentes.ComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.acao.Acao;
import com.andersonfonseka.caffeine.componentes.impl.Botao;
import com.andersonfonseka.caffeine.componentes.impl.Conteiner;
import com.andersonfonseka.caffeine.componentes.impl.Endereco;
import com.andersonfonseka.caffeine.componentes.impl.EntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.impl.EntradaArquivo;
import com.andersonfonseka.caffeine.componentes.impl.EntradaData;
import com.andersonfonseka.caffeine.componentes.impl.EntradaEmail;
import com.andersonfonseka.caffeine.componentes.impl.EntradaNumero;
import com.andersonfonseka.caffeine.componentes.impl.EntradaTexto;
import com.andersonfonseka.caffeine.componentes.impl.Formulario;
import com.andersonfonseka.caffeine.componentes.impl.OpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.impl.Pagina;
import com.andersonfonseka.caffeine.componentes.impl.Selecao;
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
		
		IBotao btnApply = ComponenteFabrica.obterInstancia().criarBotao("Enviar", new Acao(form) {
			public Resposta execute() {
				
				Resposta pageResponse = new Resposta();
				pageResponse.setPageUrl(ClientePagina.class.getName());
				
				return pageResponse;
			}
		}, false);

		
		IBotao btnCancel = ComponenteFabrica.obterInstancia().criarBotao("Cancelar", new Acao(form) {
			public Resposta execute() {
				
				Resposta pageResponse = new Resposta();
				pageResponse.setPageUrl(AcessoPagina.class.getName());
				
				return pageResponse;
			}
		}, true);
		
		
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
