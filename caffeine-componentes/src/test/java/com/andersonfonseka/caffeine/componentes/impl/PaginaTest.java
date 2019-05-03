package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponente;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IPagina;
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
		
		List<String> msgs = new ArrayList<String>();
		msgs.add("Hello World");
		
		for (String string : msgs) {
			pagina.adicionaMensagem(string);	
		}
		
		assertTrue(Optional.of(pagina.getMensagens()).isPresent());
		
	}

	
}

