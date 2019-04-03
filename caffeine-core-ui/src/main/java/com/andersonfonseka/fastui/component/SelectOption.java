package com.andersonfonseka.fastui.component;

import lombok.Data;

public @Data class SelectOption extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853745218310142769L;

	private String value;
	
	private String label;
	
	private boolean selected;

	public SelectOption(String value, String label) {
		super();
		this.value = value;
		this.label = label;
	}
	
	
	
}
