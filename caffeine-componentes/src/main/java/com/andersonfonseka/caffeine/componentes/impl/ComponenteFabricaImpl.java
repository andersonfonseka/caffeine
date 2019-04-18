package com.andersonfonseka.caffeine.componentes.impl;
import java.io.Serializable;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.weld.bean.ManagedBean;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;
import com.andersonfonseka.caffeine.componentes.IEndereco;
import com.andersonfonseka.caffeine.componentes.IEntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.IEntradaArquivo;
import com.andersonfonseka.caffeine.componentes.IEntradaCheckbox;
import com.andersonfonseka.caffeine.componentes.IEntradaData;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaNumero;
import com.andersonfonseka.caffeine.componentes.IEntradaOculta;
import com.andersonfonseka.caffeine.componentes.IEntradaSenha;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IFormulario;
import com.andersonfonseka.caffeine.componentes.IOpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.IProjeto;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.IRotulo;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.ITabela;
import com.andersonfonseka.caffeine.componentes.ITabelaColuna;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;

public class ComponenteFabricaImpl implements IComponenteFabrica, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private BeanManager beanManager;
	
	@Override
	public void setBeanManager(BeanManager beanManager) {
		this.beanManager = beanManager;
	}

	public ComponenteFabricaImpl() {}
	
	public IProjeto criarProjeto(String id) {
		
		IProjeto projeto = null;

		try {
			
			if (!beanManager.getBeans(Class.forName(id)).isEmpty()) {

				@SuppressWarnings("rawtypes")
				ManagedBean bean = (ManagedBean) beanManager.getBeans(Class.forName(id)).iterator().next();
		    	
	            CreationalContext<?> creationalContext = beanManager.createCreationalContext(bean);
	            projeto = (IProjeto) bean.create(creationalContext);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return projeto;

		
		
	}
	
	public IResposta criarResposta() {
		return new Resposta();
	}
	
	public IBotao criarBotao(String titulo, AcaoAbs acao, boolean imediato) {
		
		Botao botao = new Botao();
			  botao.setImediato(imediato);
			  botao.setTitulo(titulo);
			  botao.setAcao(acao);
		
		return botao;
	}
	
	
	public IBotao criarBotaoCancelar(String paginaDestino) {
		
		IBotao btnCancel = criarBotao("Cancelar", new AcaoAbs(new Object()) {
			public IResposta execute() {
				
				IResposta pageResponse = criarResposta();
				pageResponse.setPageUrl(paginaDestino);
				
				return pageResponse;
			}
		}, true);
		
		btnCancel.setImediato(true);
		
		return btnCancel;
	}

	
	
	public IConteiner criarConteiner(Integer rows) {
		Conteiner conteiner = new Conteiner(rows);
		return conteiner;
	}

	public IFormulario criarFormulario() {
		Formulario formulario = new Formulario();
		return formulario;
	}

	
	public IEndereco criarEndereco(IPagina pagina) {
		return new Endereco(this, pagina);
	}

	@Override
	public IEntradaAreaTexto criarEntradaAreaTexto(String titulo, boolean obrigatorio, int linhas) {
		
		EntradaAreaTexto entradaAreaTexto = new EntradaAreaTexto();
		entradaAreaTexto.setTitulo(titulo);
		entradaAreaTexto.setObrigatorio(obrigatorio);
		entradaAreaTexto.setRows(linhas);
		
		return entradaAreaTexto;
	}

	@Override
	public IEntradaData criarEntradaData(String titulo, String pattern, boolean obrigatorio) {
		
		EntradaData entradaData = new EntradaData();
		entradaData.setTitulo(titulo);
		entradaData.setPattern(pattern);
		entradaData.setObrigatorio(obrigatorio);
		
		return entradaData;
	}

	@Override
	public IEntradaTexto criarEntradaTexto(String titulo, boolean obrigatorio) {

		EntradaTexto entradaTexto = new EntradaTexto();
		entradaTexto.setTitulo(titulo);
		entradaTexto.setObrigatorio(obrigatorio);
		
		return entradaTexto;
	}
	
	@Override
	public IEntradaOculta criarEntradaOculta(String valor) {

		EntradaOculta entradaOculta = new EntradaOculta();
		entradaOculta.setValor(valor);
		
		return entradaOculta;
	}

	
	@Override
	public IEntradaCheckbox criarEntradaCheckbox(String titulo, String valor, boolean obrigatorio) {

		EntradaCheckbox entradaCheckbox = new EntradaCheckbox();
		entradaCheckbox.setTitulo(titulo);
		entradaCheckbox.setObrigatorio(obrigatorio);
		entradaCheckbox.setValor(valor);
		
		return entradaCheckbox;
	}

	@Override
	public IEntradaCheckbox criarEntradaCheckbox(String id, String titulo, String valor, boolean obrigatorio) {

		EntradaCheckbox entradaCheckbox = new EntradaCheckbox();
		entradaCheckbox.setId(id);
		entradaCheckbox.setTitulo(titulo);
		entradaCheckbox.setObrigatorio(obrigatorio);
		entradaCheckbox.setValor(valor);
		
		return entradaCheckbox;
	}

	@Override
	public IEntradaArquivo criarEntradaArquivo(String titulo, boolean obrigatorio) {

		EntradaArquivo entradaArquivo = new EntradaArquivo();
		entradaArquivo.setTitulo(titulo);
		entradaArquivo.setObrigatorio(obrigatorio);
		
		return entradaArquivo;
	}

	@Override
	public IEntradaEmail criarEntradaEmail(String titulo, boolean obrigatorio) {

		EntradaEmail entradaEmail = new EntradaEmail();
		entradaEmail.setTitulo(titulo);
		entradaEmail.setObrigatorio(obrigatorio);
		
		return entradaEmail;
	}

	@Override
	public IEntradaNumero criarEntradaNumero(String titulo, boolean obrigatorio) {

		EntradaNumero entradaNumero = new EntradaNumero();
		entradaNumero.setTitulo(titulo);
		entradaNumero.setObrigatorio(obrigatorio);
		
		return entradaNumero;
	}

	@Override
	public IEntradaSenha criarEntradaSenha(String titulo, boolean obrigatorio) {
		
		EntradaSenha entradaSenha = new EntradaSenha();
		entradaSenha.setTitulo(titulo);
		entradaSenha.setObrigatorio(obrigatorio);
		
		return entradaSenha;
	}

	@Override
	public IRotulo criarRotulo(String titulo) {
		
		Rotulo rotulo = new Rotulo();
		rotulo.setTitulo(titulo);
		
		return rotulo;
	}

	@Override
	public IOpcaoSelecao criarOpcaoSelecao(String valor, String rotulo) {
		OpcaoSelecao opcaoSelecao = new OpcaoSelecao(valor, rotulo);
		return opcaoSelecao;
	}

	@Override
	public IPagina criarPagina(String id) {

		IPagina page = null;

		try {
			
			if (!beanManager.getBeans(Class.forName(id)).isEmpty()) {

				@SuppressWarnings("rawtypes")
				ManagedBean bean = (ManagedBean) beanManager.getBeans(Class.forName(id)).iterator().next();

				CreationalContext<?> creationalContext = beanManager.createCreationalContext(bean);
                page = (IPagina) bean.create(creationalContext);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return page;
	}

	@Override
	public ISelecao criarSelecao(String titulo, boolean obrigatorio) {

		Selecao selecao = new Selecao();
		selecao.setTitulo(titulo);
		selecao.setObrigatorio(obrigatorio);
		
		return selecao;
	}

	@Override
	public ISelecao criarSelecao(String titulo, AcaoAbs acao, boolean obrigatorio) {

		Selecao selecao = new Selecao();
		selecao.setTitulo(titulo);
		selecao.setObrigatorio(obrigatorio);
		selecao.setAcao(acao);
		
		return selecao;
	}

	@Override
	public ITabela criarTabela() {
		return new Tabela();
	}

	@Override
	public ITabelaColuna criarTabelaColuna(String titulo, String campo) {
		TabelaColuna tabelaColuna = new TabelaColuna();
		
		tabelaColuna.setTitulo(titulo);
		tabelaColuna.setCampo(campo);
		tabelaColuna.setSelecionavel(false);
		
		return tabelaColuna;
	}
	
	@Override
	public ITabelaColuna criarTabelaColuna(String titulo, String campo, boolean selecionavel) {
		TabelaColuna tabelaColuna = new TabelaColuna();
		
		tabelaColuna.setTitulo(titulo);
		tabelaColuna.setCampo(campo);
		tabelaColuna.setSelecionavel(selecionavel);
		
		return tabelaColuna;
	}
	
}
