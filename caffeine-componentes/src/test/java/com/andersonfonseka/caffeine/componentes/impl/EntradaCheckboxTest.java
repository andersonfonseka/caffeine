package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaCheckbox;

@EnableWeld
class EntradaCheckboxTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaCheckbox(IComponenteFabrica componenteFabrica) {
		IEntradaCheckbox entradaTexto = componenteFabrica.criarEntradaCheckbox("Texto", "1", true);
		assertTrue(Optional.ofNullable(entradaTexto).isPresent());
	}
	
	@Test
	void testRenderEntradaCheckbox(IComponenteFabrica componenteFabrica) {
		IEntradaCheckbox entradaTexto = componenteFabrica.criarEntradaCheckbox("Texto", "1", true);
		assertTrue(Optional.ofNullable(entradaTexto.gerarSaida()).isPresent() && entradaTexto.gerarSaida().length() > 0);
	}
	
	@Test
	void testValidarEntradaCheckbox(IComponenteFabrica componenteFabrica) {
		IEntradaCheckbox entradaTexto = componenteFabrica.criarEntradaCheckbox("Texto", "1", true);
		entradaTexto.setValor("1");
		assertTrue(entradaTexto.validar().isEmpty());
	}

}
