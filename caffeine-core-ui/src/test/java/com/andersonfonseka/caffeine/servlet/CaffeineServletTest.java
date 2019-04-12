package com.andersonfonseka.caffeine.servlet;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.andersonfonseka.caffeine.componentes.impl.ComponenteFabricaImpl;
import com.andersonfonseka.caffeine.servlet.mock.AcessoPagina;
import com.andersonfonseka.caffeine.servlet.mock.ClienteProjeto;
import com.andersonfonseka.caffeine.servlet.mock.MockHttpServletRequest;
import com.andersonfonseka.caffeine.servlet.mock.MockHttpServletResponse;


@EnableWeld
class CaffeineServletTest extends Mockito {
	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(WeldInitiator.createWeld()
														.beanClasses(CaffeineServlet.class, 
																ComponenteFabricaImpl.class,
																ClienteProjeto.class,
																AcessoPagina.class));
	
	@Test
	void test(CaffeineServlet caffeineServlet) throws ServletException, IOException {
		
		CaffeineServlet cs = caffeineServlet;
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		cs.doPost(request, new MockHttpServletResponse());
		
		assertTrue(Optional.of(caffeineServlet).isPresent());
	}
	
	@Test
	void testDoPost(CaffeineServlet caffeineServlet) throws ServletException, IOException {
		
		CaffeineServlet cs = caffeineServlet;
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.setAttribute("op", "Botao13");
		request.setAttribute("componentId", AcessoPagina.class.getName());
		
		cs.doPost(request, new MockHttpServletResponse());
		
		assertTrue(Optional.of(caffeineServlet).isPresent());
	}
	
	@Test
	void testDoGet(CaffeineServlet caffeineServlet) throws ServletException, IOException {
		
		CaffeineServlet cs = caffeineServlet;
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.setAttribute("op", "Botao13");
		request.setAttribute("componentId", AcessoPagina.class.getName());
		
		cs.doGet(request, new MockHttpServletResponse());
		
		assertTrue(Optional.of(caffeineServlet).isPresent());
	}


}
