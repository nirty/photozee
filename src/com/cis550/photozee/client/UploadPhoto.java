package com.cis550.photozee.client;

import java.util.ArrayList;

import com.cis550.photozee.client.model.UserProfile;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.reveregroup.gwt.imagepreloader.FitImage;
import com.reveregroup.gwt.imagepreloader.FitImage;
import com.reveregroup.gwt.imagepreloader.FitImageLoadEvent;
import com.reveregroup.gwt.imagepreloader.FitImageLoadHandler;
import com.reveregroup.gwt.imagepreloader.ImageLoadEvent;
import com.reveregroup.gwt.imagepreloader.ImageLoadHandler;
import com.reveregroup.gwt.imagepreloader.ImagePreloader;

public class UploadPhoto extends Composite {
	
	private AbsolutePanel uploadphoto = new AbsolutePanel();
	static private UploadPhoto _instance = null;
	private final UserProfileServiceAsync userprofileService = GWT.create(UserProfileService.class);
	private int userid = Integer.parseInt(Cookies.getCookie("userID"));
	final int userID = Integer.parseInt(Cookies.getCookie("userID"));
	
	public UploadPhoto(){
		
		initPage();
		initWidget(uploadphoto);		
	}

	public static UploadPhoto getInstance(){
        if(null == _instance) {
        	_instance = new UploadPhoto();
        }
        return _instance;
	}

