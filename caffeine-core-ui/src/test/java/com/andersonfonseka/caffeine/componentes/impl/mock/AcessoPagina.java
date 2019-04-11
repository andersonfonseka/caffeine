package com.andersonfonseka.caffeine.componentes.impl.mock;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaSenha;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.acao.IAcao;
import com.andersonfonseka.caffeine.componentes.impl.EntradaEmail;
import com.andersonfonseka.caffeine.componentes.impl.EntradaSenha;
import com.andersonfonseka.caffeine.componentes.impl.Pagina;
import com.andersonfonseka.caffeine.servlet.Resposta;
import com.andersonfonseka.caffeine.util.MensagemUtil;

@RequestScoped
public class AcessoPagina extends Pagina {

	@Inject
	IComponenteFabrica componenteFabrica;
	
	@PostConstruct
	public void post() {
		// TODO Auto-generated method stub
		IFormulario formulario = componenteFabrica.criarFormulario();
		formulario.adicionar(componenteFabrica.criarEndereco().getConteiner());
		adicionar(formulario);
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {
		// TODO Auto-generated method stub
	}
	

}
