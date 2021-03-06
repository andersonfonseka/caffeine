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
import com.andersonfonseka.caffeine.componentes.impl.basicos.Botao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaArquivo;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaData;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaEmail;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaNumero;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaSenha;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaTexto;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Formulario;
import com.andersonfonseka.caffeine.componentes.impl.basicos.OpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Pagina;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Rotulo;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Selecao;

@EnableWeld
class ComponenteFabricaImplTest {

	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(ComponenteFabricaImpl.class);

	@Test
	void testCriarBotao(IComponenteFabrica componenteFabrica) {

		IBotao button = new Botao.Builder("Conectar", new AcaoAbs(new Object()) {
			@Override
			public Resposta execute() {
				return null;
			}
		}, true).build();

		assertTrue(Optional.of(button).isPresent());

	}

	@Test
	void testCriarConteiner(IComponenteFabrica componenteFabrica) {
		IConteiner conteiner = componenteFabrica.criarConteiner(1);
		assertTrue(Optional.of(conteiner).isPresent());
	}

	@Test
	void testCriarFormulario(IComponenteFabrica componenteFabrica) {
		IFormulario formulario = new Formulario.Builder().build();
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
		IEntradaAreaTexto entradaAreaTexto = new EntradaAreaTexto.Builder("Observacoes", true, 5).build();
		assertTrue(Optional.of(entradaAreaTexto).isPresent());
	}

	@Test
	void testCriarEntradaData(IComponenteFabrica componenteFabrica) {
		IEntradaData txtDoB = new EntradaData.Builder("Data de nascimento", "yyyy-MM-dd", true).build();
		assertTrue(Optional.of(txtDoB).isPresent());
	}

	@Test
	void testCriarEntradaTexto(IComponenteFabrica componenteFabrica) {
		IEntradaTexto txtFirstName = new EntradaTexto.Builder("Primeiro nome", true).build();
		assertTrue(Optional.of(txtFirstName).isPresent());
	}

	@Test
	void testCriarEntradaArquivo(IComponenteFabrica componenteFabrica) {
		IEntradaArquivo entradaArquivo = new EntradaArquivo.Builder("Teste", true).build();
		assertTrue(Optional.of(entradaArquivo).isPresent());
	}

	@Test
	void testCriarEntradaEmail(IComponenteFabrica componenteFabrica) {
		IEntradaEmail txtEmail = new EntradaEmail.Builder("Email", true).build();
		assertTrue(Optional.of(txtEmail).isPresent());
	}

	@Test
	void testCriarEntradaNumero(IComponenteFabrica componenteFabrica) {
		IEntradaNumero txDependentes = new EntradaNumero.Builder("Dependentes", false).build();
		assertTrue(Optional.of(txDependentes).isPresent());
	}

	@Test
	void testCriarEntradaSenha(IComponenteFabrica componenteFabrica) {
		IEntradaSenha txtSenha = new EntradaSenha.Builder("Senha", true).build();
		assertTrue(Optional.of(txtSenha).isPresent());
	}

	@Test
	void testCriarRotulo(IComponenteFabrica componenteFabrica) {
		IRotulo rotulo = new Rotulo.Builder("Rotulo").build();
		assertTrue(Optional.of(rotulo).isPresent());
	}

	@Test
	void testCriarSelecao(IComponenteFabrica componenteFabrica) {

		ISelecao selecao = new Selecao.Builder("Genero", true).build();
		selecao.adicionar(new OpcaoSelecao.Builder("1", "Masculino").build());
		selecao.adicionar(new OpcaoSelecao.Builder("2", "Feminino").build());
		assertTrue(Optional.of(selecao).isPresent());
	}

	@Test
	void testCriarOpcaoSelecao(IComponenteFabrica componenteFabrica) {
		IOpcaoSelecao opcaoSelecao = new OpcaoSelecao.Builder("1", "Masculino").build();
		assertTrue(Optional.of(opcaoSelecao).isPresent());
	}

}
