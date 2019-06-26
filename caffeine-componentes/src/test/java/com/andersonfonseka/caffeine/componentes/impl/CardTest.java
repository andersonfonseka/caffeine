package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.ICard;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Card;

@EnableWeld
class CardTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarCard(IComponenteFabrica componenteFabrica) {
		ICard card = new Card.Builder("", "", "").build();
		assertTrue(Optional.ofNullable(card).isPresent());
	}
	
	@Test
	void testRenderCard(IComponenteFabrica componenteFabrica) {
		ICard card = new Card.Builder("", "", "").build();
		assertTrue(Optional.ofNullable(card.gerarSaida()).isPresent());
	}
}
