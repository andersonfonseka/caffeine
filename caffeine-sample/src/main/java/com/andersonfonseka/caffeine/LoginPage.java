package com.andersonfonseka.caffeine;

import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.andersonfonseka.caffeine.component.Button;
import com.andersonfonseka.caffeine.component.Form;
import com.andersonfonseka.caffeine.component.GridLayout;
import com.andersonfonseka.caffeine.component.InputEmail;
import com.andersonfonseka.caffeine.component.InputPassword;
import com.andersonfonseka.caffeine.component.Page;
import com.andersonfonseka.caffeine.component.action.Action;
import com.andersonfonseka.caffeine.servlet.PageResponse;
import com.andersonfonseka.caffeine.util.MessageUtil;

@RequestScoped
public class LoginPage extends Page {
	
	private InputEmail txtEmail = new InputEmail();
	
	private InputPassword txtPassword = new InputPassword();

	private static final long serialVersionUID = 1L;

	public LoginPage() {

		setTitle("Login Form");
		
		final Form form = new Form();
		GridLayout gridLayout = new GridLayout(3);

		Button button = new Button();

		txtEmail.setTitle("Email");
		txtEmail.setRequired(true);

		txtPassword.setTitle("Password");
		txtPassword.setRequired(true);

		button.setTitle("Apply");

		button.setAction(new Action(form) {
			public PageResponse execute() {

				PageResponse pageResponse = new PageResponse();
				
				InputEmail inputText = (InputEmail) findById(form, txtEmail.getId()).get();
				InputPassword inputPassword = (InputPassword) findById(form, txtPassword.getId()).get();
				
				if (inputText.getValue().equals("anderson.fonseka@gmail.com") &&
						inputPassword.getValue().equals("123456")) {

					pageResponse.setPageUrl(CustomerPage.class.getName());

				} else {

					pageResponse.addMessage(MessageUtil.getInstance().getMessage("Invalid access input!"));
					pageResponse.setPageUrl(LoginPage.class.getName());
					
				}
				
				
				return pageResponse;
			}
		});

		gridLayout.
				add(0, txtEmail).
				add(1, txtPassword).
				add(2, button);

		form.
			add(gridLayout);

		add(form);
		
	}

	@Override
	public void onLoad(Map<String, String> parameters) {

		if (parameters == null)
			return;
	
		
		this.txtEmail.setValue(parameters.get("InputEmail1"));
		this.txtPassword.setValue(parameters.get("InputPassword2"));
		
	}

}
