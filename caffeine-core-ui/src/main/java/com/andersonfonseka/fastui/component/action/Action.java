package com.andersonfonseka.fastui.component.action;

import com.andersonfonseka.fastui.servlet.PageResponse;

import lombok.Getter;

public abstract class Action {
	
	private @Getter Object source;
	
	public Action(Object source) {
		super();
		this.source = source;
	}
	
	public abstract PageResponse execute();

}
