package com.andersonfonseka.caffeine.componentes.impl;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.weld.bean.ManagedBean;

import com.andersonfonseka.caffeine.IAcesso;
import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.ICard;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IConteiner;
import com.andersonfonseka.caffeine.IEndereco;
import com.andersonfonseka.caffeine.IEntradaAreaTexto;
import com.andersonfonseka.caffeine.IEntradaArquivo;
import com.andersonfonseka.caffeine.IEntradaCheckbox;
import com.andersonfonseka.caffeine.IEntradaData;
import com.andersonfonseka.caffeine.IEntradaEmail;
import com.andersonfonseka.caffeine.IEntradaNumero;
import com.andersonfonseka.caffeine.IEntradaOculta;
import com.andersonfonseka.caffeine.IEntradaSenha;
import com.andersonfonseka.caffeine.IEntradaTexto;
import com.andersonfonseka.caffeine.IFormulario;
import com.andersonfonseka.caffeine.IMenu;
import com.andersonfonseka.caffeine.IMenuItem;
import com.andersonfonseka.caffeine.IOpcaoSelecao;
import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IProjeto;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.IRotulo;
import com.andersonfonseka.caffeine.ISelecao;
import com.andersonfonseka.caffeine.ITabela;
import com.andersonfonseka.caffeine.ITabelaColuna;
import com.andersonfonseka.caffeine.ITipoValor;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Botao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Card;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaAreaTexto;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaArquivo;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaCheckbox;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaData;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaEmail;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaNumero;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaOculta;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaSenha;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaTexto;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Formulario;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Menu;
import com.andersonfonseka.caffeine.componentes.impl.basicos.MenuItem;
import com.andersonfonseka.caffeine.componentes.impl.basicos.OpcaoSelecao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Rotulo;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Selecao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Tabela;
import com.andersonfonseka.caffeine.componentes.impl.basicos.TabelaColuna;
import com.andersonfonseka.caffeine.componentes.impl.compostos.Acesso;
import com.andersonfonseka.caffeine.componentes.impl.compostos.Endereco;
import com.andersonfonseka.caffeine.componentes.impl.compostos.TipoValor;

public class ComponenteFabricaImpl implements IComponenteFabrica, Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ComponenteFabricaImpl.class.getName());
	
	@Inject
	private BeanManager beanManager;
	
	@Override
	public void setBeanManager(BeanManager beanManager) {
		this.beanManager = beanManager;
	}
	
	public ICard criarCard(String imagem, String titulo, String texto, IBotao botao) {

		Card card = new Card();

		card.setTitulo(titulo);
		card.setTexto(texto);
		card.setImagem(imagem);
		
		card.adicionar(botao);
		
		return card;
	}

	public IMenu criarMenu(String titulo) {
		Menu menu = new Menu();
		menu.setTitulo(titulo);
		return menu;
	}
	
	public IMenuItem criarMenuItem(String titulo, AcaoAbs acao) {
		MenuItem menuItem = new MenuItem();
		menuItem.setTitulo(titulo);
		menuItem.setAcao(acao);
		menuItem.setImediato(true);
		
		return menuItem;
	}

	
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
			log.log(Level.WARNING, e.getMessage());
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
	
	
	public IBotao criarBotaoCancelar(Class<? extends IPagina> paginaDestino) {
		
		IBotao btnCancel = criarBotao("Cancelar", new AcaoAbs(new Object()) {
			public IResposta execute() {
				
				IResposta pageResponse = criarResposta();
				pageResponse.setPageUrl(paginaDestino);
				
				return pageResponse;
			}
		}, true);
		
		btnCancel.setEstilo("btn-danger");
		btnCancel.setImediato(true);
		
		return btnCancel;
	}

	
	
	public IConteiner criarConteiner(Integer rows) {
		return new Conteiner(rows);
	}

	public IFormulario criarFormulario() {
		return new Formulario();
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
		return new OpcaoSelecao(valor, rotulo);
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
			log.log(Level.WARNING, e.getMessage());
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
	public ITabela criarTabela(String id) {
		return new Tabela(id);
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

	@Override
	public IAcesso criarAcesso(IPagina pagina, Map<String, String> usuarios, Class<? extends IPagina> paginaDestino) {
		return new Acesso(this, pagina, usuarios, paginaDestino);
	}

	@Override
	public ITipoValor criarTipoValor(IPagina pagina, ISelecao selecaoTipo) {
		return new TipoValor(this, pagina, selecaoTipo);
	}

	@Override
	public IEntradaOculta criarEntradaOculta(String id, String valor) {

		EntradaOculta entradaOculta = new EntradaOculta();
		entradaOculta.setId(id);
		entradaOculta.setValor(valor);
		
		return entradaOculta;
	}
	
}
