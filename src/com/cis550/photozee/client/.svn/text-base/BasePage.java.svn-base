package com.cis550.photozee.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.cis550.photozee.client.model.Photo;

public class BasePage extends Composite {
	public BasePage() {
		
		AbsolutePanel homepage = new AbsolutePanel();
		initWidget(homepage);
		homepage.setSize("1000px", "5000px");
		
		// ******* HEADER *******
		HorizontalPanel headerPanel = new HorizontalPanel();
		homepage.add(headerPanel, 0, 0);
		headerPanel.setSize("1000px", "62px");
		
		Button btnHomePage = new Button("Home Page");
		btnHomePage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//History.newItem("homepage", true);
			}
		});
		headerPanel.add(btnHomePage);
		btnHomePage.setSize("106px", "30px");
		headerPanel.setCellHorizontalAlignment(btnHomePage, HasHorizontalAlignment.ALIGN_CENTER);
		headerPanel.setCellVerticalAlignment(btnHomePage, HasVerticalAlignment.ALIGN_MIDDLE);
		
		Button btnMyProfile = new Button("My Profile");
		btnMyProfile.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//History.newItem("?profile=" + userID, true);
			}
		});
		headerPanel.add(btnMyProfile);
		btnMyProfile.setSize("106px", "30px");
		headerPanel.setCellVerticalAlignment(btnMyProfile, HasVerticalAlignment.ALIGN_MIDDLE);
		headerPanel.setCellHorizontalAlignment(btnMyProfile, HasHorizontalAlignment.ALIGN_CENTER);
		
		Button btnSearch = new Button("Search Photos");
		btnSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//History.newItem("?searchphotos=" + userID, true);
			}
		});
		headerPanel.add(btnSearch);
		btnSearch.setSize("106px", "30px");
		headerPanel.setCellVerticalAlignment(btnSearch, HasVerticalAlignment.ALIGN_MIDDLE);
		headerPanel.setCellHorizontalAlignment(btnSearch, HasHorizontalAlignment.ALIGN_CENTER);
		
		Button btnUpload = new Button("Upload a Photo");
		btnUpload.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//History.newItem("?uploadphoto=" + userID, true);
			}
		});
		headerPanel.add(btnUpload);
		btnUpload.setSize("106px", "30px");
		headerPanel.setCellHorizontalAlignment(btnUpload, HasHorizontalAlignment.ALIGN_CENTER);
		headerPanel.setCellVerticalAlignment(btnUpload, HasVerticalAlignment.ALIGN_MIDDLE);
		
		Button btnBrowseFriends = new Button("Browse Friends");
		btnBrowseFriends.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//History.newItem("?frenbrowser=" + userID, true);
			}
		});
		headerPanel.add(btnBrowseFriends);
		btnBrowseFriends.setSize("106px", "30px");
		headerPanel.setCellVerticalAlignment(btnBrowseFriends, HasVerticalAlignment.ALIGN_MIDDLE);
		headerPanel.setCellHorizontalAlignment(btnBrowseFriends, HasHorizontalAlignment.ALIGN_CENTER);
		
		HorizontalPanel welcomePanel = new HorizontalPanel();
		homepage.add(welcomePanel, 0, 61);
		welcomePanel.setSize("1000px", "62px");
		
		Label lblWelcome = new Label("Aldous Huxley");
		lblWelcome.setStyleName("gwt-PageTitle");
		welcomePanel.add(lblWelcome);
		welcomePanel.setCellVerticalAlignment(lblWelcome, HasVerticalAlignment.ALIGN_MIDDLE);
		welcomePanel.setCellHorizontalAlignment(lblWelcome, HasHorizontalAlignment.ALIGN_CENTER);
		
		TabPanel tabPanel = new TabPanel();
		homepage.add(tabPanel, 47, 199);
		tabPanel.setSize("943px", "2661px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		homepage.add(horizontalPanel, 0, 123);
		horizontalPanel.setSize("1000px", "44px");
		
		Button btnAddAsFriend = new Button("Add as Friend");
		horizontalPanel.add(btnAddAsFriend);
		horizontalPanel.setCellVerticalAlignment(btnAddAsFriend, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setCellHorizontalAlignment(btnAddAsFriend, HasHorizontalAlignment.ALIGN_CENTER);
	}
}
