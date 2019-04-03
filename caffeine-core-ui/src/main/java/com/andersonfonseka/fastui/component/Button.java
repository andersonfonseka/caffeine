package com.andersonfonseka.fastui.component;

import javax.enterprise.inject.Model;

import com.andersonfonseka.fastui.component.action.Action;
import com.andersonfonseka.fastui.servlet.PageResponse;

import lombok.Data;

@Model
public @Data class Button extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	private Component source;

	private Action action;
	
	private boolean immediate;
	
	@Override
	public String getTemplate() {
		return "button";
	}

	public PageResponse doClick() {
		return this.action.execute();
	}

}
