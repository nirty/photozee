package com.cis550.photozee.client;

import java.util.List;

import com.cis550.photozee.client.model.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class Login extends Composite {
	
	private VerticalPanel login = new VerticalPanel();
	static private Login _instance = null;

	private final LoginServiceAsync LoginService = GWT.create(LoginService.class);
	
	public Login(){
		initPage();
		initWidget(login);
		
	}

	public static Login getInstance(){
        if(null == _instance) {
        	_instance = new Login();
        }
        return _instance;
	}

	private void initPage() {

		FlexTable flexTable = new FlexTable();
		login.add(flexTable);
		flexTable.setSize("650px", "358px");
		
		Label lblPleaseSignIn = new Label("Please Sign in here");
		flexTable.setWidget(0, 0, lblPleaseSignIn);
		
		Label lblEMail = new Label("E- Mail ");
		flexTable.setWidget(1, 0, lblEMail);
		lblEMail.setWidth("101px");
		
		final TextBox emailTextBox = new TextBox();
		emailTextBox.setVisibleLength(30);
		emailTextBox.setAlignment(TextAlignment.LEFT);
		flexTable.setWidget(1, 1, emailTextBox);
		emailTextBox.setSize("450px", "35px");
		flexTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		flexTable.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		
		Label lblPassword = new Label("Password");
		flexTable.setWidget(2, 0, lblPassword);
		lblPassword.setWidth("140px");
		flexTable.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		final PasswordTextBox passwordTextBox = new PasswordTextBox();
		flexTable.setWidget(2, 1, passwordTextBox);
		passwordTextBox.setSize("450px", "35px");
		
		final Label errLabel = new Label("The username or password you entered is incorrect.");
		errLabel.setStyleName("gwt-err");
		flexTable.setWidget(3, 0, errLabel);
		errLabel.setVisible(false);
		
		Button btnLogin = new Button("Login");
		flexTable.setWidget(4, 0, btnLogin);
		btnLogin.setSize("200px", "40px");
		flexTable.getFlexCellFormatter().setColSpan(4, 0, 2);
		flexTable.getCellFormatter().setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_CENTER);
		btnLogin.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				LoginService.login(passwordTextBox.getText(), emailTextBox.getText(), new AsyncCallback<String>() {
					public void onFailure(Throwable error) {
						System.out.println("Fail");
						try {
							throw error;
						} catch (Throwable e) {
							e.printStackTrace();
						}
					}
					public void onSuccess(String result) {
						// invalid password but valid email address
						if (!result.startsWith("33")) {
							errLabel.setVisible(true);
							System.out.println("The username or password you entered is incorrect.");
						} else {
							Cookies.setCookie("userID", result);
							History.newItem("homepage", true);
						}
					}
				});
			}
		});
		
		Label lblOr = new Label("or");
		flexTable.setWidget(5, 0, lblOr);
		flexTable.getFlexCellFormatter().setColSpan(5, 0, 2);
		flexTable.getCellFormatter().setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		Button btnRegister = new Button("New button");
		btnRegister.setText("Register");
		flexTable.setWidget(6, 0, btnRegister);
		btnRegister.setSize("200px", "40px");
		flexTable.getCellFormatter().setHorizontalAlignment(6, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getFlexCellFormatter().setColSpan(6, 0, 2);
		flexTable.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getFlexCellFormatter().setColSpan(3, 0, 2);
		login.setBorderWidth(2);
		login.setSize("653px", "362px");
		btnRegister.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				History.newItem("register", true); 
			}
		});
	}

}
