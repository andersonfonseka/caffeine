package com.andersonfonseka.caffeine.component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.andersonfonseka.caffeine.engine.Engine;

import lombok.Getter;
import lombok.Setter;

public abstract class Component implements Serializable {

	private static final long serialVersionUID = 1L;

	static Integer internalId = 1;
	
	private @Getter String id;
	
	private @Setter @Getter String parent;
	
	private @Getter String template;
	
	private @Getter List<Component> components = new ArrayList<Component>();
	
	public Component() {
		this.id = this.getClass().getSimpleName() + internalId;
		internalId++;
	}

	public Component add(Component component) {
		this.components.add(component);
		component.setParent(this.getClass().getName());
		return this;
	}
	
	public Optional<Component> findById(Component component, String id) {
		
		Optional<Component> comp = component.getComponents().stream()
				.filter(x -> x.getId().equals(id))
				.findFirst();
		
		if (!comp.isPresent()) {
			
			for (Component component2 : component.getComponents()) {

				if (!comp.isPresent() && component2 instanceof GridLayout) {
					
					GridLayout gridLayout = (GridLayout) component2;
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

					comp = component.getComponents().stream()
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
		
		Engine engine = new Engine(this.getTemplate() + ".vm");
		engine.putOnContext(this.getTemplate(), this);
		return engine.execute();
		
	}
	
}
