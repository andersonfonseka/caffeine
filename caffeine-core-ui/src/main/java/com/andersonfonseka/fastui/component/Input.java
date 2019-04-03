package com.andersonfonseka.fastui.component;

import com.andersonfonseka.fastui.component.validator.Validator;
import com.andersonfonseka.fastui.util.MessageUtil;

import lombok.Data;

public abstract @Data class Input extends Component implements Validator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String title;
	
	private String value = "";
	
	private boolean required;

	@Override
	public String validate() {
		
		if (required && value.trim().length() == 0) {
			return MessageUtil.getInstance().getMessage("REQUIREDFIELD", getTitle());
		}
		return "";
	}

}
