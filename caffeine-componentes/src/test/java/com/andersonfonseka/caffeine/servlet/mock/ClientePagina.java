package com.andersonfonseka.caffeine.servlet.mock;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IFormulario;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Formulario;
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
		IFormulario formulario = new Formulario.Builder().build();
		formulario.adicionar(componenteFabrica.criarEndereco(this));
		adicionar(formulario);
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
	

}
