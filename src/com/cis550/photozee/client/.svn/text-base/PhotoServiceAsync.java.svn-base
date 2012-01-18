package com.cis550.photozee.client;

import java.util.List;

import com.cis550.photozee.client.model.Photo;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PhotoServiceAsync {

	void tagAndScorePhoto(int tagnscorer_id, int photoid, String tags,
			int score, AsyncCallback<Boolean> callback);

	void getPhoto(int photoid, AsyncCallback<Photo> callback);

	void searchPhotos(String searchString,int requester_id, AsyncCallback<List<Photo>> callback);

}
