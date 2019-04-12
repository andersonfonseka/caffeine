package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.logging.Logger;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.acao.IAcao;

@EnableWeld
class BotaoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = componenteFabrica.criarBotao("Conectar", new IAcao(new Object()) {
			@Override
			public Resposta execute() {
				Resposta resp = new Resposta();
				resp.adicionar("blalablbalbalbalba");
				return resp;
			}
		}, true);

		assertTrue(Optional.of(button).isPresent());

	}
	
	@Test
	void testClickBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = componenteFabrica.criarBotao("Conectar", new IAcao(new Object()) {
			@Override
			public Resposta execute() {
				Resposta resp = new Resposta();
				resp.adicionar("blalablbalbalbalba");
				resp.setPageUrl("");
				
				Logger.getAnonymousLogger().fine(getSource().toString());
				
				return resp;
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
		
		assertTrue(Optional.of(button.gerarSaida()).isPresent() && button.gerarSaida().length() > 0);

	}


}
