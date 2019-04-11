package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntradaArquivo;

@EnableWeld
class EntradaArquivoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaArquivo(IComponenteFabrica componenteFabrica) {
		IEntradaArquivo entradaarquivo = componenteFabrica.criarEntradaArquivo("Observacoes", true);
		assertTrue(Optional.of(entradaarquivo).isPresent());
	}
	
	@Test
	void testRenderEntradaArquivo(IComponenteFabrica componenteFabrica) {
		IEntradaArquivo entradaarquivo = componenteFabrica.criarEntradaArquivo("Observacoes", true);
		assertTrue(Optional.of(entradaarquivo.gerarSaida()).isPresent() && entradaarquivo.gerarSaida().length() > 0);
	}

}
