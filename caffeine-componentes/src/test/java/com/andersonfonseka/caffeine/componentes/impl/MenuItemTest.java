package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IMenuItem;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.MenuItem;

@EnableWeld
class MenuItemTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarMenuItem(IComponenteFabrica componenteFabrica) {

		IMenuItem menuItem = new MenuItem.Builder("Titulo", new AcaoAbs(this) {
			@Override
			public IResposta execute() {
				return null;
			}
		}, false).build();

		assertTrue(Optional.ofNullable(menuItem).isPresent());
	}
	
	@Test
	void testRenderMenuItem(IComponenteFabrica componenteFabrica) {

		IMenuItem menuItem = new MenuItem.Builder("Titulo", new AcaoAbs(this) {
			@Override
			public IResposta execute() {
				return null;
			}
		}, false).build();

		assertTrue(Optional.ofNullable(menuItem.gerarSaida()).isPresent());
	}
}
