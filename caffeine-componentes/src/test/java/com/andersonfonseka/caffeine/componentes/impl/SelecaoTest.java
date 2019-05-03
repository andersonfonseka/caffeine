package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.ISelecao;

@EnableWeld
class SelecaoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	
	@Test
	void testCriarSelecao(IComponenteFabrica componenteFabrica) {
		ISelecao selecao = componenteFabrica.criarSelecao("Genero", true);
		assertTrue(Optional.ofNullable(selecao).isPresent());
	}
	
	@Test
	void testRenderSelecao(IComponenteFabrica componenteFabrica) {
		ISelecao selecao = componenteFabrica.criarSelecao("Genero", true);
		assertTrue(Optional.ofNullable(selecao.gerarSaida()).isPresent() && selecao.gerarSaida().length() > 0);
	}

	@Test
	void testSelecionadoSelecao(IComponenteFabrica componenteFabrica) {
		ISelecao selecao = componenteFabrica.criarSelecao("Genero", true);
		selecao.adicionar(componenteFabrica.criarOpcaoSelecao("1", "Masculino"));
		selecao.adicionar(componenteFabrica.criarOpcaoSelecao("2", "Feminino"));
		
		selecao.setValor("1");
		
		assertTrue(Optional.ofNullable(selecao.getValor()).isPresent());
	}


}
