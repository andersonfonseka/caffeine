package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.ISelecao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.OpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Selecao;

@EnableWeld
class SelecaoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	
	@Test
	void testCriarSelecao(IComponenteFabrica componenteFabrica) {
		ISelecao selecao = new Selecao.Builder("Genero", true).build();
		assertTrue(Optional.ofNullable(selecao).isPresent());
	}
	
	@Test
	void testRenderSelecao(IComponenteFabrica componenteFabrica) {
		ISelecao selecao = new Selecao.Builder("Genero", true).build();
		assertTrue(Optional.ofNullable(selecao.gerarSaida()).isPresent() && selecao.gerarSaida().length() > 0);
	}

	@Test
	void testSelecionadoSelecao(IComponenteFabrica componenteFabrica) {
		ISelecao selecao = new Selecao.Builder("Genero", true).build();
		selecao.adicionar(new OpcaoSelecao.Builder("1", "Masculino").build());
		selecao.adicionar(new OpcaoSelecao.Builder("2", "Feminino").build());
		
		selecao.setValor("1");
		
		assertTrue(Optional.ofNullable(selecao.getValor()).isPresent());
	}


}
