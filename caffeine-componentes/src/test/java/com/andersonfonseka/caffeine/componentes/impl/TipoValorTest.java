package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.ISelecao;
import com.andersonfonseka.caffeine.ITipoValor;
import com.andersonfonseka.caffeine.componentes.impl.basicos.OpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Selecao;

@EnableWeld
class TipoValorTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarTipoValor(IComponenteFabrica componenteFabrica) {

		ISelecao selecaoTipo = new Selecao.Builder("Selecao", false).build();

		ITipoValor tipoValor = componenteFabrica.criarTipoValor(new Pagina() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
			}
		}, selecaoTipo);

		assertTrue(Optional.of(tipoValor).isPresent());
	}

	@Test
	void testRenderTipoValor(IComponenteFabrica componenteFabrica) {
		ISelecao selecaoTipo = new Selecao.Builder("Selecao", false).build();

		ITipoValor tipoValor = componenteFabrica.criarTipoValor(new Pagina() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
			}
		}, selecaoTipo);

		assertTrue(Optional.of(tipoValor.gerarSaida()).isPresent() && tipoValor.gerarSaida().length() > 0);
	}
	

	@Test
	void testAdicionarTipoValor(IComponenteFabrica componenteFabrica) {
		
		
		
		ISelecao selecaoTipo = new Selecao.Builder("Selecao", false).build();
		selecaoTipo.adicionar(new OpcaoSelecao.Builder("1", "RotuloTeste").build());

		ITipoValor tipoValor = componenteFabrica.criarTipoValor(new Pagina() {

			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
			}
		}, selecaoTipo);
		
		selecaoTipo.setValor("1");
		tipoValor.getTxValor().setValor("Teste");
		tipoValor.getBtnAdicionar().doClick();

		assertTrue(!tipoValor.getListaValores().isEmpty());
	}

}
