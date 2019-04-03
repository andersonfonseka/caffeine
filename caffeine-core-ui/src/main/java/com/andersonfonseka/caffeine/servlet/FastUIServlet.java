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

import com.andersonfonseka.caffeine.component.Button;
import com.andersonfonseka.caffeine.component.Component;
import com.andersonfonseka.caffeine.component.Input;
import com.andersonfonseka.caffeine.component.Page;
import com.andersonfonseka.caffeine.component.Project;

public class FastUIServlet extends HttpServlet {

	@Inject
	private BeanManager beanManager;
	
	private static final String OP = "op";
	
	private static final String COMPONENTID = "componentId";
	
	private static final String PROJECT = "project";
	
	private static final String PROJECTCLASS = "projectClass";
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(FastUIServlet.class.getName());
	

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
			
		Project project = null; 
		
		project = startProject(req, project);
		
		if (componentId != null) {
		
			Page page = (Page) project.findPageById(componentId);
			page.onLoad(getParameters(req, page));
			
			log.info(page.toString());
			
			Button button = (Button) page.findById(page, op).get();
			
			if (!button.isImmediate()) {
				updateModel(req, page);
				applyValidation(req, page);
			}

			page = executeAction(req, project, page, op);
			printPage(resp, page);	

		} else {
			printInitialPage(resp, project);
		}
	}

	private Project startProject(HttpServletRequest req, Project project) {
		if (req.getServletContext().getAttribute(PROJECT) == null)  {
			
		    try {
			
		    	ManagedBean<?> bean = (ManagedBean) beanManager.getBeans(Class.forName(getServletContext().getInitParameter(PROJECTCLASS))).iterator().next();
		    	
		    	if (bean != null) {
		            CreationalContext creationalContext = beanManager.createCreationalContext(bean);
		            if (creationalContext != null) {
		                project = (Project) bean.create(creationalContext);
		            	req.getServletContext().setAttribute(PROJECT, project);	
		            }
		        }
			
		    } catch (ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			
		
		} else {
			project = (Project) req.getServletContext().getAttribute(PROJECT);
		}
		return project;
	}

	private Page executeAction(HttpServletRequest req, Project project, Page page, String op) {
		
		Page pageResult = page;
		
		if (page.getMessages().isEmpty()) {
			
			Button button = (Button) page.findById(page, op).get();
			PageResponse pageResponse = button.doClick();
			
			pageResult = project.findPageById(pageResponse.pageUrl);
			pageResult.setMessages(pageResponse.getMessages());
			pageResult.onLoad(getParameters(req, page));
			
		}

		return pageResult;
	}

	private void updateModel(HttpServletRequest req, Page page) {
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			
			String id = names.nextElement();
			log.info(id);
			
			if (!id.equals(OP) && !id.equals(COMPONENTID)) {
				
				if (page.findById(page, id).isPresent()) {
					Component component =  page.findById(page, id).get();
					if (component instanceof Input) {
						Input input = (Input) component;
						input.setValue(req.getParameter(id));
					}
				}
			}
		}
	}
	
	private Map<String, String> getParameters(HttpServletRequest req, Page page) {

		Map<String, String> results = new HashMap<String, String>();
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			
			String id = names.nextElement();
			results.put(id, req.getParameter(id));  
		}
		
		return results;
	}
	
	private void applyValidation(HttpServletRequest req, Page page) {
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			
			String id = names.nextElement();
			log.info(id);
			
			if (!id.equals(OP) && !id.equals(COMPONENTID)) {

				if (page.findById(page, id).isPresent()) {
					Component component =  page.findById(page, id).get();
					if (component instanceof Input) {
						Input input = (Input) component;
						page.addMessages(input.validate());
					}
				}
			}
		}
	}

	private void printPage(HttpServletResponse resp, Page page) throws IOException {
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		pw.write(page.doRender());
		pw.close();
	}

	private void printInitialPage(HttpServletResponse resp, Project project) throws IOException {
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		Page initialPage = project.getInitialPage(); 
		
		initialPage.onLoad(null);
		pw.write(initialPage.doRender());
		pw.close();
	}
	
}
