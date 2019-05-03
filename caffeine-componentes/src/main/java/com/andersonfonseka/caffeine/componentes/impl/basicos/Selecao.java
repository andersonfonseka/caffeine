package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.Map;

import com.andersonfonseka.caffeine.IComponente;
import com.andersonfonseka.caffeine.IOpcaoSelecao;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.ISelecao;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Selecao extends Entrada implements ISelecao {

	private static final long serialVersionUID = 6966867488997712703L;
	
	private AcaoAbs acao;
	
	private OpcaoSelecao selected;
	
	private boolean imediato = false;
	
	public Selecao() {
		adicionar(new OpcaoSelecao("", "Selecione..."));
	}
	
	private OpcaoSelecao getSelected() {
		
		for(IComponente component: getComponentes()) {
			OpcaoSelecao selectOption = (OpcaoSelecao) component;
			if (selectOption.getValor().equals(getValor())) {
				selectOption.setSelecionado(true);
				this.selected = selectOption;
				break;
			}
		} 
		
		return this.selected;
	}
	
	@Override
	public String getTemplate() {
		return "select";
	}

	@Override
	public void setValor(String value) {
		super.setValor(value);
		getSelected();
	}

	public IOpcaoSelecao getSelecionado() {
		return this.selected;
	}
	
	public IResposta doClick() {
		return this.acao.execute();
	}
	
	@Override
	public void aoCarregar(Map<String, Object> parametros) {}
	
}
