package com.andersonfonseka.caffeine.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;

import lombok.Data;
import lombok.Getter;

@Model
public @Data class Conteiner extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer rows = 1;
	
	private List<Integer> rowsList = new ArrayList<Integer>();
	
	private Integer columns = 1;
	
	private @Getter Map<Integer, List<Componente>> rowCell = new HashMap<Integer, List<Componente>>();
	
	public Conteiner() {
		this(1);
	}
	
	public Conteiner(Integer rows) {
		super();
		this.rows = rows;
			for (int i = 0; i < this.rows; i++) {
				rowCell.put(i, new ArrayList<Componente>(columns));
				rowsList.add(i);
			}
	}

	public Conteiner add(Integer row, Componente component) {
		
		if (row < rows) {
			this.rowCell.get(row).add(component);
		} else {
			this.rowCell.get(rows-1).add(component);
		}
		
		return this;
	}
	
	public List<Componente> get(Integer row) {
		return this.rowCell.get(row);
	}
	
	@Override
	public String getTemplate() {
		return "gridlayout";
	}

}
