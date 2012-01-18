package com.cis550.photozee.client;

import java.util.ArrayList;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.reveregroup.gwt.imagepreloader.FitImage;
import com.google.gwt.user.client.ui.Composite;

public class DisplayPhoto extends Composite {
	
	private AbsolutePanel displayphoto = new AbsolutePanel();
	static private DisplayPhoto _instance = null;
	private final PhotoServiceAsync photoService = GWT.create(PhotoService.class);
	private final String Back;
	private final int userid = Integer.parseInt(Cookies.getCookie("userID"));;

	
	public DisplayPhoto(Photo photoid, String back){
		Back = back;

		initPage(photoid);
		initWidget(displayphoto);
		
		
		
		
		
	}

	public static DisplayPhoto getInstance(Photo photoid, int userID, String back){
        if(null == _instance) {
        	_instance = new DisplayPhoto(photoid,back);
        }
        return _instance;
	}

	private void initPage(final Photo photo) {
		
		
		final HorizontalPanel photoPanel = new HorizontalPanel();
		photoPanel.setSize("565px", "357px");
		displayphoto.setSize("631px", "540px");
		

		
		
		final Label captionLabel = new Label("");		
		captionLabel.setStyleName("h1");
		
		//final ScrollPanel tagscrollPanel = new ScrollPanel();
		
		
		//final FlowPanel tagflowPanel = new FlowPanel();		
		
		
		final Label uploadedDTlbl = new Label("");

		FitImage image = new FitImage();
		image.setUrl(photo.getUrl());
		image.setMaxSize(631, 360);
		photoPanel.add(image);
		captionLabel.setText(photo.getCaptions());
		uploadedDTlbl.setText("This Photo was uploaded at  "+photo.getUploaded_dt().toString());
		
		uploadedDTlbl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		displayphoto.add(uploadedDTlbl, 10, 407);
		uploadedDTlbl.setSize("565px", "18px");
		
		captionLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		displayphoto.add(captionLabel, 0, 10);
		captionLabel.setSize("575px", "27px");
		
		displayphoto.add(photoPanel, 33, 45);

		final ListBox scoreBox = new ListBox();
		scoreBox.addItem("1");
		scoreBox.addItem("2");
		scoreBox.addItem("3");
		scoreBox.addItem("4");
		scoreBox.addItem("5");
		displayphoto.add(scoreBox, 400, 481);
		scoreBox.setSize("104px", "36px");
		
		
		final TextBox tagBox = new TextBox();
		displayphoto.add(tagBox, 85, 481);
		tagBox.setSize("255px", "19px");
		
		Label lblAddTags = new Label("Add Tags*");
		displayphoto.add(lblAddTags, 10, 487);
		
		Label lblPleaseUse = new Label("* Please Use Commas to separate the Tags");
		displayphoto.add(lblPleaseUse, 32, 518);
		lblPleaseUse.setSize("294px", "22px");
		
		Label lblScore = new Label("Score ");
		displayphoto.add(lblScore, 356, 481);
		
		
		Label avgrating = new Label("Average Rating:" + photo.getAvg_score() + "  "+ "No of users Rated:" + photo.getNo_of_raters());
		displayphoto.add(avgrating, 33, 431);
		avgrating.setSize("565px", "16px");
		
		
		Button saveBtn = new Button("Save & Return");
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int score = scoreBox.getSelectedIndex();
				String tag = tagBox.getText();
				
				saveratings(photo.getPhoto_id(),score,tag);
				
			}
		});
		displayphoto.add(saveBtn, 510, 481);
		saveBtn.setSize("111px", "44px");
	}
	
	private void saveratings(int photoid,int score,String tags){
		
		photoService.tagAndScorePhoto(userid, photoid, tags,(score +1 ), new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				
				final DialogBox dialogBox = new DialogBox();
				
			    dialogBox.setGlassEnabled(true);
			    dialogBox.setAnimationEnabled(true);
			    VerticalPanel closepanel = new VerticalPanel();
	            Button closeButton = new Button(
	                    "close", new ClickHandler() {
	                      public void onClick(ClickEvent event) {
	                        dialogBox.hide(); 
	                        Go_back();
	                      }
	                    });
		
	            closepanel.add(new HTML("Your response has been saved."));
	            closepanel.add(closeButton);
	            dialogBox.setWidget(closepanel);
	            dialogBox.center();
	            dialogBox.show();
	            
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				displayphoto.add(new HTML("Sorry some Error - or you have already rated the score"));
			}
		});
		
	}
	
	private void Go_back(){
		if (Back.equals("home"))
		{
			RootPanel.get().clear();
      		RootPanel.get().add(new HomePage()); 
            History.newItem("homepage", true);
		}			
		else if (Back.equals("profile")){
			RootPanel.get().clear();
      		RootPanel.get().add(new Profile(Integer.parseInt(Cookies.getCookie("userID")))); 
            History.newItem("profile", true);
		}
		else if (Back.equals("frenbrowser")){
			RootPanel.get().clear();
      		RootPanel.get().add(FriendhipBrowser.getInstance()); 
            History.newItem("frenbrowser", true);
		}
		else if (Back.equals("search")){
			RootPanel.get().clear();
      		RootPanel.get().add(SearchPhotos.getInstance()); 
            History.newItem("?searchphotos="+userid, true);
		}
		
	}
}
