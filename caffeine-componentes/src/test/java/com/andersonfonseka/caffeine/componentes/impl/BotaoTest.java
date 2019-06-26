package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.logging.Logger;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Botao;

@EnableWeld
class BotaoTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = new Botao.Builder("Conectar", new AcaoAbs(new Object()) {
			@Override
			public IResposta execute() {
				IResposta resp = new Resposta.Builder().build();
				resp.adicionar("blalablbalbalbalba");
				return resp;
			}
		}, true).build();

		assertTrue(Optional.of(button).isPresent());

	}
	
	@Test
	void testClickBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = new Botao.Builder("Conectar", new AcaoAbs(new Object()) {
			@Override
			public IResposta execute() {
				IResposta resp = new Resposta.Builder().build();
				resp.adicionar("blalablbalbalbalba");
				
				Logger.getAnonymousLogger().fine(getSource().toString());
				
				return resp;
			}
		}, true).build();
		
		assertTrue(Optional.of(button.doClick()).isPresent());

	}
	
	@Test
	void testRenderBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = new Botao.Builder("Conectar", new AcaoAbs(new Object()) {
			@Override
			public IResposta execute() {
				return new Resposta.Builder().build();
			}
		}, true).build();
		
		assertTrue(Optional.of(button.gerarSaida()).isPresent() && button.gerarSaida().length() > 0);

	}


}
