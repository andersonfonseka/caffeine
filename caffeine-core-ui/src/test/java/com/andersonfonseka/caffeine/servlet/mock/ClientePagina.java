package com.andersonfonseka.caffeine.servlet.mock;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.impl.Pagina;

@RequestScoped
public class ClientePagina extends Pagina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	IComponenteFabrica componenteFabrica;
	
	@PostConstruct
	public void post() {
		IFormulario formulario = componenteFabrica.criarFormulario();
		formulario.adicionar(componenteFabrica.criarEndereco(this).getConteiner());
		adicionar(formulario);
	}

	@Override
	public void aoCarregar(Map<String, String> parametros) {}
	

}
