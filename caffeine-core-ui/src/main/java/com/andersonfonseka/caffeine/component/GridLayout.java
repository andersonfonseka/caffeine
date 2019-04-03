package com.andersonfonseka.caffeine.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;

import lombok.Data;
import lombok.Getter;

@Model
public @Data class GridLayout extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer rows = 1;
	
	private List<Integer> rowsList = new ArrayList<Integer>();
	
	private Integer columns = 1;
	
	private @Getter Map<Integer, List<Component>> rowCell = new HashMap<Integer, List<Component>>();
	
	public GridLayout() {
		this(1);
	}
	
	public GridLayout(Integer rows) {
		super();
		this.rows = rows;
			for (int i = 0; i < this.rows; i++) {
				rowCell.put(i, new ArrayList<Component>(columns));
				rowsList.add(i);
			}
	}

	public GridLayout add(Integer row, Component component) {
		
		if (row < rows) {
			this.rowCell.get(row).add(component);
		} else {
			this.rowCell.get(rows-1).add(component);
		}
		
		return this;
	}
	
	public List<Component> get(Integer row) {
		return this.rowCell.get(row);
	}
	
	@Override
	public String getTemplate() {
		return "gridlayout";
	}

}
