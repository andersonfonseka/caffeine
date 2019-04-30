package com.andersonfonseka.caffeine.componentes.impl.mock;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;

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
		formulario.adicionar(componenteFabrica.criarEndereco(this));
		adicionar(formulario);
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
	

}
