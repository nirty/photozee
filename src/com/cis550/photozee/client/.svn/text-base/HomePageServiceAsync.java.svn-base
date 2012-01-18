package com.cis550.photozee.client;

import java.util.List;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.client.model.UserProfile;
import com.cis550.photozee.server.dataaccess.UserDB;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HomePageServiceAsync {

	void getUsers(AsyncCallback<List<User>> callback);
	
	public void getUserName(String userID, AsyncCallback<String> callback);
	public void getFriendRecs(int userID, AsyncCallback<List<User>> callback);
	public void getUpdates(int userID, AsyncCallback<List<Photo>> callback);
	public void getTopPhotos(int userID, AsyncCallback<List<Photo>> callback);
}
