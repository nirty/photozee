package com.cis550.photozee.client;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.client.model.UserProfile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.reveregroup.gwt.imagepreloader.FitImage;

public class HomePage extends Composite {
	
	private AbsolutePanel homepage = new AbsolutePanel();
	private final UserProfileServiceAsync userProfileService = GWT.create(UserProfileService.class);
	static private HomePage _instance = null;
	private int user_id = getUser();
	VerticalPanel frenRequestsPanel = new VerticalPanel();
	static final private ArrayList<Integer> chosen_circles = new ArrayList<Integer>();
	static final private ArrayList<AbsolutePanel> requestWidgetList = new  ArrayList<AbsolutePanel>();
	
	final FlowPanel updatesPanel = new FlowPanel();
	
	private final HomePageServiceAsync homepageService = GWT.create(HomePageService.class);
	
	public HomePage(){
		// Start making page
		initPage();
		initWidget(homepage);
		homepage.setSize("1200px", "5000px");
		
		// Grab user credentials
		String strUserID = Cookies.getCookie("userID");
		final int userID = Integer.parseInt(strUserID);
		
	
		
		// ******* HEADER PANEL *******
		
		
		HorizontalPanel headerPanel = new HorizontalPanel();
		homepage.add(headerPanel, 0, 0);
		headerPanel.setSize("1000px", "62px");
		
		final Label lblWelcomeUser = new Label();
		
		
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
		homepage.add(welcomePanel, 0, 61);
		welcomePanel.setSize("1000px", "62px");
		
		Label lblWelcome = new Label("Welcome to Photozee!");
		lblWelcome.setStyleName("gwt-PageTitle");
		welcomePanel.add(lblWelcome);
		welcomePanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
		welcomePanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
		// *******************
		
		// *******FRIEND RECOMMENDATIONS PANEL
		final FlowPanel friendRecs = new FlowPanel();
		homepage.add(friendRecs, 840, 121);
		friendRecs.setSize("160px", "2951px");
		
		Label lblFriendRecommendations = new Label("Friend Recommendations");
		friendRecs.add(lblFriendRecommendations);
		lblFriendRecommendations.setStyleName("gwt-smallSubHeading");
		
		Label lblSpacer = new Label("");
		friendRecs.add(lblSpacer);
		lblSpacer.setSize("160px", "25px");
		
		homepageService.getFriendRecs(user_id, new AsyncCallback<List<User>>() {
			public void onFailure(Throwable caught) {
				
			}
			public void onSuccess(List<User> recs) {
				for (int i = 0; i < recs.size(); i++) {
					final User currUser = recs.get(i);
					Hyperlink friendRec = new Hyperlink(currUser.getF_name() + " " + currUser.getL_name(), "?profile=" + currUser.getUser_id());
					Label lblSpacer = new Label("");
					lblSpacer.setSize("160px", "25px");
					friendRecs.add(friendRec);
					friendRecs.add(lblSpacer);
				}
			}
		});
		
		//******** TOP SCORING PHOTOS PANEL
		HorizontalPanel photoLabelPanel = new HorizontalPanel();
		homepage.add(photoLabelPanel, 0, 121);
		photoLabelPanel.setSize("837px", "35px");
		
		final HorizontalPanel photoPanel = new HorizontalPanel();
		homepage.add(photoPanel, 0, 155);
		photoPanel.setSize("841px", "200px");
		
		Label lblTopScoringPhotos = new Label("Top Scoring Photos");
		lblTopScoringPhotos.setStyleName("gwt-SubHeading");
		photoLabelPanel.add(lblTopScoringPhotos);
		lblTopScoringPhotos.setWidth("841px");
		
		homepageService.getTopPhotos(userID, new AsyncCallback<List<Photo>>() {
			public void onFailure(Throwable caught) {
				
			}
			public void onSuccess(List<Photo> result) {
				for (final Photo currPhoto : result) {
					Image image = new Image(currPhoto.getUrl());
					image.setSize("150px", "150px");
					image.addClickHandler(new ClickHandler() {
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
				            //FitImage image = new FitImage();
							//image.setUrl(currPhoto.getUrl());
							//image.setMaxSize(350, 350);
							
							// Add image
							closepanel.add(new DisplayPhoto(currPhoto,"home"));
							// Add tags
				            //closepanel.add(lblTags);
				            // Add field to accept new tags
				            //Label lblAddTags = new Label("Add new tags:");
				          //  TextBox newTags = new TextBox();
				            // Add submit button
				            Button submit = new Button("Submit", new ClickHandler() {
				            	public void onClick(ClickEvent event) {
				            		
				            	}
				            });
				            // Add close button
				            closepanel.add(closeButton);
				            dialogBox.setWidget(closepanel);
				            dialogBox.setWidth("631px");
				            dialogBox.center();
				            dialogBox.show();
						}
					} );
					photoPanel.add(image);
				}
			}
		});
		//********
		
		//******** UPDATES PANEL
		HorizontalPanel updatesLabelPanel = new HorizontalPanel();
		homepage.add(updatesLabelPanel, 0, 354);
		updatesLabelPanel.setSize("450px", "35px");
		
