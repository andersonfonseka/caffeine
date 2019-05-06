package com.andersonfonseka.caffeine.componentes.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.impl.ComponenteFabricaImpl;
import com.andersonfonseka.caffeine.componentes.impl.mock.AcessoPagina;

@EnableWeld
class ParametroUtilTest {
	
	@WeldSetup
	public static WeldInitiator weld = WeldInitiator.of(WeldInitiator.createWeld()
														.beanClasses(AcessoPagina.class, ComponenteFabricaImpl.class));

	@Test
	void testAtribuirParametros(IComponenteFabrica componenteFabrica) {
		
		AcessoPagina pagina = (AcessoPagina) componenteFabrica.criarPagina(AcessoPagina.class.getName());
		pagina.post();
		
		Map<String, Object> map = new HashMap();
		map.put(pagina.getEntradaTexto().getId(), "Teste");
		
		ParametroUtil parametroUtil = new ParametroUtil();
		parametroUtil.atribuirParametros(pagina, map);

		assertTrue(Optional.of(pagina.getEntradaTexto().getValor()).isPresent());
		
	}

}
