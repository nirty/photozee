package com.cis550.photozee.client;

import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.client.model.UserProfile;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserProfileServiceAsync {
	
	public void getUserProfile(int user_id,int requester_id,AsyncCallback<UserProfile> callback);

	void uploadPhoto(int user_id, String url, String caption, String tag,
			int index, ArrayList<Integer> visibilitylist,
			AsyncCallback<UserProfile> callback);

	void getCircleid(int user_id, AsyncCallback<ArrayList<Circle>> callback);

	void getUserid(int user_id, AsyncCallback<ArrayList<User>> callback);

	void getFriends(int user_id, int requester_id, AsyncCallback<ArrayList<Integer>> callback);

	void UserinJson(int user_id, int requester_id, AsyncCallback<String> callback);

	void CreateCircle(int user_id, String Circle_name,
			AsyncCallback<Integer> callback);

	void addFriend(int user_id, List<Integer> circle_ids, String friend_email,
			AsyncCallback<FriendMapping> callback);
	
	void FriendRequestsSent(int user_id,
			AsyncCallback<List<FriendMapping>> callback);

	void FriendRequestRecieved(int user_id,
			AsyncCallback<List<FriendMapping>> callback);

	void confirmFriend(int user_id, List<Integer> circle_ids, int friend_id,
			AsyncCallback<Boolean> callback);

	void addInterests(int userID, String strInterests,
			AsyncCallback<Boolean> callback);

}
