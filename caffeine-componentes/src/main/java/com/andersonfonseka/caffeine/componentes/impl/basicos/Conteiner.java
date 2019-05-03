package com.andersonfonseka.caffeine.componentes.impl.basicos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andersonfonseka.caffeine.IComponente;
import com.andersonfonseka.caffeine.IConteiner;
import com.andersonfonseka.caffeine.componentes.ConteinerEnum;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper=false)
public @Data class Conteiner extends Componente implements IConteiner {

	private static final long serialVersionUID = 1L;

	private Integer rows = 1;
	
	private List<Integer> rowsList = new ArrayList<Integer>();
	
	private Integer columns = 1;
	
	private ConteinerEnum orientacao = ConteinerEnum.COLUNAS;
	
	private transient @Getter Map<Integer, List<IComponente>> rowCell = new HashMap<Integer, List<IComponente>>();
	
	public Conteiner() {
		this(1);
	}
	
	public Conteiner(Integer rows) {
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

		if (orientacao.equals(ConteinerEnum.HORIZONTAL)){
			return "conteinerTabular";
		}
		
		return "conteiner";	
	}

}
