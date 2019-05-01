package com.andersonfonseka.caffeine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.caffeine.componentes.IAcao;
import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntrada;
import com.andersonfonseka.caffeine.componentes.IEntradaCheckbox;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.IProjeto;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.impl.ComponenteFabricaImpl;

public class CaffeineServlet extends HttpServlet {

	@Inject
	private BeanManager beanManager;
	
	private static final String OP = "op";

	private static final String COMPONENTID = "componentId";

	private static final String PROJECT = "project";

	private static final String PROJECTCLASS = "projectClass";

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CaffeineServlet.class.getName());
	
	
	public CaffeineServlet() {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IComponenteFabrica componenteFabrica = new ComponenteFabricaImpl();
		componenteFabrica.setBeanManager(beanManager);
		
		IProjeto project = iniciarProjeto(req);

		String op = "";
		String componentId = null;

		if (Optional.ofNullable(req.getParameter(OP)).isPresent()) {
			op = req.getParameter(OP);
			componentId = req.getParameter(COMPONENTID);
		}

		if (Optional.ofNullable(componentId).isPresent()) {
			construirPagina(req, resp, project, op, componentId);
		} else {
			renderizarPaginaInicial(resp, project);
		}
	}

	private void construirPagina(HttpServletRequest req, HttpServletResponse resp, IProjeto project, String op, String componentId) throws IOException {
		
		IPagina page = project.obterPaginaPeloId(componentId);
		page.aoCarregar(obterParametros(req));

		log.info(page.toString());

		IAcao button = (IAcao) page.obterPorId(page, op).get();

		if (button.isImediato()) {
			atualizarModelo(req, page);
		} else {
			atualizarModelo(req, page);
			aplicarValidacao(req, page);
		}

		page = executarAcao(req, project, page, op);
		renderizarPagina(resp, page);
	}

	private IProjeto iniciarProjeto(HttpServletRequest req) {

		IComponenteFabrica componenteFabrica = new ComponenteFabricaImpl();
		componenteFabrica.setBeanManager(beanManager);
		
		
		IProjeto projeto = null;

		if (!Optional.ofNullable(req.getServletContext().getAttribute(PROJECT)).isPresent()) {
			projeto = componenteFabrica.criarProjeto(req.getServletContext().getInitParameter(PROJECTCLASS));
			req.getServletContext().setAttribute(PROJECT, projeto);
		} else {
			projeto = (IProjeto) req.getServletContext().getAttribute(PROJECT);
		}

		projeto.setComponenteFabrica(componenteFabrica);
		
		return projeto;
	}

	private IPagina executarAcao(HttpServletRequest req, IProjeto project, IPagina page, String op) {

		IPagina pageResult = page;

		if (page.getMensagens().isEmpty()) {

			IAcao button = (IAcao) page.obterPorId(page, op).get();
			IComponente componente = (IComponente) button;
			
			IResposta pageResponse = button.doClick();

			pageResult = project.obterPaginaPeloId(pageResponse.getPageUrl().getName());
			pageResult.setMensagens(pageResponse.getMensagens());
			
			Map<String, Object> atributos = obterParametros(req);
			
			if (pageResponse.getAtributo() != null) {
				atributos.putAll(pageResponse.getAtributo());
			}
			
			pageResult.aoCarregar(atributos);
		}

		return pageResult;
	}

	private void atualizarModelo(HttpServletRequest req, IPagina page) {

		Enumeration<String> names = req.getParameterNames();

		if (Optional.ofNullable(names).isPresent()) {

			while (names.hasMoreElements()) {
				String id = names.nextElement();

				if (!id.equals(OP) && !id.equals(COMPONENTID)) {

					if (page.obterPorId(page, id).isPresent()) {
						IComponente component = page.obterPorId(page, id).get();
						
						if (component instanceof IEntradaCheckbox) {
							((IEntradaCheckbox) component).setChecked(true);
						
						} else if (component instanceof IEntrada) {
							IEntrada input = (IEntrada) component;
							input.setValor(req.getParameter(id));
						}
					}
				}
			}
		}
	}

	private Map<String, Object> obterParametros(HttpServletRequest req) {

		Map<String, Object> results = new HashMap<String, Object>();
		Enumeration<String> names = req.getParameterNames();

		if (Optional.ofNullable(names).isPresent()) {

			if (Optional.ofNullable(names).isPresent()) {
				while (names.hasMoreElements()) {
					String id = names.nextElement();
					results.put(id, req.getParameter(id));
				}
			}
		}

		return results;
	}

	private void aplicarValidacao(HttpServletRequest req, IPagina page) {

		Enumeration<String> names = req.getParameterNames();

		if (Optional.ofNullable(names).isPresent()) {

			while (names.hasMoreElements()) {
				String id = names.nextElement();

				if (!id.equals(OP) && !id.equals(COMPONENTID)) {

					if (page.obterPorId(page, id).isPresent()) {
						IComponente component = page.obterPorId(page, id).get();
						if (component instanceof IEntrada) {
							IEntrada input = (IEntrada) component;

							for (String msg : input.validar()) {
								page.adicionaMensagem(msg);
							}
						}
					}
				}
			}
		}
	}

	private void renderizarPagina(HttpServletResponse resp, IPagina page) throws IOException {

		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		pw.write(page.gerarSaida());
		pw.close();
	}

	private void renderizarPaginaInicial(HttpServletResponse resp, IProjeto project) throws IOException {

		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		IPagina paginaInicial = project.getPaginaInicial();
		pw.write(paginaInicial.gerarSaida());
		pw.close();
	}
}