	private void initPage() {
		uploadphoto.setSize("1200px", "900px");
		final int userID = userid;
		// ******* HEADER PANEL *******
				HorizontalPanel headerPanel = new HorizontalPanel();
				uploadphoto.add(headerPanel, 0, 0);
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
								History.newItem("addfriend", true);
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
								History.newItem("logout-success", true);
							}
						});
						headerPanel.add(logoutButton);
						logoutButton.setSize("106px", "45px");
						headerPanel.setCellVerticalAlignment(logoutButton, HasVerticalAlignment.ALIGN_MIDDLE);
						headerPanel.setCellHorizontalAlignment(logoutButton, HasHorizontalAlignment.ALIGN_CENTER);
						
						
				HorizontalPanel welcomePanel = new HorizontalPanel();
				uploadphoto.add(welcomePanel, 0, 61);
				welcomePanel.setSize("1000px", "62px");
				
				Label lblWelcome = new Label("Upload a Photo!");
				lblWelcome.setStyleName("gwt-PageTitle");
				welcomePanel.add(lblWelcome);
				welcomePanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
				welcomePanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
				// *******************
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setBorderWidth(0);
		uploadphoto.add(horizontalPanel, 0, 121);
		horizontalPanel.setSize("1200px", "135px");
		
		AbsolutePanel addPhotoPanel = new AbsolutePanel();
		horizontalPanel.add(addPhotoPanel);
		addPhotoPanel.setHeight("133px");
		
		final TextBox uploadUrl = new TextBox();
		addPhotoPanel.add(uploadUrl, 97, 32);
		uploadUrl.setSize("728px", "27px");
		
		final AbsolutePanel imagepanel = new AbsolutePanel();
		uploadphoto.add( imagepanel, 36, 264);
		 imagepanel.setSize("800px", "459px");
		
		
		Button uploadPhotoBtn = new Button("Upload");
		uploadPhotoBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				 imagepanel.clear();
				
			// this is jar that was used as an External library to reduce the resolution	
				FitImage image = new FitImage();
				image.setUrl(uploadUrl.getText());
				image.setMaxSize(600, 600);
				 imagepanel.add(image);
		
			 
			}
		});

		addPhotoPanel.add(uploadPhotoBtn, 936, 32);
		uploadPhotoBtn.setSize("188px", "39px");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setBorderWidth(0);
		uploadphoto.add(horizontalPanel_1, 861, 268);
		horizontalPanel_1.setSize("327px", "370px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		horizontalPanel_1.add(absolutePanel);
		absolutePanel.setStyleName("h1");
		absolutePanel.setSize("325px", "370px");
		
		final TextArea CaptiontextArea = new TextArea();
		absolutePanel.add(CaptiontextArea, 35, 46);
		CaptiontextArea.setSize("247px", "43px");
		
		final TextArea tagsTextArea = new TextArea();
		absolutePanel.add(tagsTextArea, 41, 141);
		tagsTextArea.setSize("240px", "27px");
		
		final ListBox selectVisibility = new ListBox();
		selectVisibility.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				Integer index = selectVisibility.getSelectedIndex();
				if (index != 0)
					visibilityclicked(index);
					
			}
		});
		
		
	
		selectVisibility.addItem("All");
		selectVisibility.addItem("Circles");
		selectVisibility.addItem("List of Users");
		absolutePanel.add(selectVisibility, 44, 246);
		selectVisibility.setSize("248px", "22px");
		
		Button saveBtn = new Button("Save Photo");
		
		
		saveBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
				final String  url = uploadUrl.getText();
				String caption = CaptiontextArea.getText();
				String tag = tagsTextArea.getText();
				ArrayList<Integer> visibilityList = null;
				int index = selectVisibility.getSelectedIndex();
				if(index == 1){					
					visibilityList = CirclesChoose.getChosenCircles();
				}
				if(index == 2){
					visibilityList = UsersChoose.getChosenUsers();
				}
					
				userprofileService.uploadPhoto(userid, url, caption, tag,index,visibilityList, new AsyncCallback<UserProfile>() {
					
					@Override
					public void onSuccess(UserProfile result) {
					
						final DialogBox dialogBox = new DialogBox();
						
					    dialogBox.setGlassEnabled(true);
					    dialogBox.setAnimationEnabled(true);
					   VerticalPanel closepanel = new VerticalPanel();
			            Button closeButton = new Button(
			                    "close", new ClickHandler() {
			                      public void onClick(ClickEvent event) {
			                        dialogBox.hide();
			                        History.newItem("?profile="+userid, true);
			                        
			                      }
			                    });
			            
			            closepanel.add(new HTML("your photo Has been saved"));
			            closepanel.add(closeButton);
			            dialogBox.setWidget(closepanel);
			            dialogBox.center();
			            dialogBox.show();
			            
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						final DialogBox dialogBox = new DialogBox();
						dialogBox.setWidget( new HTML("some Error has occured"));
					    dialogBox.setGlassEnabled(true);
					    dialogBox.setAnimationEnabled(true);
					  
			            Button closeButton = new Button(
			                    "close", new ClickHandler() {
			                      public void onClick(ClickEvent event) {
			                        dialogBox.hide();
			                        History.newItem("myprofile", true);
			                      }
			                    });
			            dialogBox.add(closeButton);
			            dialogBox.center();
			            dialogBox.show();
			           
						
					}
				});
			}
		});
		
		absolutePanel.add(saveBtn, 41, 298);
		saveBtn.setSize("250px", "53px");
		
		Label lblCaptionForThe = new Label("Caption For the picture");
		absolutePanel.add(lblCaptionForThe, 83, 22);
		
		Label lblTagsForThe = new Label("Tags for the photo");
		absolutePanel.add(lblTagsForThe, 109, 117);
		
		Label lblPleaseUse = new Label("*Please use 'Commas' to separate the tags");
		lblPleaseUse.setStyleName("h1");
		absolutePanel.add(lblPleaseUse, 35, 184);
		
		Label lblSetVisibility = new Label("Set Visibility");
		absolutePanel.add(lblSetVisibility, 126, 222);
		
		
		
		
	}
	
	
	private void visibilityclicked(Integer index){
		
		if (index == 1){
			RootPanel.get().clear();
			RootPanel.get().add(CirclesChoose.getInstance());
		}else{
			RootPanel.get().clear();
			RootPanel.get().add(UsersChoose.getInstance());
			
		}
		
	}
	

}
