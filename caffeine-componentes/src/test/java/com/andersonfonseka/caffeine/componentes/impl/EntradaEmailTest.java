package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaEmail;

@EnableWeld
class EntradaEmailTest {
	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaEmail entradaEmail = new EntradaEmail.Builder("Email", true).build();
		assertTrue(Optional.of(entradaEmail).isPresent());
	}
	
	@Test
	void testRenderEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaEmail entradaEmail = new EntradaEmail.Builder("Email", true).build();
		assertTrue(Optional.of(entradaEmail.gerarSaida()).isPresent() && entradaEmail.gerarSaida().length() > 0);
	}
	
	@Test
	void testValidarEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaEmail entradaEmail = new EntradaEmail.Builder("Email", true).build();
		entradaEmail.setValor("anderson.fonseka@gmail.com");
		assertTrue(entradaEmail.validar().isEmpty());
	}

	@Test
	void testInvalidaEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaEmail entradaEmail = new EntradaEmail.Builder("Email", true).build();
		entradaEmail.setValor("anderson.fonseka");
		assertTrue(!entradaEmail.validar().isEmpty());
	}


}
