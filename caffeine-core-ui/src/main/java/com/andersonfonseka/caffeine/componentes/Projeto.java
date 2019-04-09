package com.andersonfonseka.caffeine.componentes;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.weld.bean.ManagedBean;

import lombok.Data;

@ApplicationScoped
public @Data class Projeto extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -220945867939169696L;

	@Inject
	private BeanManager beanManager;
	
	private String titulo;

	private Class<? extends Pagina> paginaInicial;

	private Map<String, Class<? extends Pagina>> paginas = new HashMap<String, Class<? extends Pagina>>();

	public Projeto() {}

	@Override
	public String getTemplate() {
		return "project";
	}

	public Projeto addPage(Class<? extends Pagina> page) {
		this.paginas.put(page.getName(), page);
		return this;
	}

	public Pagina findPageById(String id) {

		Pagina page = null;

		try {
			
			ManagedBean bean = (ManagedBean) beanManager.getBeans(Class.forName(id)).iterator().next();
	    	
	    	if (bean != null) {
	            CreationalContext<?> creationalContext = beanManager.createCreationalContext(bean);
	            if (creationalContext != null) {
	                page = (Pagina) bean.create(creationalContext);
	            }
	        }

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	public Pagina getInitialPage() {
		return findPageById(this.paginaInicial.getName());
	}

}
