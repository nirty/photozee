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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PhotoService")
public interface PhotoService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PhotoServiceAsync instance;
		public static PhotoServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PhotoService.class);
			}
			return instance;
		}
	}
	
	public boolean tagAndScorePhoto(int tagnscorer_id,int photoid,String tags,int score);
	
	public Photo getPhoto(int photoid);
	
	public List<Photo> searchPhotos(String searchString, int requester_id);
}
