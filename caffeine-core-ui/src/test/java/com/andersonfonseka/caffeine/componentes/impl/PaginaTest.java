package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.impl.mock.AcessoPagina;

@EnableWeld
class PaginaTest {

	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(WeldInitiator.createWeld()
														.beanClasses(AcessoPagina.class, ComponenteFabricaImpl.class));
	
	@Test
	void testCriarPagina(IComponenteFabrica componenteFabrica) {
		IPagina pagina = componenteFabrica.criarPagina(AcessoPagina.class.getName());
		assertTrue(Optional.ofNullable(pagina).isPresent());
	}

	@Test
	void testRenderPagina(IComponenteFabrica componenteFabrica) {
		IPagina pagina = componenteFabrica.criarPagina(AcessoPagina.class.getName());
		assertTrue(Optional.of(pagina).isPresent() && pagina.gerarSaida().length() > 0);
	}

	@Test
	void testObterComponentePagina(IComponenteFabrica componenteFabrica) {
		IPagina pagina = componenteFabrica.criarPagina(AcessoPagina.class.getName());
		Optional<IComponente> componente = pagina.obterPorId(pagina, "EntradaTexto4");
		assertTrue(Optional.of(componente).isPresent());
		
	}


	@Test
	void testMensagemComponentePagina(IComponenteFabrica componenteFabrica) {
		IPagina pagina = componenteFabrica.criarPagina(AcessoPagina.class.getName());
		pagina.adicionaMensagem("Hello World");
		assertTrue(Optional.of(pagina.getMensagens()).isPresent());
		
	}

	
}

