package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IConteiner;

@EnableWeld
class ConteinerTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarConteiner(IComponenteFabrica componenteFabrica) {
		IConteiner conteiner = componenteFabrica.criarConteiner(1);
		assertTrue(Optional.of(conteiner).isPresent());
	}

	@Test
	void testRenderConteiner(IComponenteFabrica componenteFabrica) {
		IConteiner conteiner = componenteFabrica.criarConteiner(1);
		assertTrue(Optional.of(conteiner.gerarSaida()).isPresent() && conteiner.gerarSaida().length() > 0);
	}

}
