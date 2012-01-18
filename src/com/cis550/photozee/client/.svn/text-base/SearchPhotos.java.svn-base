package com.cis550.photozee.client;

import java.util.List;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.reveregroup.gwt.imagepreloader.FitImage;

public class SearchPhotos extends Composite {
	
	private AbsolutePanel searchphoto = new AbsolutePanel();
	static private SearchPhotos _instance = null;
	private Integer user_id = Integer.parseInt(Cookies.getCookie("userID"));
	private Integer userID = Integer.parseInt(Cookies.getCookie("userID"));
	private final PhotoServiceAsync PhotoService = GWT.create(PhotoService.class);
	
	public Integer getUser(){
		
		return user_id;
	}
	public SearchPhotos(){
		// ******* HEADER PANEL *******
		HorizontalPanel headerPanel = new HorizontalPanel();
		searchphoto.add(headerPanel, 0, 0);
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
				
		//Logout
				
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
		searchphoto.add(welcomePanel, 0, 61);
		welcomePanel.setSize("1000px", "62px");
		
		Label lblWelcome = new Label("Search Photos on Tag Words");
		lblWelcome.setStyleName("gwt-PageTitle");
		welcomePanel.add(lblWelcome);
		welcomePanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
		welcomePanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
		// *******************
		initPage();
		initWidget(searchphoto);		
	}

	public static SearchPhotos getInstance(){
        if(null == _instance) {
        	_instance = new SearchPhotos();
        }
        return _instance;
	}

	private void initPage() {
		
		searchphoto.setSize("1200px", "900px");
		
		final TextBox searchBox = new TextBox();
		searchphoto.add(searchBox, 293, 129);
		searchBox.setSize("507px", "35px");
		
		Button searchButton = new Button("Search");
		
		searchphoto.add(searchButton, 875, 129);
		searchButton.setSize("126px", "47px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		searchphoto.add(scrollPanel, 79, 209);
		scrollPanel.setSize("1033px", "617px");
		
		final FlowPanel searchResultPanel = new FlowPanel();
		scrollPanel.setWidget(searchResultPanel);
		searchResultPanel.setSize("100%", "100%");
		
		searchButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(searchBox.getText() == "" || searchBox.getText() == null){
					searchResultPanel.clear();
				}
				else{
					PhotoService.searchPhotos(searchBox.getText(),getUser(), new AsyncCallback<List<Photo>>() {
						
						@Override
						public void onSuccess(List<Photo> result) {
							
							if (result.size()==0){
								searchResultPanel.clear();
								FitImage image = new FitImage();
								image.setUrl("http://www.prosports.dk/images/No-record-found.png");
								image.setMaxSize(350, 350);	
								searchResultPanel.add(image);
							}
							else{
							searchResultPanel.clear();
							for(Photo photo:result)
							{
								final Photo foto = photo;
								FitImage image = new FitImage();
								image.setUrl(photo.getUrl());
								image.setMaxSize(350, 350);	
								image.addClickHandler(new ClickHandler() {
									
									@Override
									public void onClick(ClickEvent event) {
										final DialogBox dialogBox = new DialogBox();
										
									    dialogBox.setGlassEnabled(true);
									   // dialogBox.setAnimationEnabled(true);
									    VerticalPanel closepanel = new VerticalPanel();
							            Button closeButton = new Button(
							                    "Close", new ClickHandler() {
							                      public void onClick(ClickEvent event) {
							                        dialogBox.hide(); 		                        
							                      }
							                    });
							     
					
							            String tags = "";
										List<Tag> tagList = foto.getTags();
										final Label lblTags = new Label();
										int length = tagList.size();
										if (length > 0) {
											for (int j = 0; j < length; j++) {
												if (j != length - 1) {
													tags += tagList.get(j).getTag() + ", ";
												} else {
													tags += tagList.get(j).getTag();
												}
											}
											lblTags.setText("Tags: " + tags);
										} else {
											lblTags.setText("No tags");
										}
										closepanel.add(new DisplayPhoto(foto,"search"));
					
							            closepanel.add(lblTags);
							            // Add close button
							            closepanel.add(closeButton);
							            dialogBox.setWidget(closepanel);
							            dialogBox.setWidth("631px");
							            dialogBox.center();
							            dialogBox.show();
										
									}
								});
								searchResultPanel.add(image);
							}
							}
							
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							searchResultPanel.clear();
							FitImage image = new FitImage();
							image.setUrl("http://www.platformnation.com/wp-content/uploads/2011/10/497px-Error.svg_.png");
							image.setMaxSize(350, 350);					
							searchResultPanel.add(image);
							
							//searchResultPanel.add(new HTML("some Error in Network"));
							
						}
					});
				}
				
			}
		});
		
		
	}
}
