package com.cis550.photozee.client;

import java.util.List;

import com.cis550.photozee.shared.FieldVerifier;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.text.client.IntegerRenderer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Hidden;

public class Register extends Composite {
	static private Register _instance = null;
	private final RegisterServiceAsync RegisterService = GWT.create(RegisterService.class);
	
	public Register(){
		initPage();
	}

	public static Register getInstance(){
        if(null == _instance) {
        	_instance = new Register();
        }
        return _instance;
	}

	private void initPage() {
		final AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("1200px", "900px");
		
		Label lblTitle = new Label("Register for Photozee");
		lblTitle.setStyleName("gwt-PageTitle");
		absolutePanel.add(lblTitle, 258, 20);
		lblTitle.setSize("387px", "42px");
		
		Label lblFirstName = new Label("First Name");
		absolutePanel.add(lblFirstName, 258, 79);
		lblFirstName.setSize("77px", "18px");
		
		final TextBox firstNameBox = new TextBox();
		absolutePanel.add(firstNameBox, 402, 79);
		firstNameBox.setSize("233px", "18px");
		
		Label lblLastName = new Label("Last Name");
		absolutePanel.add(lblLastName, 258, 131);
		lblLastName.setSize("77px", "18px");
		
		final TextBox lastNameBox = new TextBox();
		absolutePanel.add(lastNameBox, 402, 131);
		lastNameBox.setSize("233px", "18px");
		
		Label lblAddress = new Label("Address");
		absolutePanel.add(lblAddress, 258, 184);
		lblAddress.setSize("77px", "18px");
		
		final TextBox addressBox = new TextBox();
		absolutePanel.add(addressBox, 402, 184);
		addressBox.setSize("233px", "18px");
		
		Label lblDateOfBirth = new Label("Date of Birth");
		absolutePanel.add(lblDateOfBirth, 258, 236);
		lblDateOfBirth.setSize("77px", "18px");
		
		final ListBox monthComboBox = new ListBox();
		monthComboBox.addItem("January");
		monthComboBox.addItem("February");
		monthComboBox.addItem("March");
		monthComboBox.addItem("April");
		monthComboBox.addItem("May");
		monthComboBox.addItem("June");
		monthComboBox.addItem("July");
		monthComboBox.addItem("August");
		monthComboBox.addItem("September");
		monthComboBox.addItem("October");
		monthComboBox.addItem("November");
		monthComboBox.addItem("December");
		absolutePanel.add(monthComboBox, 402, 236);
		monthComboBox.setSize("108px", "22px");
		
		final ListBox dayComboBox = new ListBox();
		dayComboBox.addItem("1");
		dayComboBox.addItem("2");
		dayComboBox.addItem("3");
		dayComboBox.addItem("4");
		dayComboBox.addItem("5");
		dayComboBox.addItem("6");
		dayComboBox.addItem("7");
		dayComboBox.addItem("8");
		dayComboBox.addItem("9");
		dayComboBox.addItem("10");
		dayComboBox.addItem("11");
		dayComboBox.addItem("12");
		dayComboBox.addItem("13");
		dayComboBox.addItem("14");
		dayComboBox.addItem("15");
		dayComboBox.addItem("16");
		dayComboBox.addItem("17");
		dayComboBox.addItem("18");
		dayComboBox.addItem("19");
		dayComboBox.addItem("20");
		dayComboBox.addItem("21");
		dayComboBox.addItem("22");
		dayComboBox.addItem("23");
		dayComboBox.addItem("24");
		dayComboBox.addItem("25");
		dayComboBox.addItem("26");
		dayComboBox.addItem("27");
		dayComboBox.addItem("28");
		dayComboBox.addItem("29");
		dayComboBox.addItem("30");
		dayComboBox.addItem("31");
		absolutePanel.add(dayComboBox, 520, 234);
		
		final ListBox yearComboBox = new ListBox();
		yearComboBox.addItem("1931");
		yearComboBox.addItem("1932");
		yearComboBox.addItem("1933");
		yearComboBox.addItem("1934");
		yearComboBox.addItem("1935");
		yearComboBox.addItem("1936");
		yearComboBox.addItem("1937");
		yearComboBox.addItem("1938");
		yearComboBox.addItem("1939");
		yearComboBox.addItem("1940");
		yearComboBox.addItem("1941");
		yearComboBox.addItem("1942");
		yearComboBox.addItem("1943");
		yearComboBox.addItem("1944");
		yearComboBox.addItem("1945");
		yearComboBox.addItem("1946");
		yearComboBox.addItem("1947");
		yearComboBox.addItem("1948");
		yearComboBox.addItem("1949");
		yearComboBox.addItem("1950");
		yearComboBox.addItem("1951");
		yearComboBox.addItem("1952");
		yearComboBox.addItem("1953");
		yearComboBox.addItem("1954");
		yearComboBox.addItem("1955");
		yearComboBox.addItem("1956");
		yearComboBox.addItem("1957");
		yearComboBox.addItem("1958");
		yearComboBox.addItem("1959");
		yearComboBox.addItem("1960");
		yearComboBox.addItem("1961");
		yearComboBox.addItem("1962");
		yearComboBox.addItem("1963");
		yearComboBox.addItem("1964");
		yearComboBox.addItem("1965");
		yearComboBox.addItem("1966");
		yearComboBox.addItem("1967");
		yearComboBox.addItem("1968");
		yearComboBox.addItem("1969");
		yearComboBox.addItem("1970");
		yearComboBox.addItem("1971");
		yearComboBox.addItem("1972");
		yearComboBox.addItem("1973");
		yearComboBox.addItem("1974");
		yearComboBox.addItem("1975");
		yearComboBox.addItem("1976");
		yearComboBox.addItem("1977");
		yearComboBox.addItem("1978");
		yearComboBox.addItem("1979");
		yearComboBox.addItem("1980");
		yearComboBox.addItem("1981");
		yearComboBox.addItem("1982");
		yearComboBox.addItem("1983");
		yearComboBox.addItem("1984");
		yearComboBox.addItem("1985");
		yearComboBox.addItem("1986");
		yearComboBox.addItem("1987");
		yearComboBox.addItem("1988");
		yearComboBox.addItem("1989");
		yearComboBox.addItem("1990");
		yearComboBox.addItem("1991");
		yearComboBox.addItem("1992");
		yearComboBox.addItem("1993");
		yearComboBox.addItem("1994");
		yearComboBox.addItem("1995");
		yearComboBox.addItem("1996");
		yearComboBox.addItem("1997");
		yearComboBox.addItem("1998");
		yearComboBox.addItem("1999");
		yearComboBox.addItem("2000");
		yearComboBox.addItem("2001");
		absolutePanel.add(yearComboBox, 582, 234);
		
		Label lblGender = new Label("Gender");
		absolutePanel.add(lblGender, 258, 290);
		lblGender.setSize("77px", "18px");
		
		final ListBox genderComboBox = new ListBox();
		genderComboBox.addItem("Male");
		genderComboBox.addItem("Female");
		absolutePanel.add(genderComboBox, 401, 286);
		
		Label lblInst = new Label("Institutions Attended");
		absolutePanel.add(lblInst, 258, 339);
		
		final TextBox instBox = new TextBox();
		absolutePanel.add(instBox, 402, 339);
		instBox.setSize("233px", "18px");
		
		Label lblInstDesc = new Label("Please separate multiple entries with commas.");
		absolutePanel.add(lblInstDesc, 661, 339);
		
		Label lblEmailAddress = new Label("Email Address");
		absolutePanel.add(lblEmailAddress, 258, 387);
		lblEmailAddress.setSize("97px", "18px");
		
		final TextBox emailBox = new TextBox();
		absolutePanel.add(emailBox, 402, 387);
		emailBox.setSize("233px", "18px");
		
		Label lblPassword = new Label("Password");
		absolutePanel.add(lblPassword, 258, 439);
		lblPassword.setSize("97px", "18px");
		
		final PasswordTextBox passwordBox = new PasswordTextBox();
		absolutePanel.add(passwordBox, 402, 439);
		passwordBox.setSize("233px", "16px");
		
		Label lblAccountType = new Label("Account Type");
		absolutePanel.add(lblAccountType, 258, 500);
		lblAccountType.setSize("97px", "18px");
		
		final Button btnClear = new Button("Clear");
		btnClear.setText("Clear");
		absolutePanel.add(btnClear, 258, 589);
		
		final Button btnSubmit = new Button("Submit");
		absolutePanel.add(btnSubmit, 332, 589);
		
		final Button btnBackToHome = new Button("Back to Home");
		absolutePanel.add(btnBackToHome, 258, 651);
		
		// Student fields
		final RadioButton rdbtnStudent = new RadioButton("new name", "Student");
		final Label lblAdvisor = new Label("Advisor");
		final ListBox advisorComboBox = new ListBox();
		final Label lblJoinGradYear = new Label("Entrance & Graduation Year");
		final ListBox joinYearBox = new ListBox();
		final ListBox gradYearBox = new ListBox();
		final Label lblMajorGPA = new Label("Major & GPA");
		final TextBox majorBox = new TextBox();
		final TextBox gpaBox = new TextBox();
		
		// Professor fields
		final Label lblDepartment = new Label("Department");
		final TextBox departmentBox = new TextBox();
		final Label lblResearch = new Label("Research Area");
		final TextBox researchBox = new TextBox();
		rdbtnStudent.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (departmentBox.isAttached()) {
					lblDepartment.removeFromParent();
					departmentBox.removeFromParent();
					lblResearch.removeFromParent();
					researchBox.removeFromParent();
				}
				
				// Move buttons down to accommodate new fields
				absolutePanel.setWidgetPosition(btnClear, 258, 778);
				absolutePanel.setWidgetPosition(btnSubmit, 332, 778);
				absolutePanel.setWidgetPosition(btnBackToHome, 258, 840);
				
				// Add new fields to the panel
				absolutePanel.add(lblJoinGradYear, 258, 589);
				lblJoinGradYear.setSize("97px", "18px");
				absolutePanel.add(joinYearBox, 402, 589);
				joinYearBox.addItem("2000");
				joinYearBox.addItem("2001");
				joinYearBox.addItem("2002");
				joinYearBox.addItem("2003");
				joinYearBox.addItem("2004");
				joinYearBox.addItem("2005");
				joinYearBox.addItem("2006");
				joinYearBox.addItem("2007");
				joinYearBox.addItem("2008");
				joinYearBox.addItem("2009");
				joinYearBox.addItem("2010");
				joinYearBox.addItem("2011");
				absolutePanel.add(gradYearBox, 469, 589);
				gradYearBox.addItem("2012");
				gradYearBox.addItem("2013");
				gradYearBox.addItem("2014");
				gradYearBox.addItem("2015");
				gradYearBox.addItem("2016");
				gradYearBox.addItem("2017");
				gradYearBox.addItem("2018");
				gradYearBox.addItem("2019");
				gradYearBox.addItem("2020");
				gradYearBox.addItem("2021");
				gradYearBox.addItem("2022");
				gradYearBox.addItem("2023");
				
				absolutePanel.add(lblMajorGPA, 258, 642);
				lblMajorGPA.setSize("97px", "18px");
				absolutePanel.add(majorBox, 400, 642);
				majorBox.setSize("173px", "18px");
				absolutePanel.add(gpaBox, 586, 642);
				gpaBox.setSize("49px", "18px");
				
				RegisterService.getAllProfs(new AsyncCallback<List<String>>() {
					public void onFailure(Throwable error) {
						
					}
					public void onSuccess(List<String> profs) {
						// Create new label and drop-down to select advisor
						absolutePanel.add(lblAdvisor, 258, 705);
						lblAdvisor.setSize("97px", "18px");
						
						// Fill the drop-down with all of the advisors in the database
						for (int i = 0; i < profs.size(); i++) {
							advisorComboBox.addItem(profs.get(i));
						}
						absolutePanel.add(advisorComboBox, 402, 705);
					}
				});
			}
		});
		absolutePanel.add(rdbtnStudent, 402, 500);
		
		final RadioButton rdbtnProfessor = new RadioButton("new name", "Professor");
		rdbtnProfessor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// If student has already been clicked, first remove those options
				if (advisorComboBox.isAttached()) {
					advisorComboBox.removeFromParent();
					lblAdvisor.removeFromParent();
					lblJoinGradYear.removeFromParent();
					joinYearBox.removeFromParent();
					gradYearBox.removeFromParent();
					lblMajorGPA.removeFromParent();
					majorBox.removeFromParent();
					gpaBox.removeFromParent();
				}
				// Move buttons to accommodate new fields
				absolutePanel.setWidgetPosition(btnClear, 258, 705);
				absolutePanel.setWidgetPosition(btnSubmit, 332, 705);
				absolutePanel.setWidgetPosition(btnBackToHome, 258, 770);
				
				// Add new fields
				absolutePanel.add(lblDepartment, 258, 589);
				lblDepartment.setSize("97px", "18px");
				absolutePanel.add(departmentBox, 402, 589);
				departmentBox.setSize("233px", "18px");
				
				absolutePanel.add(lblResearch, 258, 642);
				lblResearch.setSize("97px", "18px");
				absolutePanel.add(researchBox, 400, 642);
				researchBox.setSize("233px", "18px");
			}
		});
		absolutePanel.add(rdbtnProfessor, 402, 525);
		
		final RadioButton rdbtnOther = new RadioButton("new name", "Other");
		rdbtnOther.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (advisorComboBox.isAttached()) {
					advisorComboBox.removeFromParent();
					lblAdvisor.removeFromParent();
					lblJoinGradYear.removeFromParent();
					joinYearBox.removeFromParent();
					gradYearBox.removeFromParent();
					lblMajorGPA.removeFromParent();
					gpaBox.removeFromParent();
					majorBox.removeFromParent();
					absolutePanel.setWidgetPosition(btnClear, 258, 609);
					absolutePanel.setWidgetPosition(btnSubmit, 332, 609);
					absolutePanel.setWidgetPosition(btnBackToHome, 258, 671);
				}
				if (departmentBox.isAttached()) {
					lblDepartment.removeFromParent();
					departmentBox.removeFromParent();
					lblResearch.removeFromParent();
					researchBox.removeFromParent();
					absolutePanel.setWidgetPosition(btnClear, 258, 609);
					absolutePanel.setWidgetPosition(btnSubmit, 332, 609);
					absolutePanel.setWidgetPosition(btnBackToHome, 258, 671);
				}
			}
		});
		absolutePanel.add(rdbtnOther, 402, 550);
		
		// Create error labels and set visibility to false
		final Label errDupEmailLabel = new Label();
		errDupEmailLabel.setStyleName("gwt-err");
		absolutePanel.add(errDupEmailLabel, 661, 387);
		errDupEmailLabel.setSize("387px", "30px");
		errDupEmailLabel.setVisible(false);
		
		final Label errEmailLabel = new Label();
		errEmailLabel.setStyleName("gwt-err");
		absolutePanel.add(errEmailLabel, 661, 387);
		errEmailLabel.setSize("387px", "30px");
		errEmailLabel.setVisible(false);
		
		final Label errPWLabel = new Label();
		errPWLabel.setStyleName("gwt-err");
		absolutePanel.add(errPWLabel, 661, 439);
		errPWLabel.setSize("387px", "30px");
		errPWLabel.setVisible(false);

		final Label errFNameLabel = new Label();
		errFNameLabel.setStyleName("gwt-err");
		absolutePanel.add(errFNameLabel, 661, 79);
		errFNameLabel.setSize("387px", "30px");
		errFNameLabel.setVisible(false);
		
		final Label errLNameLabel = new Label();
		errLNameLabel.setStyleName("gwt-err");
		absolutePanel.add(errLNameLabel, 661, 131);
		errLNameLabel.setSize("387px", "30px");
		errLNameLabel.setVisible(false);
		
		final Label errTypeLabel = new Label();
		errTypeLabel.setStyleName("gwt-err");
		absolutePanel.add(errTypeLabel, 661, 503);
		errTypeLabel.setSize("387px", "30px");
		errTypeLabel.setVisible(false);
		
		final Label errGPALabel = new Label();
		errGPALabel.setStyleName("gwt-err");
		absolutePanel.add(errGPALabel, 661, 644);
		errTypeLabel.setSize("387px", "30px");
		errTypeLabel.setVisible(false);
		
		btnClear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				firstNameBox.setText("");
				lastNameBox.setText("");
				addressBox.setText("");
				emailBox.setText("");
				passwordBox.setText("");
				genderComboBox.setSelectedIndex(0);
				monthComboBox.setSelectedIndex(0);
				dayComboBox.setSelectedIndex(0);
				yearComboBox.setSelectedIndex(0);
				rdbtnStudent.setValue(false);
				rdbtnProfessor.setValue(false);
				rdbtnOther.setValue(false);
				instBox.setText("");
				joinYearBox.setSelectedIndex(0);
				gradYearBox.setSelectedIndex(0);
				majorBox.setText("");
				gpaBox.setText("");
				departmentBox.setText("");
				researchBox.setText("");
				if (advisorComboBox.isAttached()) {
					advisorComboBox.removeFromParent();
					lblAdvisor.removeFromParent();
					lblJoinGradYear.removeFromParent();
					joinYearBox.removeFromParent();
					gradYearBox.removeFromParent();
					lblMajorGPA.removeFromParent();
					majorBox.removeFromParent();
					gpaBox.removeFromParent();
					absolutePanel.setWidgetPosition(btnClear, 258, 609);
					absolutePanel.setWidgetPosition(btnSubmit, 332, 609);
					absolutePanel.setWidgetPosition(btnBackToHome, 258, 671);
				}
				if (departmentBox.isAttached()) {
					lblDepartment.removeFromParent();
					departmentBox.removeFromParent();
					lblResearch.removeFromParent();
					researchBox.removeFromParent();
					absolutePanel.setWidgetPosition(btnClear, 258, 609);
					absolutePanel.setWidgetPosition(btnSubmit, 332, 609);
					absolutePanel.setWidgetPosition(btnBackToHome, 258, 671);
				}
			}
		});
		
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean readyToSubmit = true;
				String type = "";
				String advisor = null;
				String joinYear = null;
				String gradYear = null;
				String major = null;
				String gpa = null;
				String dept = null;
				String research = null;
				if (rdbtnStudent.isChecked()) {
					type = "STUD";
					advisor = advisorComboBox.getValue(advisorComboBox.getSelectedIndex());
					joinYear = joinYearBox.getValue(joinYearBox.getSelectedIndex());
					gradYear = gradYearBox.getValue(gradYearBox.getSelectedIndex());
					major = majorBox.getText();
					gpa = gpaBox.getText();
					if (!FieldVerifier.isValidGPA(gpa)) {
						errGPALabel.setText("Please enter a valid GPA.");
						errGPALabel.setVisible(true);
						readyToSubmit = false;
					} else if (errGPALabel.isVisible()) {
						errGPALabel.setVisible(false);
					}
				} else if (rdbtnProfessor.isChecked()) {
					type = "PROF";
					dept = departmentBox.getText();
					research = researchBox.getText();
				} else {
					type = "OTHR";
				}
				if (!FieldVerifier.isValidName(firstNameBox.getText())) {
					errFNameLabel.setText("Please enter a name longer than one letter.");
					errFNameLabel.setVisible(true);
					readyToSubmit = false;
				} else if (errFNameLabel.isVisible()) {
					errFNameLabel.setVisible(false);
				}
				if (!FieldVerifier.isValidName(lastNameBox.getText())) {
					errLNameLabel.setText("Please enter a name longer than one letter.");
					errLNameLabel.setVisible(true);
					readyToSubmit = false;
				} else if (errLNameLabel.isVisible()) {
					errLNameLabel.setVisible(false);
				}
				if (!FieldVerifier.isValidEmail(emailBox.getText())) {
					errEmailLabel.setText("Please enter a valid email address.");
					errEmailLabel.setVisible(true);
					readyToSubmit = false;
				} else if (errEmailLabel.isVisible()) {
					errEmailLabel.setVisible(false);
				}
				if (!FieldVerifier.isValidPassword(passwordBox.getText())) {
					errPWLabel.setText("Please enter a password longer than 5 characters.");
					errPWLabel.setVisible(true);
					readyToSubmit = false;
				} else if (errPWLabel.isVisible()) {
					errPWLabel.setVisible(false);
				}
				boolean typeSelected = rdbtnStudent.isChecked() || rdbtnProfessor.isChecked() || rdbtnOther.isChecked();
				if (!rdbtnStudent.isChecked() && !rdbtnProfessor.isChecked() && !rdbtnOther.isChecked()) {
					errTypeLabel.setText("Please select a type of account.");
					errTypeLabel.setVisible(true);
					readyToSubmit = false;
				} else if (typeSelected) {
					errTypeLabel.setVisible(false);
				}
				if (readyToSubmit) {
					RegisterService.register(firstNameBox.getText(), lastNameBox.getText(), addressBox.getText(), 
							monthComboBox.getValue(monthComboBox.getSelectedIndex()), dayComboBox.getValue(dayComboBox.getSelectedIndex()),
							yearComboBox.getValue(yearComboBox.getSelectedIndex()), genderComboBox.getValue(genderComboBox.getSelectedIndex()),
							instBox.getText(), emailBox.getText(), passwordBox.getText(), type, advisor, joinYear, gradYear, major, gpa, 
							dept, research, new AsyncCallback<String>() {
						public void onFailure(Throwable error) {
							System.out.println("Fail");
							try {
								throw error;
							} catch (Throwable e) {
								e.printStackTrace();
							}
						}
						public void onSuccess(String userID) {
							if (userID.startsWith("33")) {
								Cookies.setCookie("userID", userID);
								History.newItem("homepage", true);
							} else {
								errDupEmailLabel.setText(userID);
								errDupEmailLabel.setVisible(true);
							}
						}
					});
				}
			}
		});
		
		btnBackToHome.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				History.newItem("login", true);
			}
		});
	}
}
