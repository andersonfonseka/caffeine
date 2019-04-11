package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IEntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.IEntradaData;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.acao.IAcao;
import com.andersonfonseka.caffeine.componentes.impl.Pagina;

@RequestScoped
public class ClientePagina extends Pagina {
	
	private static final long serialVersionUID = 1L;
	
	private IEntradaEmail txtEmail;
	
	public ClientePagina() {}
	
	@PostConstruct
	public void post() {

		setTitulo("Cliente");
		
		txtEmail = getComponenteFabrica().criarEntradaEmail("Email", true);
		
		IFormulario form = getComponenteFabrica().criarFormulario(); 
		IEntradaTexto txtFirstName = getComponenteFabrica().criarEntradaTexto("Primeiro nome", true);
		IEntradaTexto txtLastName  = getComponenteFabrica().criarEntradaTexto("Ultimo nome", true);
		
		IEntradaData txtDoB = getComponenteFabrica().criarEntradaData("Data de nascimento", "yyyy-MM-dd", true);
		
		ISelecao selGender = getComponenteFabrica().criarSelecao("Genero", true);
		
		selGender.adicionar(getComponenteFabrica().criarOpcaoSelecao("1", "Masculino"));
		selGender.adicionar(getComponenteFabrica().criarOpcaoSelecao("2", "Feminino"));
		
		IEntradaNumero txDependentes = getComponenteFabrica().criarEntradaNumero("Dependentes", false);
		
		IEntradaAreaTexto txtDescription = getComponenteFabrica().criarEntradaAreaTexto("Observacoes", true, 5);
			
		
		final IConteiner conteiner = getComponenteFabrica().criarConteiner(4);
		
		IBotao btnApply = getComponenteFabrica().criarBotao("Enviar", new IAcao(form) {
			public IResposta execute() {
				
				IResposta pageResponse = getComponenteFabrica().criarResposta();
				pageResponse.setPageUrl(ClientePagina.class.getName());
				
				return pageResponse;
			}
		}, false);
		
		btnApply.setImediato(false);
		
		IBotao btnCancel = getComponenteFabrica().criarBotao("Cancelar", new IAcao(form) {
			public IResposta execute() {
				
				IResposta pageResponse = getComponenteFabrica().criarResposta();
				pageResponse.setPageUrl(AcessoPagina.class.getName());
				
				return pageResponse;
			}
		}, true);
		
		btnCancel.setImediato(true);
		
		IEndereco endereco = getComponenteFabrica().criarEndereco();
		
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
		
		adicionar(form);

	}
	

	@Override
	public void aoCarregar(Map<String, String> parameters) {

		if(parameters == null)
			return;
		
		this.txtEmail.setValor(parameters.get("EntradaEmail1"));
	}
	
}
