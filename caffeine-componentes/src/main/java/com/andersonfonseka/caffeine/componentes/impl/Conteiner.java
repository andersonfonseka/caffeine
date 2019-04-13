package com.andersonfonseka.caffeine.componentes.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IConteiner;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Model
@EqualsAndHashCode(callSuper=false)
public @Data class Conteiner extends Componente implements IConteiner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer rows = 1;
	
	private List<Integer> rowsList = new ArrayList<Integer>();
	
	private Integer columns = 1;
	
	private @Getter Map<Integer, List<IComponente>> rowCell = new HashMap<Integer, List<IComponente>>();
	
	Conteiner() {
		this(1);
	}
	
	Conteiner(Integer rows) {
		super();
		this.rows = rows;
			for (int i = 0; i < this.rows; i++) {
				rowCell.put(i, new ArrayList<IComponente>(columns));
				rowsList.add(i);
			}
	}

	public Conteiner adicionar(Integer row, IComponente component) {
		
		if (row < rows) {
			this.rowCell.get(row).add(component);
		} else {
			this.rowCell.get(rows-1).add(component);
		}
		
		return this;
	}
	
	public List<IComponente> get(Integer row) {
		return this.rowCell.get(row);
	}
	
	@Override
	public String getTemplate() {
		return "conteiner";
	}

	@Override
	public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
		// TODO Auto-generated method stub
		
	}

}
