package com.andersonfonseka.caffeine.componentes.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.engine.Engenho;

import lombok.Getter;
import lombok.Setter;

public abstract class Componente implements IComponente, Serializable {

	private static final long serialVersionUID = 1L;

	static Integer internalId = 1;
	
	private @Getter String id;
	
	private @Setter @Getter String parent;
	
	private @Getter String template;
	
	private @Getter List<IComponente> componentes = new ArrayList<IComponente>();
	
	public Componente() {
		this.id = this.getClass().getSimpleName() + internalId;
		internalId++;
	}

	public Componente add(Componente component) {
		this.componentes.add(component);
		component.setParent(this.getClass().getName());
		return this;
	}
	
	public Optional<IComponente> findById(IComponente component, String id) {
		
		Optional<IComponente> comp = component.getComponentes().stream()
				.filter(x -> x.getId().equals(id))
				.findFirst();
		
		if (!comp.isPresent()) {
			
			for (IComponente component2 : component.getComponentes()) {

				if (!comp.isPresent() && component2 instanceof Conteiner) {
					
					Conteiner gridLayout = (Conteiner) component2;
					Iterator<Integer>  it = gridLayout.getRowCell().keySet().iterator();
					
					while(it.hasNext()) {
						Integer key = it.next();
						
						comp = gridLayout.get(key).stream()
								.filter(x -> x.getId().equals(id))
								.findFirst();
						
						if (comp.isPresent()) {
							break;
						}
					}
				
				} else if (!comp.isPresent()) {

					comp = component.getComponentes().stream()
							.filter(x -> x.getId().equals(id))
							.findFirst();
					
					if (!comp.isPresent()) {
						comp = findById(component2, id);
					}
				}
			}
		}
		
		return comp;
	}
	
	public String doRender() {
		
		Engenho engine = new Engenho(this.getTemplate() + ".vm");
		engine.putOnContext(this.getTemplate(), this);
		return engine.execute();
		
	}
	
}
