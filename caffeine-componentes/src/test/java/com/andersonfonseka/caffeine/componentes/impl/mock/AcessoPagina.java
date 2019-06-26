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
import com.andersonfonseka.caffeine.componentes.impl.Resposta;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Botao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaCheckbox;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Formulario;
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
		
		IFormulario formulario = new Formulario.Builder().build();
		formulario.adicionar(componenteFabrica.criarEndereco(this));
		
		this.entradaTexto = componenteFabrica.criarEntradaTexto("Teste", false);
		
		this.entradaCheckbox = new EntradaCheckbox.Builder("Teste", "1", false).build();
		
		IBotao botao = new Botao.Builder("Teste", new AcaoAbs(new Object()) {
			
			@Override
			public IResposta execute() {
				IResposta iResposta = new Resposta.Builder().build();
				iResposta.setPageUrl(AcessoPagina.class);
				return iResposta;
			}
		}, true).build();
		
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
