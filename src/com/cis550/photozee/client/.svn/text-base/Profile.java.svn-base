package com.cis550.photozee.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.cis550.photozee.client.model.UserProfile;
import com.cis550.photozee.server.dataaccess.UserProfileDB;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.reveregroup.gwt.imagepreloader.FitImage;

public class Profile extends Composite {
	private AbsolutePanel profile = new AbsolutePanel();
	static private Profile _instance = null;
	private final UserProfileServiceAsync userProfileService = GWT.create(UserProfileService.class);
	private Integer userID = Integer.parseInt(Cookies.getCookie("userID"));;
	private Integer UserIDofProfile;
	final VerticalPanel frenRequestsPanel = new VerticalPanel();
	static final private ArrayList<Integer> chosen_circles = new ArrayList<Integer>();
	static final private ArrayList<AbsolutePanel> requestWidgetList = new  ArrayList<AbsolutePanel>();
	final private HorizontalPanel welcomePanel = new HorizontalPanel();
	final private Image friendIcon = new Image("http://www.veryicon.com/icon/ico/Business/Pretty%20Office%203/Add%20Male%20User.ico");
	final FlowPanel interestsPanel = new FlowPanel();
	public Profile(int profileid){
		UserIDofProfile = profileid;
		initPage();
		initWidget(profile);
	}

	public static Profile getInstance(int requester_id){
        //if(null == _instance) {
        	_instance = new Profile(requester_id);
        //}
        return _instance;
	}

	private void initPage() {
		profile.setSize("1200px", "900px");
		
		HorizontalPanel headerPanel = new HorizontalPanel();
		profile.add(headerPanel, 0, 0);
		headerPanel.setSize("1000px", "62px");
		
		
		
		// Grab user credentials
		String strMyUserID = Cookies.getCookie("userID");
		final int myUserID = Integer.parseInt(strMyUserID);
		
		Label lblWelcome = new Label();
		lblWelcome.setText(Cookies.getCookie("userNAME"));
		lblWelcome.setStyleName("gwt-PageTitle");
		headerPanel.add(lblWelcome);
		headerPanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
		headerPanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
		
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
				History.newItem("?profile=" + myUserID, true);
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
		
		profile.add(welcomePanel, 0, 61);
		welcomePanel.setSize("1000px", "62px");
		
		final TabPanel tabPanel = new TabPanel();
		
		profile.add(tabPanel, 226, 152);
		tabPanel.setSize("900px", "900px");
		
		final ScrollPanel photoPanel = new ScrollPanel();
		tabPanel.add(photoPanel, "Photos", false);
		photoPanel.setSize("897px", "667px");
		
		final AbsolutePanel circlesPanel = new AbsolutePanel();
		tabPanel.add(circlesPanel, "Friends and Circles", false);
		circlesPanel.setSize("735px", "469px");
		
		ScrollPanel circlesScroll = new ScrollPanel();
		circlesPanel.add(circlesScroll, 0, 0);
		circlesScroll.setSize("302px", "469px");
		
		final VerticalPanel circleList = new VerticalPanel();
		circleList.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		circlesScroll.setWidget(circleList);
		circleList.setSize("300px", "100%");
		
		ScrollPanel usersScroll = new ScrollPanel();
		circlesPanel.add(usersScroll, 300, 0);
		usersScroll.setSize("435px", "469px");
		
		final VerticalPanel usersList = new VerticalPanel();
		usersList.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		usersScroll.setWidget(usersList);
		usersList.setSize("433px", "100%");
		
		
		tabPanel.add(interestsPanel, "Interests", false);
		interestsPanel.setSize("304px", "337px");
		
		final FlowPanel infoPanel = new FlowPanel();
		profile.add(infoPanel, 10, 152);
		infoPanel.setSize("210px", "488px");
		
		Label lblInformation = new Label("Information");
		lblInformation.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		lblInformation.setStyleName("gwt-smallSubHeading");
		infoPanel.add(lblInformation);
		
		Label label = new Label("");
		infoPanel.add(label);
		label.setSize("210px", "25px");
		//*********************************
		
			
				// invalid password but valid email address
		// Fetch all user details
		userProfileService.getUserProfile(UserIDofProfile,userID, new AsyncCallback<UserProfile>() {
		public void onFailure(Throwable caught) {
			// Show the RPC error message to the user
		}
		public void onSuccess(final UserProfile user) {
			// Display user name at center of page
			Label lblWelcome = new Label(user.getF_name() + " " + user.getL_name());
			lblWelcome.setStyleName("gwt-PageTitle");
			welcomePanel.add(lblWelcome);
			welcomePanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
			welcomePanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
			
			// Panel to hold add friend button or friends label
			HorizontalPanel friendPanel = new HorizontalPanel();
			profile.add(friendPanel, 0, 123);
			friendPanel.setSize("1000px", "44px");
			
		

			//----------------------
			//welcomePanel.add(new HTML("user ID "+userID.toString()));
			//welcomePanel.add(new HTML("UserIDofProfile ID "+UserIDofProfile.toString()));
			
		  if (userID.equals(UserIDofProfile))
		  {}
		  else{
			  System.out.println("userid = " + userID);
			  System.out.println("UserIDofProfile = " + UserIDofProfile);
			  ArrayList<Integer> list_of_frens = user.getFriendIdsofAllCircles();
			  
			  Boolean Friended = false;
			  
			  for(Integer frens: list_of_frens){
				  if(userID.equals(frens))
					 Friended = true;
			  }
			  
			  if(Friended){
						Image image = new Image("http://www.gettyicons.com/free-icons/103/pretty-office-3/png/256/accept_male_user_256.png");
						image.setSize("60px", "60px");
						
						welcomePanel.add(image);
						welcomePanel.setCellVerticalAlignment(image, HasVerticalAlignment.ALIGN_MIDDLE);
						welcomePanel.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_CENTER);
						//addFriend(user.getUser_id(),user);
			  } else{
				friendIcon.setSize("60px", "60px");
				friendIcon.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						addFriend(user.getEmail());
						
					}
				});
				welcomePanel.add(friendIcon);
				welcomePanel.setCellVerticalAlignment(friendIcon, HasVerticalAlignment.ALIGN_MIDDLE);
				welcomePanel.setCellHorizontalAlignment(friendIcon, HasHorizontalAlignment.ALIGN_CENTER);
				//addFriend(user.getUser_id(),user);
			}
			}
			
			
			// Add User Details to Information Panel
			Label space = new Label("");
			space.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			Label name = new Label("Name: " + user.getF_name() + " " + user.getL_name());
			name.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			String strType = "";
			if (user.getType().equals("STUD")) {
				strType = "Student";
			} else if (user.getType().equals("PROF")) {
				strType = "Professor";
			} else {
				strType = "Other";
			}
			Label type = new Label("Account Type: " + strType);
			type.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			Label age = new Label("Age: " + user.getAge());
			age.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			Label email = new Label("Email: " + user.getEmail());
			email.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			Label add = new Label("Address: " + user.getAddress());
			add.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			String strGender = "";
			if (user.getGender().equals("M")) {
				strGender = "Male";
			} else {
				strGender = "Female";
			}
			Label gender = new Label("Gender: " + strGender);
			gender.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			SimpleDateFormat dateFmt = new SimpleDateFormat("MMMM d, yyyy");
			String strDOB = dateFmt.format(user.getDob());
			Label dob = new Label("Birthday: " + strDOB);
			dob.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			
			infoPanel.add(space);
			infoPanel.add(name);
			infoPanel.add(type);
			infoPanel.add(age);
			infoPanel.add(email);
			infoPanel.add(add);
			infoPanel.add(gender);
			infoPanel.add(dob);
			
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
				Label gradYear = new Label("Graduation Year: " + strGradYear);
				gradYear.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
				
