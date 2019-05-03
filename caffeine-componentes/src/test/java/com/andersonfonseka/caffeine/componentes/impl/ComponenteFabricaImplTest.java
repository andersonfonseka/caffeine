package com.andersonfonseka.caffeine.componentes.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IConteiner;
import com.andersonfonseka.caffeine.IEndereco;
import com.andersonfonseka.caffeine.IEntradaAreaTexto;
import com.andersonfonseka.caffeine.IEntradaArquivo;
import com.andersonfonseka.caffeine.IEntradaData;
import com.andersonfonseka.caffeine.IEntradaEmail;
import com.andersonfonseka.caffeine.IEntradaNumero;
import com.andersonfonseka.caffeine.IEntradaSenha;
import com.andersonfonseka.caffeine.IEntradaTexto;
import com.andersonfonseka.caffeine.IFormulario;
import com.andersonfonseka.caffeine.IOpcaoSelecao;
import com.andersonfonseka.caffeine.IRotulo;
import com.andersonfonseka.caffeine.ISelecao;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;

@EnableWeld
class ComponenteFabricaImplTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = componenteFabrica.criarBotao("Conectar", new AcaoAbs(new Object()) {
			@Override
			public Resposta execute() {
				return null;
			}
		}, true);

		assertTrue(Optional.of(button).isPresent());

	}

	@Test
	void testCriarConteiner(IComponenteFabrica componenteFabrica) {
		IConteiner conteiner = componenteFabrica.criarConteiner(1);
		assertTrue(Optional.of(conteiner).isPresent());
	}

	@Test
	void testCriarFormulario(IComponenteFabrica componenteFabrica) {
		IFormulario formulario = componenteFabrica.criarFormulario();
		assertTrue(Optional.of(formulario).isPresent());
	}

	@Test
	void testCriarEndereco(IComponenteFabrica componenteFabrica) {
		IEndereco endereco = componenteFabrica.criarEndereco(new Pagina() {

			private static final long serialVersionUID = 1L;

			@Override
			public void post() {
			}

			@Override
			public void aoCarregar(Map<String, Object> parametros) {
			}});
		assertTrue(Optional.of(endereco).isPresent());
	}

	@Test
	void testCriarEntradaAreaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaAreaTexto entradaAreaTexto = componenteFabrica.criarEntradaAreaTexto("Observacoes", true, 5);
		assertTrue(Optional.of(entradaAreaTexto).isPresent());
	}

	@Test
	void testCriarEntradaData(IComponenteFabrica componenteFabrica) {
		IEntradaData txtDoB = componenteFabrica.criarEntradaData("Data de nascimento", "yyyy-MM-dd", true);
		assertTrue(Optional.of(txtDoB).isPresent());
	}

	@Test
	void testCriarEntradaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaTexto txtFirstName = componenteFabrica.criarEntradaTexto("Primeiro nome", true);
		assertTrue(Optional.of(txtFirstName).isPresent());
	}

	@Test
	void testCriarEntradaArquivo(IComponenteFabrica componenteFabrica) {
		IEntradaArquivo entradaArquivo = componenteFabrica.criarEntradaArquivo("Teste", true);
		assertTrue(Optional.of(entradaArquivo).isPresent());
	}

	@Test
	void testCriarEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaEmail txtEmail = componenteFabrica.criarEntradaEmail("Email", true);
		assertTrue(Optional.of(txtEmail).isPresent());
	}

	@Test
	void testCriarEntradaNumero(IComponenteFabrica componenteFabrica) {
		IEntradaNumero txDependentes = componenteFabrica.criarEntradaNumero("Dependentes", false);
		assertTrue(Optional.of(txDependentes).isPresent());
	}

	@Test
	void testCriarEntradaSenha(IComponenteFabrica componenteFabrica) {
		IEntradaSenha txtSenha = componenteFabrica.criarEntradaSenha("Senha", true);
		assertTrue(Optional.of(txtSenha).isPresent());
	}

	@Test
	void testCriarRotulo(IComponenteFabrica componenteFabrica) {
		IRotulo rotulo = componenteFabrica.criarRotulo("Rotulo");
		assertTrue(Optional.of(rotulo).isPresent());
	}

	@Test
	void testCriarSelecao(IComponenteFabrica componenteFabrica) {

		ISelecao selecao = componenteFabrica.criarSelecao("Genero", true);
		selecao.adicionar(componenteFabrica.criarOpcaoSelecao("1", "Masculino"));
		selecao.adicionar(componenteFabrica.criarOpcaoSelecao("2", "Feminino"));
		assertTrue(Optional.of(selecao).isPresent());
	}

	@Test
	void testCriarOpcaoSelecao(IComponenteFabrica componenteFabrica) {
		IOpcaoSelecao opcaoSelecao = componenteFabrica.criarOpcaoSelecao("1", "Masculino");
		assertTrue(Optional.of(opcaoSelecao).isPresent());
	}

}
