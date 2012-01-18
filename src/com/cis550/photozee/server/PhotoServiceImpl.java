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

import java.util.List;

import com.cis550.photozee.client.PhotoService;
import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.server.dataaccess.PhotoDB;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PhotoServiceImpl extends RemoteServiceServlet implements PhotoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean tagAndScorePhoto(int tagnscorer_id, int photoid,
			String tags, int score) {
		
		return PhotoDB.savePhotoTagsNScore(tagnscorer_id,photoid,tags,score );
	}

	@Override
	public Photo getPhoto(int photoid) {
		
		return PhotoDB.getPhoto(photoid);
	}

	@Override
	public List<Photo> searchPhotos(String searchString,  int requester_id) {
		
		return PhotoDB.searchPhotos(searchString, requester_id);
	}
}
