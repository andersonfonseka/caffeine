package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaSenha;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaSenha;

@EnableWeld
class EntradaSenhaTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);
	
	@Test
	void testCriarEntradaSenha(IComponenteFabrica componenteFabrica) {
		IEntradaSenha entradaSenha = new EntradaSenha.Builder("Senha", true).build();
		assertTrue(Optional.ofNullable(entradaSenha).isPresent());
	}
	
	@Test
	void testRenderEntradaSenha(IComponenteFabrica componenteFabrica) {
		IEntradaSenha entradaSenha = new EntradaSenha.Builder("Senha", true).build();
		assertTrue(Optional.ofNullable(entradaSenha.gerarSaida()).isPresent() && entradaSenha.gerarSaida().length() > 0);
	}
	
	@Test
	void testValidarEntradaSenha(IComponenteFabrica componenteFabrica) {
		IEntradaSenha entradaSenha = new EntradaSenha.Builder("Senha", true).build();
		entradaSenha.setValor("123");
		assertTrue(entradaSenha.validar().isEmpty());
	}
	
}