		Label lblRecentUpdates = new Label("Recent Updates");
		lblRecentUpdates.setStyleName("gwt-SubHeading");
		updatesLabelPanel.add(lblRecentUpdates);
		lblRecentUpdates.setSize("397px", "31px");
		
		final FlowPanel updatesPanel = new FlowPanel();
		homepage.add(updatesPanel, 10, 404);
		updatesPanel.setSize("500px", "2468px");
		
		
		homepage.add(frenRequestsPanel, 516, 354);
		frenRequestsPanel.setSize("318px", "408px");

		homepageService.getUpdates(userID, new AsyncCallback<List<Photo>>() {
			public void onFailure(Throwable caught) {
				
			}
			public void onSuccess(List<Photo> result) {
				for (int i = 0; i < result.size(); i++) {
					final Photo currPhoto = result.get(i);
					final User currUploader = currPhoto.getUploader();
					
					// Added uploader label
					Hyperlink uploader = new Hyperlink(currUploader.getF_name() + " " + currUploader.getL_name(), "?profile=" + currUploader.getUser_id());
					uploader.setStyleName("gwt-HyperlinkLeft");
					updatesPanel.add(uploader);
					
					// Add timestamp - Format DateTime appropriately
					SimpleDateFormat dateFmt = new SimpleDateFormat("EEEE, MMMM d, yyyy");
					String strUpDate = dateFmt.format(currPhoto.getUploaded_dt());
					SimpleDateFormat timeFmt = new SimpleDateFormat("hh:mm a");
					String strUpTime = timeFmt.format(currPhoto.getUploaded_dt());
					Label lblTime = new Label("uploaded this photo on " + strUpDate + " at " + strUpTime);
					lblTime.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					updatesPanel.add(lblTime);
					
					// Get photo tags
					String tags = "";
					List<Tag> tagList = currPhoto.getTags();
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
					
					// Add photo
					Image image = new Image(currPhoto.getUrl());
					image.setSize("300px", "300px");
					image.addClickHandler(new ClickHandler() {
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
				            //FitImage image = new FitImage();
							//image.setUrl(currPhoto.getUrl());
							//image.setMaxSize(350, 350);
							
							// Add image
							closepanel.add(new DisplayPhoto(currPhoto,"home"));
							// Add tags
				            closepanel.add(lblTags);
				            // Add field to accept new tags
				            //Label lblAddTags = new Label("Add new tags:");
				          //  TextBox newTags = new TextBox();
				            // Add submit button
				            Button submit = new Button("Submit", new ClickHandler() {
				            	public void onClick(ClickEvent event) {
				            		
				            	}
				            });
				            // Add close button
				            closepanel.add(closeButton);
				            dialogBox.setWidget(closepanel);
				            dialogBox.setWidth("631px");
				            dialogBox.center();
				            dialogBox.show();
							/*String hash = "photo?="+photoid;
							History.newItem(hash, true);	*/	
							
							/*final DialogBox dialogBox = new DialogBox();
							
						    dialogBox.setGlassEnabled(true);
						    dialogBox.setAnimationEnabled(true);
						    VerticalPanel closepanel = new VerticalPanel();
				            Button closeButton = new Button(
				                    "Close", new ClickHandler() {
				                      public void onClick(ClickEvent event) {
				                        dialogBox.hide(); 		                        
				                      }
				                    });
				            FitImage image = new FitImage();
							image.setUrl(currPhoto.getUrl());
							image.setMaxSize(350, 350);
							
							// Add image
							closepanel.add(image);
							// Add tags
				            closepanel.add(lblTags);
				            // Add field to accept new tags
				            Label lblAddTags = new Label("Add new tags:");
				            TextBox newTags = new TextBox();
				            // Add submit button
				            Button submit = new Button("Submit", new ClickHandler() {
				            	public void onClick(ClickEvent event) {
				            		
				            	}
				            });
				            // Add close button
				            closepanel.add(closeButton);
				            dialogBox.setWidget(closepanel);
				            dialogBox.center();
				            dialogBox.show();*/
						}
					} );
					updatesPanel.add(image);
					
					// Add caption
					Label lblCaption = new Label("Caption: " + currPhoto.getCaptions());
					lblCaption.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					updatesPanel.add(lblCaption);
					
					// Add tags to homepage
					lblTags.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					updatesPanel.add(lblTags);
					
					// Add spacer
					Label lblSpace = new Label("");
					updatesPanel.add(lblSpace);
					lblSpace.setSize("500px", "40px");
					
					
				}
			}
		});
		//********
		
		userProfileService.getUserProfile(userID,userID, new AsyncCallback<UserProfile>() {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
			}
			public void onSuccess(final UserProfile user) {
				get_FrenRequests(user);
				
				Cookies.setCookie("userNAME","Hello, "+ user.getF_name()+"!");
				lblWelcomeUser.setText(Cookies.getCookie("userNAME"));
				}
			}
			);
		
	}

	public static HomePage getInstance(){
        if(null == _instance) {
        	_instance = new HomePage();
        }
        return _instance;
	}

	private void initPage() {	
		
		
	}
	
	private Integer getUser(){
		String userID = Cookies.getCookie("userID");
		return (Integer)Integer.parseInt(userID);		
	}
	
	private void get_FrenRequests(final UserProfile cur_user){
		
		userProfileService.FriendRequestRecieved(user_id, new AsyncCallback<List<FriendMapping>>() {
			
			@Override
			public void onSuccess(List<FriendMapping> result) {
				
				if(result == null){
					//friendRequestsSentPanel.add(new HTML("null"));
				}
				else {
					frenRequestsPanel.clear();
					
					Label lblRecentUpdates = new Label("Friend Requests Recieved");
					lblRecentUpdates.setStyleName("gwt-SubHeading");
					frenRequestsPanel.add(lblRecentUpdates);
					for(FriendMapping friend :result){
						
						AbsolutePanel requestWidget = new AbsolutePanel();
						 requestWidget.add(new HTML(friend.getFriend_fname()+ " "+ friend.getFriend_lname()));
						 Button addFriend = new Button("Confirm");
						 final int friend_id = friend.getFriend_id();
						 addFriend.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								addFriend(friend_id, cur_user);
								
							}
						});
						 requestWidget.add(addFriend);
						frenRequestsPanel.add(requestWidget);
						requestWidgetList.add(requestWidget);
						//System.out.println(friend.getFriend_fname());
					}
				
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void addFriend(int friend_id,final UserProfile curuser){
		
	final DialogBox dialogBox = new DialogBox();
	final int friendID = friend_id;
    dialogBox.setGlassEnabled(true);
    dialogBox.setAnimationEnabled(true);
    VerticalPanel closepanel = new VerticalPanel();
    
    FlowPanel newCirclePanel = new FlowPanel();
    Label lblNewCircle = new Label("New Circle: ");
    final TextBox newCircleBox = new TextBox();
    newCirclePanel.add(lblNewCircle);
    newCirclePanel.add(newCircleBox);
    
    closepanel.add(new HTML("<h4>Choose circle:</h4>"));
    Button closeButton = new Button(
            "Close", new ClickHandler() {
              public void onClick(ClickEvent event) {
                dialogBox.hide(); 		                        
              }
            });
    
    Button addFriendButton = new Button(
            "Add Friend", new ClickHandler() {
              public void onClick(ClickEvent event) {
            	  
            	if(chosen_circles.size()== 0 && newCircleBox.getText().length() < 1){
            		  final DialogBox dialogBox = new DialogBox();
  					
  				    dialogBox.setGlassEnabled(true);
  				    VerticalPanel closepanel = new VerticalPanel();
  		            Button closeButton = new Button(
  		                    "Close", new ClickHandler() {
  		                      public void onClick(ClickEvent event) {
  		                        dialogBox.hide(); 		                        
  		                      }
  		                    });
  	
  		            Button submit = new Button("Okay", new ClickHandler() {
  		            	public void onClick(ClickEvent event) {
  		            		
  		            	}
  		            });
  		            // Add close button
  		            closepanel.add(new HTML("Please choose a circle to add."));
  		            closepanel.add(closeButton);
  		            dialogBox.setWidget(closepanel);
  		            dialogBox.setWidth("631px");
  		            dialogBox.center();
  		            dialogBox.show();
            	}
            	else{
            	  
            	  submitFriendConfirmation(friendID, dialogBox, curuser, newCircleBox); 
            	}
              }
            });
   
    
    for(Circle circle:curuser.getCircles()){
   
    	CheckBox checkBox = new CheckBox(circle.getCircle_name().toString());
    	final Integer circle_id = circle.getCircle_id();
    	checkBox.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			circleschosen(circle_id);

			}
    	});
   
    closepanel.add(checkBox);
    }
    
    
    closepanel.add(newCirclePanel);

    HorizontalPanel closandSave = new HorizontalPanel();
    
    closandSave.add(closeButton);
    closandSave.add(addFriendButton);
    closepanel.add(closandSave);
    dialogBox.setWidget(closepanel);
    dialogBox.center();
    
    dialogBox.show();

	}
	void circleschosen(Integer circleid) {
	
	if (chosen_circles.contains(circleid))
		chosen_circles.remove(circleid);
	else
		chosen_circles.add(circleid);
	}

	private void submitFriendConfirmation(int friendID,final DialogBox dia, final UserProfile user, final TextBox newCircleBox){
	
	if (newCircleBox.getText().length() > 1) {
		userProfileService.CreateCircle(user.getUser_id(), newCircleBox.getText(), new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				
			}
			public void onSuccess(Integer result) {
				chosen_circles.add(result);
			}
		});
	}
		
	userProfileService.confirmFriend(user_id, chosen_circles, friendID, new AsyncCallback<Boolean>(){

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Boolean result) {
			
			if(result){
				dia.hide();
				RootPanel.get().clear();
	    		RootPanel.get().add(new HomePage());
			}
			else{
				dia.add(new HTML("User Confirmation Failed"));
			}
			
			
		}
		
	});

	}
	}


