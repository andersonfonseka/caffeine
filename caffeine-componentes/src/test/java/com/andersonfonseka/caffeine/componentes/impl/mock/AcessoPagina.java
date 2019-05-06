package com.andersonfonseka.caffeine.componentes.impl.mock;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaCheckbox;
import com.andersonfonseka.caffeine.IEntradaTexto;
import com.andersonfonseka.caffeine.IFormulario;
import com.andersonfonseka.caffeine.IResposta;
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
	
	IEntradaTexto entradaTexto;
	
	IEntradaCheckbox entradaCheckbox;
	
	@PostConstruct
	public void post() {
		
		IFormulario formulario = componenteFabrica.criarFormulario();
		formulario.adicionar(componenteFabrica.criarEndereco(this));
		
		this.entradaTexto = componenteFabrica.criarEntradaTexto("Teste", false);
		
		this.entradaCheckbox = componenteFabrica.criarEntradaCheckbox("Teste", "1", false);
		
		IBotao botao = componenteFabrica.criarBotao("Teste", new AcaoAbs(new Object()) {
			
			@Override
			public IResposta execute() {
				IResposta iResposta = componenteFabrica.criarResposta();
				iResposta.setPageUrl(AcessoPagina.class);
				return iResposta;
			}
		}, true);
		
		botao.setImediato(false);
		
		formulario.adicionar(this.entradaTexto);
		formulario.adicionar(this.entradaCheckbox);
		formulario.adicionar(botao);
		
		adicionar(formulario);
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {
		super.aoCarregar(parametros);
	}

	public IEntradaTexto getEntradaTexto() {
		return entradaTexto;
	}
	
}
