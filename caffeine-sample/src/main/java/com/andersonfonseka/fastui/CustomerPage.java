package com.andersonfonseka.fastui;

import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.andersonfonseka.fastui.component.Button;
import com.andersonfonseka.fastui.component.Form;
import com.andersonfonseka.fastui.component.GridLayout;
import com.andersonfonseka.fastui.component.InputDate;
import com.andersonfonseka.fastui.component.InputEmail;
import com.andersonfonseka.fastui.component.InputFile;
import com.andersonfonseka.fastui.component.InputText;
import com.andersonfonseka.fastui.component.InputTextArea;
import com.andersonfonseka.fastui.component.Page;
import com.andersonfonseka.fastui.component.Select;
import com.andersonfonseka.fastui.component.SelectOption;
import com.andersonfonseka.fastui.component.action.Action;
import com.andersonfonseka.fastui.servlet.PageResponse;

@RequestScoped
public class CustomerPage extends Page {
	
	private static final long serialVersionUID = 1L;

	private InputEmail txtEmail = new InputEmail();
	
	public CustomerPage() {
		setTitle("Customer Form");
		
		Form form = new Form(); 
		InputText txtFirstName = new InputText();
		InputText txtLastName  = new InputText();
		
		InputDate txtDoB = new InputDate();
		Select selGender = new Select();
		InputTextArea txtDescription = new InputTextArea();
		InputFile txtFile = new InputFile();
		
		Button btnApply = new Button();
		Button btnCancel = new Button();
		
		final GridLayout gridLayout = new GridLayout(6);
		
		txtFirstName.setTitle("First Name");
		txtFirstName.setRequired(true);

		txtLastName.setTitle("Last Name");
		txtLastName.setRequired(true);
		
		txtEmail.setTitle("E-mail");
		txtEmail.setRequired(true);

		txtDoB.setTitle("Date of birth");
		txtDoB.setPattern("yyyy-MM-dd");
		
		selGender.setRequired(true);
		selGender.setTitle("Gender");
		selGender.add(new SelectOption("1", "Male"));
		selGender.add(new SelectOption("2", "Female"));
		
		txtDescription.setRequired(true);
		txtDescription.setTitle("Description");
		txtDescription.setRows(5);
		
		txtFile.setRequired(true);
		txtFile.setTitle("CV/Resume");
		
		btnApply.setTitle("Apply");
		
		btnApply.setAction(new Action(form) {
			public PageResponse execute() {
				
				PageResponse pageResponse = new PageResponse();
				pageResponse.setPageUrl(CustomerPage.class.getName());
				
				return pageResponse;
			}
		});
		
		btnCancel.setTitle("Cancel");
		btnCancel.setImmediate(true);
		
		btnCancel.setAction(new Action(form) {
			public PageResponse execute() {
				
				PageResponse pageResponse = new PageResponse();
				pageResponse.setPageUrl(LoginPage.class.getName());
				
				return pageResponse;
			}
		});
		
		add(form);
		form.add(gridLayout);
		
		gridLayout.add(0, txtFirstName)
					.add(1, txtLastName)
					.add(2, txtEmail)
					.add(2, txtDoB)
					.add(3, selGender)
					.add(4, txtDescription)
					.add(5, btnApply)
				    .add(5, btnCancel);
	}
	

	@Override
	public void onLoad(Map<String, String> parameters) {

		if(parameters == null)
			return;
		
		this.txtEmail.setValue(parameters.get("InputEmail1"));
	}
	
}
