package com.andersonfonseka.caffeine.componentes.impl.basicos;

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
	
	private transient AcaoAbs acao;
	
	private OpcaoSelecao selected;
	
	private boolean imediato = false;
	
	private Selecao() {
		adicionar(new OpcaoSelecao.Builder("", "Selecione...").build());
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
	
	public static class Builder {
		
		String titulo;
		
		boolean obrigatorio;
		
		AcaoAbs acao;
		
		boolean imediato;
		
		public Builder(String titulo, boolean obrigatorio) {
			super();
			this.titulo = titulo;
			this.obrigatorio = obrigatorio;
		}

		public Builder(String titulo, AcaoAbs acao, boolean imediato) {
			super();
			this.titulo = titulo;
			this.acao = acao;
			this.imediato = imediato;
		}
		
		public ISelecao build() {
			
			Selecao selecao = new Selecao();
			
			if (acao == null) {
				selecao.setTitulo(titulo);
				selecao.setObrigatorio(obrigatorio);
			} else {
				selecao.setTitulo(titulo);
				selecao.setObrigatorio(obrigatorio);
				selecao.setAcao(acao);
			}
			
			return selecao;
		}
	}
}
