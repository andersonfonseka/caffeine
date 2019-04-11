package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IEntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.IEntradaData;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.acao.IAcao;
import com.andersonfonseka.caffeine.componentes.impl.Pagina;
import com.andersonfonseka.caffeine.servlet.Resposta;

@RequestScoped
public class ClientePagina extends Pagina {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IComponenteFabrica componenteFabrica;

	private IEntradaEmail txtEmail;
	
	public ClientePagina() {}
	
	@PostConstruct
	public void post() {

		setTitulo("Cliente");
		
		txtEmail = componenteFabrica.criarEntradaEmail("Email", true);
		
		IFormulario form = componenteFabrica.criarFormulario(); 
		IEntradaTexto txtFirstName = componenteFabrica.criarEntradaTexto("Primeiro nome", true);
		IEntradaTexto txtLastName  = componenteFabrica.criarEntradaTexto("Ultimo nome", true);
		
		IEntradaData txtDoB = componenteFabrica.criarEntradaData("Data de nascimento", "yyyy-MM-dd", true);
		
		ISelecao selGender = componenteFabrica.criarSelecao("Genero", true);
		
		selGender.adicionar(componenteFabrica.criarOpcaoSelecao("1", "Masculino"));
		selGender.adicionar(componenteFabrica.criarOpcaoSelecao("2", "Feminino"));
		
		IEntradaNumero txDependentes = componenteFabrica.criarEntradaNumero("Dependentes", false);
		
		IEntradaAreaTexto txtDescription = componenteFabrica.criarEntradaAreaTexto("Observacoes", true, 5);
			
		
		final IConteiner conteiner = componenteFabrica.criarConteiner(6);
		
		IBotao btnApply = componenteFabrica.criarBotao("Enviar", new IAcao(form) {
			public Resposta execute() {
				
				Resposta pageResponse = new Resposta();
				pageResponse.setPageUrl(ClientePagina.class.getName());
				
				return pageResponse;
			}
		}, false);

		
		IBotao btnCancel = componenteFabrica.criarBotao("Cancelar", new IAcao(form) {
			public Resposta execute() {
				
				Resposta pageResponse = new Resposta();
				pageResponse.setPageUrl(AcessoPagina.class.getName());
				
				return pageResponse;
			}
		}, true);
		
		adicionar(form);
		
		IEndereco endereco = componenteFabrica.criarEndereco();
		
		form.adicionar(conteiner);
		
		conteiner.adicionar(0, txtFirstName)
					.adicionar(0, txtLastName)
					.adicionar(1, txtEmail)
					.adicionar(1, txtDoB)
					.adicionar(2, selGender)
					.adicionar(2, txDependentes)
					.adicionar(3, txtDescription);
		
		endereco.getConteiner()
					.adicionar(3, btnApply)
					.adicionar(3, btnCancel);
		
		form.adicionar(endereco.getConteiner());

	}
	

	@Override
	public void aoCarregar(Map<String, String> parameters) {

		if(parameters == null)
			return;
		
		this.txtEmail.setValor(parameters.get("EntradaEmail1"));
	}
	
}
