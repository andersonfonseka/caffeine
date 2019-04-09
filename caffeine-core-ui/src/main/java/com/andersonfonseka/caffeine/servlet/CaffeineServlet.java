package com.andersonfonseka.caffeine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.bean.ManagedBean;

import com.andersonfonseka.caffeine.componentes.Botao;
import com.andersonfonseka.caffeine.componentes.Componente;
import com.andersonfonseka.caffeine.componentes.Entrada;
import com.andersonfonseka.caffeine.componentes.Pagina;
import com.andersonfonseka.caffeine.componentes.Projeto;

public class CaffeineServlet extends HttpServlet {

	@Inject
	private BeanManager beanManager;
	
	private static final String OP = "op";
	
	private static final String COMPONENTID = "componentId";
	
	private static final String PROJECT = "project";
	
	private static final String PROJECTCLASS = "projectClass";
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CaffeineServlet.class.getName());
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String op = ""; 
		String componentId = null;
		
		if (req.getParameter(OP) != null) {
			op = req.getParameter(OP);
			componentId = req.getParameter(COMPONENTID);
		}
			
		Projeto project = null; 
		
		project = startProject(req, project);
		
		if (componentId != null) {
		
			Pagina page = (Pagina) project.findPageById(componentId);
			page.aoCarregar(getParameters(req, page));
			
			log.info(page.toString());
			
			Botao button = (Botao) page.findById(page, op).get();
			
			if (!button.isImediato()) {
				updateModel(req, page);
				applyValidation(req, page);
			}

			page = executeAction(req, project, page, op);
			printPage(resp, page);	

		} else {
			printInitialPage(resp, project);
		}
	}

	private Projeto startProject(HttpServletRequest req, Projeto project) {
		if (req.getServletContext().getAttribute(PROJECT) == null)  {
			
		    try {
			
		    	ManagedBean<?> bean = (ManagedBean) beanManager.getBeans(Class.forName(getServletContext().getInitParameter(PROJECTCLASS))).iterator().next();
		    	
		    	if (bean != null) {
		            CreationalContext creationalContext = beanManager.createCreationalContext(bean);
		            if (creationalContext != null) {
		                project = (Projeto) bean.create(creationalContext);
		            	req.getServletContext().setAttribute(PROJECT, project);	
		            }
		        }
			
		    } catch (ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			
		
		} else {
			project = (Projeto) req.getServletContext().getAttribute(PROJECT);
		}
		return project;
	}

	private Pagina executeAction(HttpServletRequest req, Projeto project, Pagina page, String op) {
		
		Pagina pageResult = page;
		
		if (page.getMensagens().isEmpty()) {
			
			Botao button = (Botao) page.findById(page, op).get();
			Resposta pageResponse = button.doClick();
			
			pageResult = project.findPageById(pageResponse.pageUrl);
			pageResult.setMensagens(pageResponse.getMessages());
			pageResult.aoCarregar(getParameters(req, page));
			
		}

		return pageResult;
	}

	private void updateModel(HttpServletRequest req, Pagina page) {
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			
			String id = names.nextElement();
			log.info(id);
			
			if (!id.equals(OP) && !id.equals(COMPONENTID)) {
				
				if (page.findById(page, id).isPresent()) {
					Componente component =  page.findById(page, id).get();
					if (component instanceof Entrada) {
						Entrada input = (Entrada) component;
						input.setValor(req.getParameter(id));
					}
				}
			}
		}
	}
	
	private Map<String, String> getParameters(HttpServletRequest req, Pagina page) {

		Map<String, String> results = new HashMap<String, String>();
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			
			String id = names.nextElement();
			results.put(id, req.getParameter(id));  
		}
		
		return results;
	}
	
	private void applyValidation(HttpServletRequest req, Pagina page) {
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			
			String id = names.nextElement();
			log.info(id);
			
			if (!id.equals(OP) && !id.equals(COMPONENTID)) {

				if (page.findById(page, id).isPresent()) {
					Componente component =  page.findById(page, id).get();
					if (component instanceof Entrada) {
						Entrada input = (Entrada) component;
						page.adicionaMensagem(input.validate());
					}
				}
			}
		}
	}

	private void printPage(HttpServletResponse resp, Pagina page) throws IOException {
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		pw.write(page.doRender());
		pw.close();
	}

	private void printInitialPage(HttpServletResponse resp, Projeto project) throws IOException {
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		Pagina initialPage = project.getInitialPage(); 
		
		initialPage.aoCarregar(null);
		pw.write(initialPage.doRender());
		pw.close();
	}
	
}
