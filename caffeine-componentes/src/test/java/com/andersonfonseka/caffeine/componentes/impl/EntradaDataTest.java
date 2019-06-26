package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaData;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaData;

@EnableWeld
class EntradaDataTest {
	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaData entradaEmail = new EntradaData.Builder("DoB", "yyyy-mm-aa", true).build();
		assertTrue(Optional.of(entradaEmail).isPresent());
	}
	
	@Test
	void testRenderEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaData entradaEmail = new EntradaData.Builder("DoB", "yyyy-mm-aa", true).build();
		assertTrue(Optional.of(entradaEmail.gerarSaida()).isPresent() && entradaEmail.gerarSaida().length() > 0);
	}
	
	@Test
	void testValidarEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaData entradaEmail = new EntradaData.Builder("DoB", "yyyy-MM-dd", true).build();
		entradaEmail.setValor("1975-06-20");
		assertTrue(entradaEmail.validar().isEmpty());
	}

	@Test
	void testInvalidarEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaData entradaEmail = new EntradaData.Builder("DoB", "yyyy-MM-dd", true).build();
		entradaEmail.setValor("1975-20-06");
		assertTrue(!entradaEmail.validar().isEmpty());
	}
	
	@Test
	void testObrigatorioEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaData entradaEmail = new EntradaData.Builder("DoB", "yyyy-MM-dd", true).build();
		assertTrue(!entradaEmail.validar().isEmpty());
	}

}
