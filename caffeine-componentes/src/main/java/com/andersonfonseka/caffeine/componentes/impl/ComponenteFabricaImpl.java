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
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IConteiner;
import com.andersonfonseka.caffeine.IEndereco;
import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IProjeto;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.ISelecao;
import com.andersonfonseka.caffeine.ITipoValor;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Botao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;
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
	
	public IBotao criarBotaoCancelar(Class<? extends IPagina> paginaDestino) {
		
		IBotao btnCancel = new Botao.Builder("Cancelar", new AcaoAbs(new Object()) {
			public IResposta execute() {
				
				IResposta pageResponse = new Resposta.Builder().build();
				pageResponse.setPageUrl(paginaDestino);
				
				return pageResponse;
			}
		}, true).build();
		
		btnCancel.setEstilo("btn-danger");
		btnCancel.setImediato(true);
		
		return btnCancel;
	}
	
	public IConteiner criarConteiner(Integer rows) {
		return new Conteiner(rows);
	}
	
	public IEndereco criarEndereco(IPagina pagina) {
		return new Endereco(this, pagina);
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
	public IAcesso criarAcesso(IPagina pagina, Map<String, String> usuarios, Class<? extends IPagina> paginaDestino) {
		return new Acesso(this, pagina, usuarios, paginaDestino);
	}

	@Override
	public ITipoValor criarTipoValor(IPagina pagina, ISelecao selecaoTipo) {
		return new TipoValor(this, pagina, selecaoTipo);
	}
	
}
