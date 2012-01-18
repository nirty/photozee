package com.cis550.photozee.client;

import java.util.ArrayList;

import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class UsersChoose extends Composite {
	private AbsolutePanel userschoose = new AbsolutePanel();
	static private UsersChoose _instance = null;
	final FlexTable userListTable = new FlexTable();
	static final private ArrayList<Integer> chosen_users = new ArrayList<Integer>();
	private int userid = Integer.parseInt(Cookies.getCookie("userID"));;

	private final UserProfileServiceAsync userprofileService = GWT
			.create(UserProfileService.class);

	public UsersChoose() {

		initPage();
		initWidget(userschoose);
		

	}

	public static UsersChoose getInstance() {
		if (null == _instance) {
			_instance = new UsersChoose();
		}
		return _instance;
	}

	private void initPage() {
		
		userschoose.setSize("1200px", "900px");
		
		Button userChoosingdonebtn = new Button("Save and Go Back");
		userChoosingdonebtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem("uploadphoto", true);
				RootPanel.get().clear();
				RootPanel.get().add(UploadPhoto.getInstance());
			}
		});
		userschoose.add(userChoosingdonebtn, 50, 59);
		userChoosingdonebtn.setSize("217px", "64px");
		
		Label lblChooseTheList = new Label("Choose the List of Users that you want to make the Photo Available!");
		userschoose.add(lblChooseTheList, 467, 195);
		userschoose.add(userListTable, 230, 277);
		userListTable.setSize("854px", "39px");
		
		
		final ArrayList<User> list_of_users = new ArrayList<User>();
		final ArrayList<CheckBox> list_of_widgets = new ArrayList<CheckBox>();
		
		userprofileService.getUserid(userid, new AsyncCallback<ArrayList<User>>() {
			
			@Override
			public void onSuccess(ArrayList<User> result) {
				for (User user : result) {
					list_of_users.add(user);
				}

				for (User user : list_of_users) {
					list_of_widgets.add(convert2Widgets(user));
				}

				printCheckBoxes(list_of_widgets);
				
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	
	private CheckBox convert2Widgets(User user) {
		CheckBox checkBox = new CheckBox(user.getF_name() + " " + user.getL_name());
		final Integer user_id = user.getUser_id();
		checkBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				userschosen(user_id);

			}
		});
		return checkBox;

	}
	
	void userschosen(Integer userid) {
		
		if (chosen_users.contains(userid))
			chosen_users.remove(userid);
		else
			chosen_users.add(userid);
		
		/*StringBuilder st = new StringBuilder();
		for(Integer cir:chosen_users){
			st.append(cir.toString());
		}
		userschoose.add(new HTML(st.toString()));*/
	}
	
	void printCheckBoxes(ArrayList<CheckBox> result) {

		int no_of_circles = result.size();
		int ht = no_of_circles / 3;
		if (no_of_circles % 3 != 0)
			ht = ht + 1;
		int number = 0;
		for (int i = 0; i < ht; i++) {
			for (int j = 0; j < 3; j++) {
				if (number >= no_of_circles) {
				} else {

					userListTable.setWidget(i, j, result.get(number));
					number = number + 1;
				}
			}
		}

	}
	
	public static ArrayList<Integer> getChosenUsers(){		
		return chosen_users;
		
	}


}
