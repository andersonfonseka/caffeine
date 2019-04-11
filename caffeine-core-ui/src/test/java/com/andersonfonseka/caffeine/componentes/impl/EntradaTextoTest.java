package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;

@EnableWeld
class EntradaTextoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaTexto entradaTexto = componenteFabrica.criarEntradaTexto("Texto", true);
		assertTrue(Optional.ofNullable(entradaTexto).isPresent());
	}
	
	@Test
	void testRenderEntradaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaTexto entradaTexto = componenteFabrica.criarEntradaTexto("Texto", true);
		assertTrue(Optional.ofNullable(entradaTexto.gerarSaida()).isPresent() && entradaTexto.gerarSaida().length() > 0);
	}
	
	@Test
	void testValidarEntradaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaTexto entradaTexto = componenteFabrica.criarEntradaTexto("Texto", true);
		entradaTexto.setValor("123");
		assertTrue(entradaTexto.validar().isEmpty());
	}

}
