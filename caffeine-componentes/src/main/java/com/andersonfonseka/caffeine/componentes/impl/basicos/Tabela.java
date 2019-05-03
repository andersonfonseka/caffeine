package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.andersonfonseka.caffeine.ITabela;
import com.andersonfonseka.caffeine.ITabelaColuna;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Tabela extends Componente implements ITabela {

	private static final long serialVersionUID = 1L;
	
	private List<ITabelaColuna> colunas = new ArrayList<ITabelaColuna>();
	
	private List<?> dados = new ArrayList();
	
	public Tabela(String id) {
		setId(id);
	}

	public String getValor(Object object, String campo) {
		
		String resultado = "";
		try {

			Method method = object.getClass().getMethod(campo, null);
			resultado = String.valueOf(method.invoke(object, null));
		
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	@Override
	public String getTemplate() {
		return "table";
	}
	
	public ITabela adicionaColuna(ITabelaColuna tabelaColuna) {
		this.colunas.add(tabelaColuna);
		return this;
	}
	

	@Override
	public void aoCarregar(Map<String, Object> parametros) {}

}
