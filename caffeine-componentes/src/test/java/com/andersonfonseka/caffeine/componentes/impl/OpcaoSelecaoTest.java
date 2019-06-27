package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IOpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.OpcaoSelecao;

@EnableWeld
class OpcaoSelecaoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	
	@Test
	void testCriarOpcaoSelecao(IComponenteFabrica componenteFabrica) {
		IOpcaoSelecao opcaoSelecao = new OpcaoSelecao.Builder("1", "Selecione").build();
		assertTrue(Optional.ofNullable(opcaoSelecao).isPresent());
	}

}
