package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaAreaTexto;

@EnableWeld
class EntradaAreaTextoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaAreaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaAreaTexto entradaAreaTexto = componenteFabrica.criarEntradaAreaTexto("Observacoes", true, 5);
		assertTrue(Optional.of(entradaAreaTexto).isPresent());
	}
	
	@Test
	void testRenderEntradaAreaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaAreaTexto entradaAreaTexto = componenteFabrica.criarEntradaAreaTexto("Observacoes", true, 5);
		assertTrue(Optional.of(entradaAreaTexto.gerarSaida()).isPresent() && entradaAreaTexto.gerarSaida().length() > 0);
	}

}
