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

import java.util.List;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.client.model.UserProfile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("HomePageService")
public interface HomePageService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static HomePageServiceAsync instance;
		public static HomePageServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(HomePageService.class);
			}
			return instance;
		}
	}

	List<User> getUsers() throws IllegalArgumentException;
	
	public String getUserName(String userID);
	public List<User> getFriendRecs(int userID);
	public List<Photo> getUpdates(int userID);
	public List<Photo> getTopPhotos(int userID);
}
