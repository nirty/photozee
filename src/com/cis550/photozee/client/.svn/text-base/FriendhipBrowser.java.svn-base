package com.cis550.photozee.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.cis550.photozee.client.model.UserProfile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.cis550.photozee.client.FriendVisualization;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.reveregroup.gwt.imagepreloader.FitImage;

public class FriendhipBrowser extends Composite {
	
	private JavaScriptObject theGraph;
	private int currentPerson;
	private int firstPhoto;
	private final UserProfileServiceAsync userprofileService = GWT.create(UserProfileService.class);
	private final List<Integer> fren_ids =  new ArrayList<Integer>();
	AbsolutePanel infoPanel = new AbsolutePanel();
	AbsolutePanel hypertreePanel = new AbsolutePanel();	
	ScrollPanel photoScrollPanel = new ScrollPanel();
	VerticalPanel verticalPhotoPanel = new VerticalPanel();
	
	
	private AbsolutePanel frenshipbrowser = new AbsolutePanel();
	static private FriendhipBrowser _instance = null;
	private Integer userid = Integer.parseInt(Cookies.getCookie("userID"));
	
	public FriendhipBrowser(){
		initPage();
		initWidget(frenshipbrowser);
		final int userID = userid;
		// ******* HEADER PANEL *******
		HorizontalPanel headerPanel = new HorizontalPanel();
		frenshipbrowser.add(headerPanel, 0, 0);
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
		frenshipbrowser.add(welcomePanel, 0, 61);
		welcomePanel.setSize("1000px", "62px");
		
		Label lblWelcome = new Label("Browse your Friend Network!");
		lblWelcome.setStyleName("gwt-PageTitle");
		welcomePanel.add(lblWelcome);
		welcomePanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
		welcomePanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
		// *******************
		
		frenshipbrowser.add(infoPanel, 10, 143);
		infoPanel.setSize("238px", "448px");
		
		frenshipbrowser.add(hypertreePanel, 263, 139);
		hypertreePanel.setSize("646px", "602px");
		HTML html = new HTML("<div id=\"infovis\" align=\"center\"></div>");
		html.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		html.setSize("646px", "23px");
		frenshipbrowser.add(html, 263, 46);
		
		
		frenshipbrowser.add(photoScrollPanel, 915, 138);
		photoScrollPanel.setSize("275px", "603px");
		
		
		photoScrollPanel.setWidget(verticalPhotoPanel);
		verticalPhotoPanel.setSize("266px", "51px");
		
		
	}

	public static FriendhipBrowser getInstance(){
        if(null == _instance) {
        	_instance = new FriendhipBrowser();
        }
        return _instance;
	}

