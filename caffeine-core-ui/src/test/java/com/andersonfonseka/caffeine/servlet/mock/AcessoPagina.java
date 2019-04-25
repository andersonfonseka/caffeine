package com.andersonfonseka.caffeine.servlet.mock;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;

@RequestScoped
public class AcessoPagina extends Pagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	IComponenteFabrica componenteFabrica;
	
	@PostConstruct
	public void post() {
		
		IFormulario formulario = componenteFabrica.criarFormulario();
		formulario.adicionar(componenteFabrica.criarEndereco(null));
		
		IBotao botao = componenteFabrica.criarBotao("Teste", new AcaoAbs(new Object()) {
			
			@Override
			public IResposta execute() {
				IResposta iResposta = componenteFabrica.criarResposta();
				iResposta.setPageUrl(AcessoPagina.class.getName());
				return iResposta;
			}
		}, true);
		
		botao.setImediato(false);
		
		formulario.adicionar(botao);
		
		adicionar(formulario);
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}
	

}
