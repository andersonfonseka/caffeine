package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.andersonfonseka.caffeine.ITabela;
import com.andersonfonseka.caffeine.ITabelaColuna;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Tabela extends Componente implements ITabela {
	
	private transient Logger log = Logger.getLogger(Tabela.class.getName());

	private static final long serialVersionUID = 1L;
	
	private transient List<ITabelaColuna> colunas = new ArrayList<>();
	
	private transient List<?> dados = new ArrayList<>();
	
	public Tabela(String id) {
		setId(id);
	}

	public String getValor(Object object, String campo) {
		
		String resultado = "";
		try {

			Method method = object.getClass().getMethod(campo);
			resultado = String.valueOf(method.invoke(object));
		
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			log.log(Level.WARNING, e.getMessage());
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
		
}
