package com.cis550.photozee.client;

import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.FlexTable;

public class AddFriend extends Composite {
	
	private AbsolutePanel addfriend = new AbsolutePanel();
	static private AddFriend _instance = null;
	
	static final private ArrayList<Integer> chosen_circles = new ArrayList<Integer>();
	final VerticalPanel friendRequestsSentPanel = new VerticalPanel();
	
	final ArrayList<Circle> list_of_circles = new ArrayList<Circle>();
	final ArrayList<CheckBox> list_of_widgets = new ArrayList<CheckBox>();
	final FlexTable CirclesChooseflexTable = new FlexTable();
	private int userid = Integer.parseInt(Cookies.getCookie("userID"));
	private int userID = Integer.parseInt(Cookies.getCookie("userID"));

	private final UserProfileServiceAsync userprofileService = GWT
			.create(UserProfileService.class);

	
	public AddFriend(){
		// ******* HEADER PANEL *******
				HorizontalPanel headerPanel = new HorizontalPanel();
				addfriend.add(headerPanel, 0, 0);
				headerPanel.setSize("1000px", "62px");
				
				Label lblWelcomeUser = new Label();
				lblWelcomeUser.setText(Cookies.getCookie("userNAME"));
				lblWelcomeUser.setStyleName("gwt-PageTitle");
				headerPanel.add(lblWelcomeUser);
				headerPanel.setCellVerticalAlignment(lblWelcomeUser, HasVerticalAlignment.ALIGN_MIDDLE);
				headerPanel.setCellHorizontalAlignment(lblWelcomeUser, HasHorizontalAlignment.ALIGN_CENTER);
				
				Button btnHomePage = new Button("Home Page");
				btnHomePage.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						History.newItem("homepage", true);
						RootPanel.get().clear();
			    		RootPanel.get().add(new HomePage());
					}
				});
				headerPanel.add(btnHomePage);
				btnHomePage.setSize("106px", "45px");
				headerPanel.setCellHorizontalAlignment(btnHomePage, HasHorizontalAlignment.ALIGN_CENTER);
				headerPanel.setCellVerticalAlignment(btnHomePage, HasVerticalAlignment.ALIGN_MIDDLE);
				
				Button btnMyProfile = new Button("My Profile");
				btnMyProfile.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						History.newItem("?profile=" + userID, true);
					}
				});
				headerPanel.add(btnMyProfile);
				btnMyProfile.setSize("106px", "45px");
				headerPanel.setCellVerticalAlignment(btnMyProfile, HasVerticalAlignment.ALIGN_MIDDLE);
				headerPanel.setCellHorizontalAlignment(btnMyProfile, HasHorizontalAlignment.ALIGN_CENTER);
				
				Button btnSearch = new Button("Search Photos");
				btnSearch.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						History.newItem("?searchphotos=" + userID, true);
					}
				});
				headerPanel.add(btnSearch);
				btnSearch.setSize("106px", "45px");
				headerPanel.setCellVerticalAlignment(btnSearch, HasVerticalAlignment.ALIGN_MIDDLE);
				headerPanel.setCellHorizontalAlignment(btnSearch, HasHorizontalAlignment.ALIGN_CENTER);
				
				Button btnUpload = new Button("Upload a Photo");
				btnUpload.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						History.newItem("?uploadphoto=" + userID, true);
						//RootPanel.get().clear();
			    		//RootPanel.get().add(UploadPhoto.getInstance(userID));
					}
				});
				headerPanel.add(btnUpload);
				btnUpload.setSize("106px", "45px");
				headerPanel.setCellHorizontalAlignment(btnUpload, HasHorizontalAlignment.ALIGN_CENTER);
				headerPanel.setCellVerticalAlignment(btnUpload, HasVerticalAlignment.ALIGN_MIDDLE);
				
				Button btnBrowseFriends = new Button("Browse Friends");
				btnBrowseFriends.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						History.newItem("?frenbrowser=" + userID, true);
						//RootPanel.get().clear();
			    		//RootPanel.get().add(FriendhipBrowser.getInstance(userID));
					}
				});
				headerPanel.add(btnBrowseFriends);
				btnBrowseFriends.setSize("106px", "45px");
				headerPanel.setCellVerticalAlignment(btnBrowseFriends, HasVerticalAlignment.ALIGN_MIDDLE);
				headerPanel.setCellHorizontalAlignment(btnBrowseFriends, HasHorizontalAlignment.ALIGN_CENTER);
				
				// Add  a friend button
						Button addFriendButton = new Button("Add a Friend");
						addFriendButton.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								// Change this
								RootPanel.get().clear();
					    		RootPanel.get().add(new AddFriend());
							}
						});
						headerPanel.add(addFriendButton);
						addFriendButton.setSize("106px", "45px");
						headerPanel.setCellVerticalAlignment(addFriendButton, HasVerticalAlignment.ALIGN_MIDDLE);
						headerPanel.setCellHorizontalAlignment(addFriendButton, HasHorizontalAlignment.ALIGN_CENTER);
						
						Button logoutButton = new Button("Log out");
						logoutButton.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								Cookies.removeCookie("userID");
								Cookies.removeCookie("userNAME");
								RootPanel.get().clear();
					    		RootPanel.get().add(new Login());
							}
						});
						headerPanel.add(logoutButton);
						logoutButton.setSize("106px", "45px");
						headerPanel.setCellVerticalAlignment(logoutButton, HasVerticalAlignment.ALIGN_MIDDLE);
						headerPanel.setCellHorizontalAlignment(logoutButton, HasHorizontalAlignment.ALIGN_CENTER);
				
				HorizontalPanel welcomePanel = new HorizontalPanel();
				addfriend.add(welcomePanel, 0, 61);
				welcomePanel.setSize("1000px", "62px");
				
				Label lblWelcome = new Label("Add a Friend");
				lblWelcome.setStyleName("gwt-PageTitle");
				welcomePanel.add(lblWelcome);
				welcomePanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
				welcomePanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
				// *******************
		initPage();
		initWidget(addfriend);	
	}

	public static AddFriend getInstance(){
        if(null == _instance) {
        	_instance = new AddFriend();
        }
        return _instance;
	}

	private void initPage() {
		
		getCirclesforUser();
		getFriendReqsSent();
		addfriend.setSize("1300px", "900px");
		
		ScrollPanel friendRequestsSentscrollDock = new ScrollPanel();
		addfriend.add(friendRequestsSentscrollDock, 10, 263);
		friendRequestsSentscrollDock.setSize("303px", "464px");
		
		
		friendRequestsSentscrollDock.setWidget(friendRequestsSentPanel);
		friendRequestsSentPanel.setSize("100%", "100%");
		
		
		final AbsolutePanel friendRequestMessagePanel = new AbsolutePanel();
		addfriend.add(friendRequestMessagePanel, 349, 263);
		friendRequestMessagePanel.setSize("706px", "51px");
		
		final TextBox emailtextBox = new TextBox();
		addfriend.add(emailtextBox, 349, 187);
		emailtextBox.setSize("524px", "22px");
		
		Button addFriendButton = new Button("New button");
		addFriendButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//addfriend.add(new HTML(new Integer(chosen_circles.size()).toString()));
				if(chosen_circles.size() != 0){
				userprofileService.addFriend(userid, chosen_circles, emailtextBox.getText() , new AsyncCallback<FriendMapping>() {
					
					@Override
					public void onSuccess(FriendMapping result) {
						
						if(result == null || result.getFriend_fname() == null || result.getFriend_lname() == null || result.getFriend_id() == 0){
							friendRequestMessagePanel.clear();
							emailtextBox.setText("");
							friendRequestMessagePanel.add(new HTML("Email not found. Please try again."));
						}
						else{
							
							friendRequestMessagePanel.clear();
							emailtextBox.setText("");
							friendRequestMessagePanel.add(new HTML("Friend Request Sent to "+ result.getFriend_fname() + " " + result.getFriend_lname()));
							getFriendReqsSent();
						}
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				}
				else{
					friendRequestMessagePanel.clear();
					friendRequestMessagePanel.add(new HTML("Choose circle:"));
					
				}

			}
		});
		addFriendButton.setText("Add Friend");
		addfriend.add(addFriendButton, 903, 187);
		addFriendButton.setSize("152px", "34px");
		

		
		

		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		addfriend.add(absolutePanel, 349, 320);
		absolutePanel.setSize("706px", "407px");
		
		Label lblChooseCirclesTo = new Label("Choose circle:");
		lblChooseCirclesTo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		absolutePanel.add(lblChooseCirclesTo, 10, 10);
		lblChooseCirclesTo.setSize("686px", "16px");
		
		
		absolutePanel.add(CirclesChooseflexTable, 10, 32);
		CirclesChooseflexTable.setSize("686px", "23px");
		
		Label lblCreateANew = new Label("Create a New Circle:");
		addfriend.add(lblCreateANew, 1061, 320);
		lblCreateANew.setSize("227px", "16px");
		
		final TextBox createCircleText = new TextBox();
		addfriend.add(createCircleText, 1071, 342);
		createCircleText.setSize("203px", "18px");
		
		Button CircleCreateButton = new Button("Create");
		CircleCreateButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				//create a New Circle -- On Success refresh the Circle choosen Table
				
				userprofileService.CreateCircle(userid,createCircleText.getText() , new AsyncCallback<Integer>() {
					
					@Override
					public void onSuccess(Integer result) {
						createCircleText.setText("");
						getCirclesforUser();
						friendRequestMessagePanel.clear();
						friendRequestMessagePanel.add(new HTML("New circle created."));
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						friendRequestMessagePanel.clear();
						friendRequestMessagePanel.add(new HTML("Error processing request. Please try again."));
						
					}
				});
			}
		});
		CircleCreateButton.setText("Create");
		addfriend.add(CircleCreateButton, 1145, 378);
		CircleCreateButton.setSize("93px", "38px");
		
		

	}
	
	public void getFriendReqsSent(){
		
		userprofileService.FriendRequestsSent(userid, new AsyncCallback<List<FriendMapping>>() {
			
			@Override
			public void onSuccess(List<FriendMapping> result) {
				// TODO Auto-generated method stub
				if(result == null){
					//friendRequestsSentPanel.add(new HTML("null"));
				}
				else {
					friendRequestsSentPanel.clear();
					friendRequestsSentPanel.add(new HTML("Friend Requests Sent:"));
					for(FriendMapping friend :result){
						
						friendRequestsSentPanel.add(new HTML(friend.getFriend_fname()+ " "+ friend.getFriend_lname()));
						//System.out.println(friend.getFriend_fname());
					}
				
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				addfriend.add(new HTML("errors.."));
				
			}
		});
		
		
	}
	private void getCirclesforUser(){
		userprofileService.getCircleid(userid,
				new AsyncCallback<ArrayList<Circle>>() {

					@Override
					public void onSuccess(ArrayList<Circle> result) {
						list_of_circles.removeAll(list_of_circles);
						list_of_widgets.removeAll(list_of_widgets);
						for (Circle circle : result) {
							list_of_circles.add(circle);
						}

						for (Circle circle : list_of_circles) {
							list_of_widgets.add(convert2Widgets(circle));
						}
						printCheckBoxes(list_of_widgets);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
	}
	
	private CheckBox convert2Widgets(Circle circle) {
		CheckBox checkBox = new CheckBox(circle.getCircle_name().toString());
		final Integer circle_id = circle.getCircle_id();
		checkBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				circleschosen(circle_id);

			}
		});
		return checkBox;

	}
	
	void circleschosen(Integer circleid) {
		
		if (chosen_circles.contains(circleid))
			chosen_circles.remove(circleid);
		else
			chosen_circles.add(circleid);
		/*
		StringBuilder st = new StringBuilder();
		for(Integer cir:chosen_circles){
			st.append(cir.toString());
		}
		addfriend.add(new HTML(st.toString()));*/
		
	}

	void printCheckBoxes(ArrayList<CheckBox> result) {

		CirclesChooseflexTable.clear();
		int no_of_circles = result.size();
		int ht = no_of_circles / 3;
		if (no_of_circles % 3 != 0)
			ht = ht + 1;
		int number = 0;
		for (int i = 0; i < ht; i++) {
			for (int j = 0; j < 3; j++) {
				if (number >= no_of_circles) {
				} else {

					CirclesChooseflexTable.setWidget(i, j, result.get(number));
					number = number + 1;
				}
			}
		}

	}
	
	public static ArrayList<Integer> getChosenCircles(){		
		return chosen_circles;
		
	}
}
