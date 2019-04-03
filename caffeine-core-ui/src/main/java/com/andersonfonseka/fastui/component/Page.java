package com.andersonfonseka.fastui.component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public abstract @Data class Page extends Component implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5766132691862009035L;

	private String title;
	
	private List<String> messages = new ArrayList<String>();
	
	public Page() {
		internalId = 1;
	}
	
	@Override
	public String getTemplate() {
		return "page";
	}
	
	public void addMessages(String message) {
		if (message.length() > 0) {
			this.messages.add(message);	
		}
	}
	
	
	public abstract void onLoad(Map<String, String> parameters);
	
	
}
