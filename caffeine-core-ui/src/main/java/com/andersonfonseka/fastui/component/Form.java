package com.andersonfonseka.fastui.component;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class Form extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;

	@Override
	public String getTemplate() {
		return "form";
	}

	
}
