package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IRotulo;

@EnableWeld
class RotuloTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarRotulo(IComponenteFabrica componenteFabrica) {
		IRotulo rotulo = componenteFabrica.criarRotulo("Rotulo");
		assertTrue(Optional.ofNullable(rotulo).isPresent());
	}
	
	@Test
	void testRenderRotulo(IComponenteFabrica componenteFabrica) {
		IRotulo rotulo = componenteFabrica.criarRotulo("Rotulo");
		assertTrue(Optional.ofNullable(rotulo.gerarSaida()).isPresent());
	}
}
