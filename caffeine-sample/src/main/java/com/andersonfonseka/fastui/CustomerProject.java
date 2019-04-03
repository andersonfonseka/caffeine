package com.andersonfonseka.fastui;

import javax.enterprise.context.SessionScoped;

import com.andersonfonseka.fastui.component.Project;

@SessionScoped
public class CustomerProject extends Project {
	
	private static final long serialVersionUID = 1L;

	public CustomerProject() {
		setTitle("FastUI Hello World!");
		setInitialPage(LoginPage.class);
	}
}
