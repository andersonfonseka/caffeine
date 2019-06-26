package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaAreaTexto;

@EnableWeld
class EntradaAreaTextoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaAreaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaAreaTexto entradaAreaTexto = new EntradaAreaTexto.Builder("Observacoes", true, 5).build();
		assertTrue(Optional.of(entradaAreaTexto).isPresent());
	}
	
	@Test
	void testRenderEntradaAreaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaAreaTexto entradaAreaTexto = new EntradaAreaTexto.Builder("Observacoes", true, 5).build();
		assertTrue(Optional.of(entradaAreaTexto.gerarSaida()).isPresent() && entradaAreaTexto.gerarSaida().length() > 0);
	}

}
