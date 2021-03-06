package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.enterprise.inject.spi.BeanManager;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IProjeto;
import com.andersonfonseka.caffeine.componentes.impl.mock.AcessoPagina;
import com.andersonfonseka.caffeine.componentes.impl.mock.ClienteProjeto;

@EnableWeld
class ProjetoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(WeldInitiator.createWeld()
														.beanClasses(BeanManager.class,
																	 ClienteProjeto.class, 
																	 ComponenteFabricaImpl.class,
																	 AcessoPagina.class));
	
	@Test
	void testCriarProjeto(IComponenteFabrica componenteFabrica) {
		IProjeto projeto = componenteFabrica.criarProjeto(ClienteProjeto.class.getName());
		assertTrue(Optional.ofNullable(projeto).isPresent());
	}
	
	@Test
	void testPopulateProjeto(IComponenteFabrica componenteFabrica) {
		
		IProjeto projeto = componenteFabrica.criarProjeto(ClienteProjeto.class.getName());
		projeto.setTitulo("Hello world");
		
		projeto.setComponenteFabrica(componenteFabrica);
		
		IPagina pagina = componenteFabrica.criarPagina(AcessoPagina.class.getName());
		
		projeto.adicionar(pagina);
		projeto.setPaginaInicial(AcessoPagina.class);
		projeto.getPaginaInicial();
				
		assertTrue(Optional.ofNullable(projeto).isPresent());
	}


}
