package com.cis550.photozee.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.Cookies;


public class MyHistoryListener implements ValueChangeHandler<String> {

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		System.out.println("Current State : " + event.getValue());
	
		
		if (event.getValue().equals("login")){
    		RootPanel.get().clear();
    		RootPanel.get().add(Login.getInstance());
		}
		
		if (event.getValue().equals("register")){
    		RootPanel.get().clear();
    		RootPanel.get().add(Register.getInstance());
		}
		
		if (event.getValue().equals("homepage")){
    		RootPanel.get().clear();
    		RootPanel.get().add(new HomePage());
		}
		
		if (event.getValue().startsWith(new String("?searchphotos="))){
			RootPanel.get().clear();
    		RootPanel.get().add(new SearchPhotos());
    		//was changed -- nirty
		}
		
		if (event.getValue().startsWith("?uploadphoto=")){
			String strUserID = event.getValue().substring(13);
			int userID = Integer.parseInt(strUserID);
			RootPanel.get().clear();
    		RootPanel.get().add(new UploadPhoto());
    		// changed - nirty
		}
		
		if (event.getValue().startsWith("?frenbrowser=")){
			String strUserID = event.getValue().substring(13);
			int userID = Integer.parseInt(strUserID);
			RootPanel.get().clear();
    		RootPanel.get().add(new FriendhipBrowser());
		}
		
		if(event.getValue().startsWith(new String("photo?=")))
		{
			String photoid = event.getValue().substring(7);
			Integer photo_id = Integer.parseInt(photoid);
			/*DisplayPhoto photodisinstance = DisplayPhoto.getInstance(photo_id);
			RootPanel.get().clear();
    		RootPanel.get().add(photodisinstance);*/
		}
		
		if (event.getValue().startsWith("?profile=")) {
			String strUserID = event.getValue().substring(9);
			int userID = Integer.parseInt(strUserID);
			RootPanel.get().clear();
			RootPanel.get().add(new Profile(userID));
		}
		
		if (event.getValue().startsWith("addfriend")) {
			RootPanel.get().clear();
    		RootPanel.get().add(new AddFriend());
		}
		
		if (event.getValue().equals("logout-success")){
    		RootPanel.get().clear();
    		RootPanel.get().add(new Login());
		}
	}

}