	private void initPage() {
		frenshipbrowser.setSize("1200px", "900px");
		
		userprofileService.getFriends(userid,userid, new AsyncCallback<ArrayList<Integer>>() {
			
			@Override
			public void onSuccess(ArrayList<Integer> result) {
				for(Integer id:result){
					fren_ids.add(id);
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		userprofileService.UserinJson(userid,userid, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				
				theGraph = FriendVisualization.createGraph(result,  FriendhipBrowser.this);
				//frenshipbrowser.add(new HTML(result));
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		fillInfoPanelAndPicture(userid);
		
/*		userprofileService.getUserProfile(33001, new AsyncCallback<UserProfile>() {
			
			@Override
			public void onSuccess(UserProfile result) {
				//theGraph = FriendVisualization.createGraph("{\"id\":1, \"name\":\"Bob\", \"children\":[{\"id\":2, \"name\":\"shiva\"},{\"id\":3, \"name\":\"subbu\"},{\"id\":4, \"name\":\"dd\"},{\"id\":5, \"name\":\"Ram\"}], \"data\":{\"photos\":[]}}", FriendhipBrowser.this);
				theGraph = FriendVisualization.createGraph("{\"id\":33000, \"name\":\"Nirtyanath Jaganathan\", \"children\":[{\"id\":33001, \"name\":\"Sashi Kumar\" , \"type\":\"STUD\" },{\"id\":33002, \"name\":\"Ram Kumar\" },{\"id\":33003, \"name\":\"Amjad Umar\"},{\"id\":33009, \"name\":\"Kishore Raj\"}]}", FriendhipBrowser.this);
				
				//frenshipbrowser.add(new HTML(result.toJson()));
				//System.out.println(result.toJson());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				frenshipbrowser.add(new HTML("Failed"));
				
			}
		});*/
	}
	
	public void fillInfoPanelAndPicture(int user_id){
		
		
		userprofileService.getUserProfile(user_id,userid, new AsyncCallback<UserProfile>() {
			
			@Override
			public void onSuccess(UserProfile user) {
				
				Label u_name = new Label("First Name :" +user.getF_name());
				u_name.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				Label l_name = new Label("Last Name  :" +user.getL_name());
				l_name.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				Label age    = new Label("Age        :" +user.getAge());
				age.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				Label email  = new Label("Email      :" +user.getEmail());
				email.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				Label add    = new Label("Address    :" +user.getAddress());
				add.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				Label gender = new Label("Gender     :" +user.getGender());
				gender.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				Label dob    = new Label("Birth Date :" +user.getDob().toString());
				dob.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				infoPanel.clear();
				infoPanel.add(u_name);
				infoPanel.add(l_name);
				infoPanel.add(age);
				infoPanel.add(email);
				infoPanel.add(add);
				infoPanel.add(gender);
				infoPanel.add(dob);
				
				
				SimpleDateFormat dateFmt = new SimpleDateFormat("MMMM d, yyyy");
				if(user.getType().equals("PROF")){
					
					String dept= user.getProfessor().getDepartment();
					String researchArea = user.getProfessor().getResearchArea();
					
					Label deptLabel = new Label("Department: " + dept);
					deptLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					Label dobLabel = new Label("Research Area: " + researchArea);
					dobLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					
					infoPanel.add(deptLabel);
					infoPanel.add(dobLabel);
					
				}
				else if(user.getType().equals("STUD")){
					String gpa = user.getStudent().getGpa().toString();
					String major = user.getStudent().getMajor();
					String strGradYear = dateFmt.format(user.getStudent().getGrad_year());
					
					Label gpaLabel = new Label("GPA: " + gpa);
					gpaLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					Label majorLabel = new Label("Research Area: " + major);
					majorLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					Label gradYear = new Label("Graduation Year:" + strGradYear);
					gradYear.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					
					infoPanel.add(gpaLabel);
					infoPanel.add(majorLabel);
					infoPanel.add(gradYear);
					
					
				}
				
				List<Photo> list_of_photos = user.getPhotos();
				verticalPhotoPanel.clear();
				for(Photo picture:list_of_photos){
					final Photo photo = picture;
					FitImage image = new FitImage();
					image.setUrl(picture.getUrl());
					image.setMaxSize(250, 200);
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
							List<Tag> tagList = photo.getTags();
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
							closepanel.add(new DisplayPhoto(photo,"frenbrowser"));
		
				            closepanel.add(lblTags);
				            // Add close button
				            closepanel.add(closeButton);
				            dialogBox.setWidget(closepanel);
				            dialogBox.setWidth("631px");
				            dialogBox.center();
				            dialogBox.show();
							
						}
					});
					verticalPhotoPanel.add(image);
							
				}
				
			
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	public void drawNodeAndNeighbors(int person) {
		currentPerson = person;
		firstPhoto = 0;
		System.out.println("Requesting data for " + person);
		
		if (fren_ids.contains(person)){
		
		userprofileService.UserinJson(person,userid,new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				if (result != null) {
					FriendVisualization.addToGraph(theGraph, result);
					//frenshipbrowser.add(new HTML(result));
					
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});

		fillInfoPanelAndPicture(person);
		
		}
		else
		{
			System.out.println("More than Second list of Users ");
			fillInfoPanelAndPicture(person);
		}
		
		
	}
}