				infoPanel.add(gpaLabel);
				infoPanel.add(majorLabel);
				infoPanel.add(gradYear);
				
				
			}
			
			
			// Add interests
			Label lblInterests = new Label("General Interests:");
			interestsPanel.add(lblInterests);
			List<String> interests = user.getInterests();
			for (String interest : interests) {
				interestsPanel.add(new Label(interest));
				Label lblSpace = new Label("");
				//space.setHeight("20px");
				interestsPanel.add(lblSpace);
			}
			
			
			if(userID.equals(UserIDofProfile))
			{
			
			Label addInterests = new Label("Add more interests: ");
			interestsPanel.add(addInterests);
			final TextBox interestsBox = new TextBox();
			interestsPanel.add(interestsBox);
			Button submitInterests = new Button("Submit", new ClickHandler() {
				public void onClick(ClickEvent event) {
					if (interestsBox.getText().length() > 0) {
						
						userProfileService.addInterests(userID, interestsBox.getText(), new AsyncCallback<Boolean>() {
					
							public void onFailure(Throwable error) {
							
							}
							
				
							public void onSuccess(Boolean result) {
								interestsBox.setText("");
								getInterests();
								}});
					
					}
				}
			});
			interestsPanel.add(submitInterests);
			
			}
			
			for (Circle circle: user.getCircles())
			{
				
				final List<FriendMapping> friendmappingList = circle.getFriend_maps();
				
				// add to circles Panel
				Label circleLabel = new Label(circle.getCircle_name());
				
				circleLabel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						usersList.clear();
						for(FriendMapping friendmap: friendmappingList){
							Image image = new Image("http://www.penn-olson.com/wp-content/uploads/2009/11/facebook-avatar.png");
							image.setSize("50px", "50px");
							//List<FriendMapping> FriendMaps = circle.getFriend_maps();
							
							Hyperlink friendlink = new Hyperlink(friendmap.getFriend_fname() + " " +friendmap.getFriend_lname(), "?profile=" + friendmap.getFriend_id());
							Label email = new Label(friendmap.getFriend_email());
							
							VerticalPanel friendWidget = new VerticalPanel();
							friendWidget.add(image);
							friendWidget.add(friendlink);
							friendWidget.add(email);
							
							usersList.add(friendWidget);
							usersList.setWidth("433px");
						
						}
						
					}
				});
				Image image = new Image("http://wicits.uww.edu/courses/images/stories/circle_icon.png");
				image.setSize("50px", "50px");
				image.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						usersList.clear();
						for(FriendMapping friendmap: friendmappingList){
							Image image = new Image("http://www.penn-olson.com/wp-content/uploads/2009/11/facebook-avatar.png");
							image.setSize("50px", "50px");
						
							
							Hyperlink friendlink = new Hyperlink(friendmap.getFriend_fname() + " " +friendmap.getFriend_lname(), "?profile=" + friendmap.getFriend_id());
							Label email = new Label(friendmap.getFriend_email());
							
							VerticalPanel friendWidget = new VerticalPanel();
							friendWidget.add(image);
							friendWidget.add(friendlink);
							friendWidget.add(email);						
							usersList.add(friendWidget);
							usersList.setWidth("433px");
							
							
						}
						
					}
				});
				VerticalPanel circleWidget = new VerticalPanel();
				
				circleWidget.add(image);
				circleWidget.add(circleLabel);
				
				
				circleList.add(circleWidget);	
				circleList.setWidth("300px");
				circleList.setHeight("70px");
				
				circlesPanel.add(circleList);
				
			}
			
			// Add Photos to the page
			
			
			 List<Photo> listofphotos = user.getPhotos();
			 Iterator<Photo> itr = listofphotos.iterator();
			 FlowPanel picflo = new FlowPanel();
			 
			 Integer height = 429;
			 while(itr.hasNext()){
				 final Photo photo = itr.next();
				 final String photoid = Integer.toString(photo.getPhoto_id());
				 
	
				 Image image = new Image( photo.getUrl());
				 image.setSize("280px", "280px");
				 
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
						closepanel.add(new DisplayPhoto(photo,"profile"));
	
			            closepanel.add(lblTags);
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
			                    "close", new ClickHandler() {
			                      public void onClick(ClickEvent event) {
			                        dialogBox.hide(); 		                        
			                      }
			                    });
			            FitImage image = new FitImage();
						image.setUrl(photo.getUrl());
						image.setMaxSize(350, 350);
						 
				
			            closepanel.add(image);
			            closepanel.add(closeButton);
			            dialogBox.setWidget(closepanel);
			            dialogBox.center();
			            dialogBox.show();*/
					}
				} );
				 
				 //link.getElement().getFirstChild().appendChild(image.getElement());
				 
				 picflo.add(image);
				 		
			    height = height + 200;
			 }
			 photoPanel.add(picflo);
			 tabPanel.selectTab(0);
			
		
			
			HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
			profile.add(horizontalPanel_1, 0, 640);
			horizontalPanel_1.setSize("279px", "250px");
			
			profile.add(frenRequestsPanel, 0, 450);
			
			}
			
			});
	}
	
	private void getInterests(){
		
		userProfileService.getUserProfile(UserIDofProfile,userID, new AsyncCallback<UserProfile>() {
		
			public void onFailure(Throwable caught){
				
			}
			

			public void onSuccess(UserProfile result) {
				interestsPanel.clear();
				Label lblInterests = new Label("General Interests:");
				interestsPanel.add(lblInterests);
				List<String> interests = result.getInterests();
				for (String interest : interests) {
					interestsPanel.add(new Label(interest));
					Label lblSpace = new Label("");
					interestsPanel.add(lblSpace);
				}
				
				Label addInterests = new Label("Add more interests: ");
				interestsPanel.add(addInterests);
				final TextBox interestsBox = new TextBox();
				interestsPanel.add(interestsBox);
				Button submitInterests = new Button("Submit", new ClickHandler() {
					public void onClick(ClickEvent event) {
						if (interestsBox.getText().length() > 0) {
							
							userProfileService.addInterests(userID, interestsBox.getText(), new AsyncCallback<Boolean>() {
						
								public void onFailure(Throwable error) {
								
								}
								
					
								public void onSuccess(Boolean result) {
									interestsBox.setText("");
									getInterests();
									}});
						
						}
					}
				});
				interestsPanel.add(submitInterests);
			}
		});
		
		
	}
	
	
	
	

	private void addFriend(final String email){
		
		userProfileService.getCircleid(userID, new AsyncCallback<ArrayList<Circle>>() {
			
		
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onSuccess(ArrayList<Circle> result) {
				// TODO Auto-generated method stub
				
			
		
		final DialogBox dialogBox = new DialogBox();
	    dialogBox.setGlassEnabled(true);
	    dialogBox.setAnimationEnabled(true);
	    VerticalPanel closepanel = new VerticalPanel();
	    
	    closepanel.add(new HTML("<h4>Choose a circle: </h4>"));
	    Button closeButton = new Button(
	            "Close", new ClickHandler() {
	              public void onClick(ClickEvent event) {
	                dialogBox.hide(); 		                        
	              }
	            });
	    
	    FlowPanel newCirclePanel = new FlowPanel();
	    Label lblNewCircle = new Label("New Circle: ");
	    final TextBox newCircleBox = new TextBox();
	    newCirclePanel.add(lblNewCircle);
	    newCirclePanel.add(newCircleBox);
	    
	    Button addFriendButton = new Button(
	            "Add Friend", new ClickHandler() {
	              public void onClick(ClickEvent event) {
	            	  System.out.println(newCircleBox.getText());
	            	  System.out.println(chosen_circles.size());
	            	  submitFriendConfirmation(dialogBox, email, newCircleBox); 		                        
	              }
	            });
	    
	    for(Circle circle:result){
	   
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
	    
	    Label lblSpace = new Label("");
	    lblSpace.setHeight("15px");
	    closepanel.add(lblSpace);
	    
	    HorizontalPanel closandSave = new HorizontalPanel();
	    
	    closandSave.add(closeButton);
	    closandSave.add(addFriendButton);
	    closepanel.add(closandSave);
	    dialogBox.setWidget(closepanel);
	    dialogBox.center();
	    
	    dialogBox.show();
			}
		});

		}
		void circleschosen(Integer circleid) {
		
		if (chosen_circles.contains(circleid))
			chosen_circles.remove(circleid);
		else
			chosen_circles.add(circleid);
		
		/*StringBuilder st = new StringBuilder();
		for(Integer cir:chosen_circles){
			st.append(cir.toString());
		}
		frenRequestsPanel.add(new HTML(st.toString()));*/
		}

		private void submitFriendConfirmation(final DialogBox dia, final String email, final TextBox newCircle) {
			// Construct notification dialog box
			final DialogBox dialogBox = new DialogBox();
		    dialogBox.setGlassEnabled(true);
		    final VerticalPanel closepanel = new VerticalPanel();
            Button closeButton = new Button(
                    "Okay", new ClickHandler() {
                      public void onClick(ClickEvent event) {
                        dialogBox.hide(); 		                        
                      }
                    });
            closepanel.add(closeButton);
            dialogBox.setWidget(closepanel);
            dialogBox.setWidth("631px");
            dialogBox.center();
			if(chosen_circles.size() == 0 && newCircle.getText().length() < 1){
				closepanel.add(new HTML("You must choose a circle. Please try again."));
	            dialogBox.show();
			} else if (chosen_circles.size() > 0 && newCircle.getText().length() < 1) {
				userProfileService.addFriend(userID, chosen_circles, email , new AsyncCallback<FriendMapping>() {
				public void onSuccess(FriendMapping result) {
					if(result == null || result.getFriend_fname() == null || result.getFriend_lname() == null || result.getFriend_id() == 0){
						closepanel.add(new HTML("Email not found. Please try again."));
						dialogBox.show();
					} else{		
						closepanel.add(new HTML("Friend request sent to "+ result.getFriend_fname() + " " + result.getFriend_lname()));
						dialogBox.show();
						welcomePanel.remove(friendIcon);
					}
				}
				public void onFailure(Throwable caught) {
					closepanel.add(new HTML("Error in processing request. Please try again."));
					dialogBox.show();
				}
			});
			} else {
				userProfileService.CreateCircle(userID, newCircle.getText(), new AsyncCallback<Integer>() {
					public void onFailure(Throwable caught) {
						
					}
					public void onSuccess(Integer result) {
						chosen_circles.add(result);
						userProfileService.addFriend(userID, chosen_circles, email , new AsyncCallback<FriendMapping>() {
							@Override
							public void onSuccess(FriendMapping result) {
								if(result == null || result.getFriend_fname() == null || result.getFriend_lname() == null || result.getFriend_id() == 0){
									closepanel.add(new HTML("Email not found. Please try again."));
									dialogBox.show();
								}
								else {
									closepanel.add(new HTML("Friend request sent to "+ result.getFriend_fname() + " " + result.getFriend_lname()));
									dialogBox.show();
									welcomePanel.remove(friendIcon);
								}
							}
							public void onFailure(Throwable caught) {
								closepanel.add(new HTML("Error in processing request. Please try again."));
								dialogBox.show();
							}
						});
					}
				});
			}
			dia.hide();
		}
}
