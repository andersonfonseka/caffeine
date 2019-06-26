package com.andersonfonseka.caffeine.servlet.mock;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IFormulario;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.Resposta;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Botao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Formulario;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;

@RequestScoped
public class AcessoPagina extends Pagina {

	private static final long serialVersionUID = 1L;
	@Inject
	IComponenteFabrica componenteFabrica;
	
	@PostConstruct
	public void post() {
		
		IFormulario formulario = new Formulario.Builder().build();
		formulario.adicionar(componenteFabrica.criarEndereco(null));
		
		IBotao botao = new Botao.Builder("Teste", new AcaoAbs(new Object()) {
			
			@Override
			public IResposta execute() {
				IResposta iResposta = new Resposta.Builder().build();
				iResposta.setPageUrl(AcessoPagina.class);
				return iResposta;
			}
		}, true).build();
		
		botao.setImediato(false);
		
		formulario.adicionar(botao);
		
		adicionar(formulario);
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
	

}
