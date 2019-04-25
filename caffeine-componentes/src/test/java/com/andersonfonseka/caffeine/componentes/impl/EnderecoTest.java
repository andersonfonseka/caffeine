package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;

@EnableWeld
class EnderecoTest {
	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarEndereco(IComponenteFabrica componenteFabrica) {
		IEndereco endereco = componenteFabrica.criarEndereco(new Pagina() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
			}

			@Override
			public void aoCarregar(Map<String, String> parametros) {
			}});
		assertTrue(Optional.of(endereco).isPresent());
	}
	
	@Test
	void testRenderEndereco(IComponenteFabrica componenteFabrica) {
		IEndereco endereco = componenteFabrica.criarEndereco(new Pagina() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
			}

			@Override
			public void aoCarregar(Map<String, String> parametros) {
			}
		});
		assertTrue(Optional.of(endereco.gerarSaida()).isPresent() && endereco.gerarSaida().length() > 0);
	}

}
