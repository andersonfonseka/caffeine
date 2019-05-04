package com.andersonfonseka.caffeine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.caffeine.IAcao;
import com.andersonfonseka.caffeine.IComponente;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntrada;
import com.andersonfonseka.caffeine.IEntradaCheckbox;
import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IProjeto;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.impl.ComponenteFabricaImpl;

public class CaffeineServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(CaffeineServlet.class.getName());

	@Inject
	private BeanManager beanManager;

	private static final String OP = "op";

	private static final String COMPONENTID = "componentId";

	private static final String PROJECT = "project";

	private static final String PROJECTCLASS = "projectClass";

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doPost(req, resp);
		} catch (Exception e) {
			log.log(Level.WARNING, e.getMessage());
		}

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

			CaffeineServletDados caffeineServletDados = new CaffeineServletDados();
			caffeineServletDados.setComponentId(componentId);
			caffeineServletDados.setOp(op);
			caffeineServletDados.setReq(req);
			caffeineServletDados.setResp(resp);
			caffeineServletDados.setProject(project);

			construirPagina(caffeineServletDados);
		} else {
			renderizarPaginaInicial(resp, project);
		}
	}

	private void construirPagina(CaffeineServletDados caffeineServletDados) {

		IPagina page = caffeineServletDados.getProject().obterPaginaPeloId(caffeineServletDados.getComponentId());
		page.aoCarregar(obterParametros(caffeineServletDados.getReq()));

		IAcao button = null;
		Optional<IComponente> componente = page.obterPorId(page, caffeineServletDados.getOp());

		if (componente.isPresent()) {
			button = (IAcao) componente.get();
		}

		if (Optional.ofNullable(button).isPresent() && button.isImediato()) {
			atualizarModelo(caffeineServletDados.getReq(), page);
		} else {
			atualizarModelo(caffeineServletDados.getReq(), page);
			aplicarValidacao(caffeineServletDados.getReq(), page);
		}

		page = executarAcao(caffeineServletDados, page);
		page.setTituloProjeto(caffeineServletDados.getProject().getTitulo());
		renderizarPagina(caffeineServletDados.getResp(), page);
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

	private IPagina executarAcao(CaffeineServletDados caffeineServletDados, IPagina page) {

		IPagina pageResult = page;

		if (page.getMensagens().isEmpty()) {

			IAcao button = null;
			Optional<IComponente> componente = page.obterPorId(page, caffeineServletDados.getOp());

			if (componente.isPresent()) {
				button = (IAcao) componente.get();

				IResposta pageResponse = button.doClick();

				pageResult = caffeineServletDados.getProject().obterPaginaPeloId(pageResponse.getPageUrl().getName());
				pageResult.setMensagens(pageResponse.getMensagens());

				Map<String, Object> atributos = obterParametros(caffeineServletDados.getReq());

				if (pageResponse.getAtributo() != null) {
					atributos.putAll(pageResponse.getAtributo());
				}

				pageResult.aoCarregar(atributos);
			}

		}

		return pageResult;
	}

	private void atualizarModelo(HttpServletRequest req, IPagina page) {

		Optional<Enumeration<String>> names = Optional.ofNullable(req.getParameterNames());

		if (names.isPresent()) {

			while (names.get().hasMoreElements()) {
				String id = names.get().nextElement();
				obterComponenteAtualizarModelo(req, page, id);
			}
		}

	}

	private void obterComponenteAtualizarModelo(HttpServletRequest req, IPagina page, String id) {
		if (!id.equals(OP) && !id.equals(COMPONENTID) && page.obterPorId(page, id).isPresent()) {

			Optional<IComponente> component = page.obterPorId(page, id);

			if (component.isPresent() && component.get() instanceof IEntradaCheckbox) {
				((IEntradaCheckbox) component.get()).setChecked(true);

			} else if (component.isPresent() && component.get() instanceof IEntrada) {
				((IEntrada) component.get()).setValor(req.getParameter(id));
			}
		}
	}

	private void aplicarValidacao(HttpServletRequest req, IPagina page) {

		Enumeration<String> names = req.getParameterNames();

		if (Optional.ofNullable(names).isPresent()) {
			while (names.hasMoreElements()) {
				String id = names.nextElement();
				obterComponenteValidacao(page, id);
			}

		}
	}

	private void obterComponenteValidacao(IPagina page, String id) {
		if (!id.equals(OP) && !id.equals(COMPONENTID) && page.obterPorId(page, id).isPresent()) {

			Optional<IComponente> component = page.obterPorId(page, id);

			if (component.isPresent() && component.get() instanceof IEntrada) {
				for (String msg : ((IEntrada) component.get()).validar()) {
					page.adicionaMensagem(msg);
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

	private void renderizarPagina(HttpServletResponse resp, IPagina page) {

		try {
			
			PrintWriter pw = new PrintWriter(resp.getOutputStream());
			pw.write(page.gerarSaida());
			pw.close();
		
		} catch (Exception e) {
			log.log(Level.WARNING, e.getMessage());
		}

	}

	private void renderizarPaginaInicial(HttpServletResponse resp, IProjeto project) {

		try {
		
			PrintWriter pw = new PrintWriter(resp.getOutputStream());
			IPagina paginaInicial = project.getPaginaInicial();
			paginaInicial.setTituloProjeto(project.getTitulo());

			pw.write(paginaInicial.gerarSaida());
			pw.close();

		} catch (Exception e) {
			log.log(Level.WARNING, e.getMessage());
		}
	}
}