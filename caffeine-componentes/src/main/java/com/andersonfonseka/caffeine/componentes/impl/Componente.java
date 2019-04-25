package com.andersonfonseka.caffeine.componentes.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.engine.Engenho;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public abstract @Data class Componente implements IComponente, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private BeanManager beanManager;

	public static Integer internalId = 1;
	
	private @Getter String id;
	
	private @Setter @Getter String parent;
	
	private @Getter List<IComponente> componentes = new ArrayList<IComponente>();
	
	private IComponenteFabrica componenteFabrica;
	
	public Componente() {
		this.id = this.getClass().getSimpleName() + internalId;
		internalId++;
	}

	public IComponente adicionar(IComponente component) {
		this.componentes.add(component);
		component.setParent(this.getClass().getName());
		return this;
	}
	
	public String gerarSaida() {
		
		String resultado = "";
		
		if (Optional.of(getTemplate()).isPresent()){
			Engenho engine = new Engenho(getTemplate() + ".vm");
			engine.putOnContext(this.getTemplate(), this);
			resultado = engine.execute();
		}

		return resultado;
		
	}

	public abstract String getTemplate();
	
	public abstract void aoCarregar(Map<String, String> parametros);
	
}
