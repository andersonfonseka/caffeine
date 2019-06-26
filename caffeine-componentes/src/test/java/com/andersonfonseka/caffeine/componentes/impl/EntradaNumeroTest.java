package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaNumero;

@EnableWeld
class EntradaNumeroTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaNumero(IComponenteFabrica componenteFabrica) {
		IEntradaNumero entradaNumero = new EntradaNumero.Builder("Email", true).build();
		assertTrue(Optional.of(entradaNumero).isPresent());
	}
	
	@Test
	void testRenderEntradaNumero(IComponenteFabrica componenteFabrica) {
		IEntradaNumero entradaNumero = new EntradaNumero.Builder("Email", true).build();
		assertTrue(Optional.of(entradaNumero.gerarSaida()).isPresent() && entradaNumero.gerarSaida().length() > 0);
	}
	
	@Test
	void testValidarEntradaNumero(IComponenteFabrica componenteFabrica) {
		IEntradaNumero entradaNumero = new EntradaNumero.Builder("Email", true).build();
		entradaNumero.setValor("123");
		assertTrue(entradaNumero.validar().isEmpty());
	}
	
	@Test
	void testValidarErroEntradaNumero(IComponenteFabrica componenteFabrica) {
		IEntradaNumero entradaNumero = new EntradaNumero.Builder("Email", true).build();
		entradaNumero.setValor("AAAA");
		assertTrue(!entradaNumero.validar().isEmpty());
	}

}
