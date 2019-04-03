package com.andersonfonseka.fastui.component;

import javax.enterprise.inject.Model;

import lombok.Data;

@Model
public @Data class Select extends Input {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6966867488997712703L;

	private Integer size;
	
	private Integer maxLength;
	
	private SelectOption selected;
	
	public Select() {
		add(new SelectOption("", "Choose one..."));
	}
	
	private SelectOption getSelected() {
		
		for(Component component: getComponents()) {
			SelectOption selectOption = (SelectOption) component;
			if (selectOption.getValue().equals(getValue())) {
				selectOption.setSelected(true);
				this.selected = selectOption;
				break;
			}
		} 
		
		return this.selected;
	}
	
	@Override
	public String getTemplate() {
		return "select";
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		super.setValue(value);
		getSelected();
	}

	
	
}
