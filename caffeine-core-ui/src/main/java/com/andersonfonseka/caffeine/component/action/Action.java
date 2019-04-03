package com.andersonfonseka.caffeine.component.action;

import com.andersonfonseka.caffeine.servlet.PageResponse;

import lombok.Getter;

public abstract class Action {
	
	private @Getter Object source;
	
	public Action(Object source) {
		super();
		this.source = source;
	}
	
	public abstract PageResponse execute();

}
