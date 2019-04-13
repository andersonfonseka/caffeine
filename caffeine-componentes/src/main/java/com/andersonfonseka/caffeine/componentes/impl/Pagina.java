package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IPagina;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public abstract @Data class Pagina extends Componente implements IPagina {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private List<String> mensagens = new ArrayList<String>();
	
	protected Pagina() {
		internalId = 1;
	}

	@Override
	public String getTemplate() {
		return "page";
	}

	public void adicionaMensagem(String message) {
		if (message.length() > 0) {
			this.mensagens.add(message);
		}
	}

	public Optional<IComponente> obterPorId(IComponente component, String id) {

		Optional<IComponente> comp = component.getComponentes().stream().filter(x -> x.getId().equals(id)).findFirst();

		if (!comp.isPresent()) {

			for (IComponente component2 : component.getComponentes()) {

				if (component2 instanceof Conteiner) {

					comp = obterComponenteDoConteiner(id, comp, component2);
					
					if (comp.isPresent()) {
						break;
					}

				} else if (!comp.isPresent()) {

					comp = component.getComponentes().stream().filter(x -> x.getId().equals(id)).findFirst();

					if (!comp.isPresent()) {
						comp = obterPorId(component2, id);
					}
				}
			}
		}

		return comp;
	}

	private Optional<IComponente> obterComponenteDoConteiner(String id, Optional<IComponente> comp,
			IComponente component2) {

		Conteiner gridLayout = (Conteiner) component2;
		Iterator<Integer> it = gridLayout.getRowCell().keySet().iterator();

		while (it.hasNext()) {
			Integer key = it.next();

			comp = gridLayout.get(key).stream().filter(x -> x.getId().equals(id)).findFirst();

			if (comp.isPresent()) {
				break;
			}
		}
		return comp;
	}

	public abstract void post();

	public abstract void aoCarregar(Map<String, String> parametros);

}
