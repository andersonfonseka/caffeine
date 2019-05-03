package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IFormulario;

@EnableWeld
class FormularioTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarFormulario(IComponenteFabrica componenteFabrica) {
		IFormulario formulario = componenteFabrica.criarFormulario();
		assertTrue(Optional.ofNullable(formulario).isPresent());
	}
	
	@Test
	void testRenderFormulario(IComponenteFabrica componenteFabrica) {
		IFormulario formulario = componenteFabrica.criarFormulario();
		assertTrue(Optional.ofNullable(formulario.gerarSaida()).isPresent() && formulario.gerarSaida().length() > 0);
	}

}
