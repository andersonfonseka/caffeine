package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IAcesso;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;
import com.andersonfonseka.caffeine.servlet.mock.AcessoPagina;

@EnableWeld
class AcessoTest {
	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarAcesso(IComponenteFabrica componenteFabrica) {
		Map<String,String> mapUsuarios = new HashMap<String, String>();
		IAcesso acesso = componenteFabrica.criarAcesso(new Pagina() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
				// TODO Auto-generated method stub
				
			}
		}, mapUsuarios, AcessoPagina.class);		
				
		assertTrue(Optional.of(acesso).isPresent());
	}
	
	@Test
	void testRenderEndereco(IComponenteFabrica componenteFabrica) {
		Map<String,String> mapUsuarios = new HashMap<String, String>();
		IAcesso acesso = componenteFabrica.criarAcesso(new Pagina() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
				// TODO Auto-generated method stub
				
			}
		}, mapUsuarios, AcessoPagina.class);		
		
		assertTrue(Optional.of(acesso.gerarSaida()).isPresent() && acesso.gerarSaida().length() > 0);
	}

}
