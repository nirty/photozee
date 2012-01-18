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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cis550.photozee.client.HomePageService;
import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Rating;
import com.cis550.photozee.client.model.Tag;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.client.model.UserProfile;
import com.cis550.photozee.server.dataaccess.PhotoDB;
import com.cis550.photozee.server.dataaccess.UserDB;
import com.cis550.photozee.server.dataaccess.UserProfileDB;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class HomePageServiceImpl extends RemoteServiceServlet implements HomePageService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<User> getUsers() throws IllegalArgumentException {
		
		List<User> results = UserDB.getAllUsers();
		return results;
	}

	public String getUserName(String userID) {
		return UserDB.getUserName(userID).trim();
	}
	
	public List<User> getFriendRecs(int userID) {
		return UserDB.getFriendRecs(userID);
	}
	
	public List<Photo> getUpdates(int userID) {
		return PhotoDB.getUpdates(userID);
	}
	
	public List<Photo> getTopPhotos(int userID) {
		// Get all visible photos for given user
		List<Photo> visPhotos = PhotoDB.getVisiblePhotos(userID);
		
		// Compute photo relevance score
		for (int i = 0; i < visPhotos.size(); i++) {
			// Compute overall average rating
			List<Rating> ratings = visPhotos.get(i).getRatings();
			float avgRating = 0;
			if (ratings != null) {
				for (int j = 0; j < ratings.size(); j++) {
					avgRating += ratings.get(j).getScore();
				}
				avgRating = avgRating / ratings.size();
			}
			// Compute friends average rating
			float avgFriendRating = PhotoDB.getAvgFriendRating(userID, visPhotos.get(i).getPhoto_id());
			
			// Determine whether uploaded by friend
			int friendUp = PhotoDB.isUploadedByFriend(userID, visPhotos.get(i).getPhoto_id());
			
			// Normalize each component to number between 0 and 1
			float normAvgRating = avgRating / 5;
			float normAvgFriendRating = avgFriendRating / 5;
			
			// Apply weights and compute score
			double relScore = (0.3) * normAvgRating + (0.3) * friendUp + (0.4) * normAvgFriendRating;
			visPhotos.get(i).setRelScore(relScore);
		}
		// Sort the photos in ascending order of relevance score
		Collections.sort(visPhotos);
		// Grab top 5 photos
		List<Photo> rankedPhotos = new ArrayList<Photo>();
		for (int i = visPhotos.size() - 1; i >= visPhotos.size() - 5; i--) {
			
			// need to pick up average rating on the Photo object -- Nirty			
			//rankedPhotos.add(visPhotos.get(i));
			
			
			rankedPhotos.add(UserProfileDB.getAvgRating(visPhotos.get(i)));
			System.out.println(visPhotos.get(i).getPhoto_id() + " : " + visPhotos.get(i).getRelScore());
		}
		return rankedPhotos;
	}
}
