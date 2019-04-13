package com.andersonfonseka.caffeine.componentes.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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

	static Integer internalId = 1;
	
	private @Getter String id;
	
	private @Setter @Getter String parent;
	
	private @Getter List<IComponente> componentes = new ArrayList<IComponente>();
	
	private IComponenteFabrica componenteFabrica = new ComponenteFabricaImpl();
	
	Componente() {
		this.id = this.getClass().getSimpleName() + internalId;
		internalId++;
	}

	public Componente adicionar(IComponente component) {
		this.componentes.add(component);
		component.setParent(this.getClass().getName());
		return this;
	}
	
	public String gerarSaida() {
		
		Engenho engine = new Engenho(getTemplate() + ".vm");
		engine.putOnContext(this.getTemplate(), this);
		return engine.execute();
		
	}

	public abstract String getTemplate();
	
}
