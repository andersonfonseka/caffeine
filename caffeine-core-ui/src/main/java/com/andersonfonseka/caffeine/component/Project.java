package com.andersonfonseka.caffeine.component;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.weld.bean.ManagedBean;

import lombok.Data;

@ApplicationScoped
public @Data class Project extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = -220945867939169696L;

	@Inject
	private BeanManager beanManager;
	
	private String title;

	private Class<? extends Page> initialPage;

	private Map<String, Class<? extends Page>> pages = new HashMap<String, Class<? extends Page>>();

	public Project() {}

	@Override
	public String getTemplate() {
		return "project";
	}

	public Project addPage(Class<? extends Page> page) {
		this.pages.put(page.getName(), page);
		return this;
	}

	public Page findPageById(String id) {

		Page page = null;

		try {
			
			ManagedBean bean = (ManagedBean) beanManager.getBeans(Class.forName(id)).iterator().next();
	    	
	    	if (bean != null) {
	            CreationalContext<?> creationalContext = beanManager.createCreationalContext(bean);
	            if (creationalContext != null) {
	                page = (Page) bean.create(creationalContext);
	            }
	        }

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	public Page getInitialPage() {
		return findPageById(this.initialPage.getName());
	}

}
