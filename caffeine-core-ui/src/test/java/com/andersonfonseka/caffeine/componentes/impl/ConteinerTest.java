package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;

@EnableWeld
class ConteinerTest {

	@WeldSetup
	public WeldInitiator weld = WeldInitiator.of(IComponenteFabrica.class).of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarConteiner(IComponenteFabrica componenteFabrica) {
		IConteiner conteiner = componenteFabrica.criarConteiner(1);
		assertTrue(Optional.of(conteiner).isPresent());
	}

	@Test
	void testRenderConteiner(IComponenteFabrica componenteFabrica) {
		IConteiner conteiner = componenteFabrica.criarConteiner(1);
		assertTrue(Optional.of(conteiner.doRender()).isPresent() && conteiner.doRender().length() > 0);
	}

}
