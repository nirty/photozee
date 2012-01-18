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
package com.cis550.photozee.client;

import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.client.model.UserProfile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("UserProfileService")
public interface UserProfileService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	/*public static class Util {
		private static UserProfileServiceAsync instance;
		public static UserProfileServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(UserProfileService.class);
			}
			return instance;
		}
	}*/

	public UserProfile getUserProfile(int user_id, int requester_id);
	
	public UserProfile uploadPhoto(int user_id,String url,String caption,String tag,int index,ArrayList<Integer> visibilitylist);
	
	public ArrayList<Circle> getCircleid(int user_id);
	
	public ArrayList<User> getUserid(int user_id);
	
	public ArrayList<Integer> getFriends(int user_id, int requester_id);	
	
	public String UserinJson(int user_id,  int requester_id);
	
	public int CreateCircle(int user_id,String Circle_name);
	
	public FriendMapping addFriend(int user_id, List<Integer> circle_ids, String friend_email);
	
	public List<FriendMapping> FriendRequestsSent(int user_id);
	
	public List<FriendMapping> FriendRequestRecieved(int user_id);
	
	public Boolean confirmFriend (int user_id,List<Integer> circle_ids,int friend_id);
	
	public Boolean addInterests(int userID, String strInterests);
	
}
