/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cis550.photozee.server;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.UserProfileService;
import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.client.model.UserProfile;
import com.cis550.photozee.server.dataaccess.DataConn;
import com.cis550.photozee.server.dataaccess.PhotoDB;
import com.cis550.photozee.server.dataaccess.UserDB;
import com.cis550.photozee.server.dataaccess.UserProfileDB;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mysql.jdbc.Connection;

public class UserProfileServiceImpl extends RemoteServiceServlet implements UserProfileService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public UserProfile getUserProfile(int user_id, int requester_id)throws IllegalArgumentException {		
		UserProfile user = UserProfileDB.getuserProfile(user_id, requester_id);		
		return user;
	}

	@Override
	public UserProfile uploadPhoto(int user_id, String url, String caption,
			String tag, int index, ArrayList<Integer> visibilityList) {
		PhotoDB.savePhotos(user_id, url, caption, tag, index, visibilityList);
		return null;
	}

	@Override
	public ArrayList<Circle> getCircleid(int user_id) {	
		return UserDB.getCircleids(user_id);
	}

	@Override
	public ArrayList<User> getUserid(int user_id) {		
		return UserDB.getUserids(user_id);
	}

	@Override
	public ArrayList<Integer> getFriends(int user_id, int requester_id) {
		UserProfile user = UserProfileDB.getuserProfile(user_id, requester_id);
		return (ArrayList<Integer>) user.getFriendIdsofAllCircles();
	}


	@Override
	public String UserinJson(int user_id, int requester_id) {		
	
		return UserProfileDB.toJson(user_id,requester_id);
	}

	@Override
	public int CreateCircle(int user_id, String Circle_name) {
		
		return UserDB.CreateCircle(user_id,Circle_name);
	}

	@Override
	public FriendMapping addFriend(int user_id, List<Integer> circle_ids,
			String friend_email) {
		
		return UserDB.addFriend(user_id, friend_email, circle_ids);
	}
	
	@Override
	public List<FriendMapping> FriendRequestsSent(int user_id) {
		
		return UserDB.friendRequestsSent(user_id);
	}

	@Override
	public List<FriendMapping> FriendRequestRecieved(int user_id) {
		return UserDB.friendRequestsRecieved(user_id);
	}

	@Override
	public Boolean confirmFriend(int user_id, List<Integer> circle_ids,
			int friend_id) {
		return UserDB.ConfirmFriend(user_id,friend_id,circle_ids);
	}

	@Override
	public Boolean addInterests(int userID, String strInterests) {
		// TODO Auto-generated method stub
		return UserProfileDB.addInterests(userID, strInterests);
	}
	
	
}
