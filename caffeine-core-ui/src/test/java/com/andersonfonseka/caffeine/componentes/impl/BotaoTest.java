package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.acao.IAcao;
import com.andersonfonseka.caffeine.servlet.Resposta;

@EnableWeld
class BotaoTest {

	@WeldSetup
	public WeldInitiator weld = WeldInitiator.of(IComponenteFabrica.class).of(ComponenteFabricaImpl.class);

	@Test
	void testCriarBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = componenteFabrica.criarBotao("Conectar", new IAcao(new Object()) {
			@Override
			public Resposta execute() {
				return new Resposta();
			}
		}, true);

		assertTrue(Optional.of(button).isPresent());

	}
	
	@Test
	void testClickBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = componenteFabrica.criarBotao("Conectar", new IAcao(new Object()) {
			@Override
			public Resposta execute() {
				return new Resposta();
			}
		}, true);
		
		assertTrue(Optional.of(button.doClick()).isPresent());

	}
	
	@Test
	void testRenderBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = componenteFabrica.criarBotao("Conectar", new IAcao(new Object()) {
			@Override
			public Resposta execute() {
				return new Resposta();
			}
		}, true);
		
		assertTrue(Optional.of(button.doRender()).isPresent() && button.doRender().length() > 0);

	}


}
