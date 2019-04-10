package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEndereco;

@EnableWeld
class EnderecoTest {
	
	@WeldSetup
	public WeldInitiator weld = WeldInitiator.of(IComponenteFabrica.class).of(ComponenteFabricaImpl.class);

	@Test
	void testCriarEndereco(IComponenteFabrica componenteFabrica) {
		IEndereco endereco = componenteFabrica.criarEndereco();
		assertTrue(Optional.of(endereco).isPresent());
	}
	
	@Test
	void testRenderEndereco(IComponenteFabrica componenteFabrica) {
		IEndereco endereco = componenteFabrica.criarEndereco();
		assertTrue(Optional.of(endereco.doRender()).isPresent() && endereco.doRender().length() > 0);
	}

}
