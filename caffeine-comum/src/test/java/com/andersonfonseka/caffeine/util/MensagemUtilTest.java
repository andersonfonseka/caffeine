package com.andersonfonseka.caffeine.util;

import static org.junit.Assert.assertNotNull; 

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

@EnableWeld
class MensagemUtilTest {
	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(WeldInitiator.createWeld()
														.beanClasses(MensagemUtil.class));
	
	@Test
	void obterMensagemPorChaveValor(MensagemUtil mensagemUtil) {
		assertNotNull(mensagemUtil.getMessage("REQUIREDFIELD", "Nome"));
	}

	@Test
	void obterMensagemComum(MensagemUtil mensagemUtil) {
		assertNotNull(mensagemUtil.getMessage("REQUIREDFIELD"));
	}

	
}
