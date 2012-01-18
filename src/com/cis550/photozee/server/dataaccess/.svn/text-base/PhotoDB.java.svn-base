package com.cis550.photozee.server.dataaccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.Tag;
import com.cis550.photozee.client.model.User;
import com.google.gwt.dev.util.collect.HashSet;
import com.mysql.jdbc.Statement;

public class PhotoDB {
	static Connection con = DataConn.getConn();

	private PhotoDB() {
	}

	public static boolean savePhotos(int userid, String url, String caption,
			String tag, int index, ArrayList<Integer> visibilityList) {

		// Select url_id from url where url = URL;
		// loop thro rs..
		// if null
		// insert into url &
		// get the id of the url

		// else
		// create a photo id with existing

		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL urlCheck(?)}");
			cStmt.setString(1, url);
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();
			int url_id = 0;

			if (rs1.next()) {
				url_id = rs1.getInt(1);
				System.out.println("found the url-- urlID" + url_id);
			} else {
				CallableStatement istmt = con
						.prepareCall("{CALL inserturl(?)}");
				istmt.setString(1, url);
				istmt.execute();
				ResultSet urlid = istmt.getResultSet();

				System.out.println("inserted the url-- urlID");
				if (urlid.next())
					url_id = urlid.getInt(1);
				else
					url_id = 0;
				urlid.close();
				istmt.close();
			}

			rs1.close();
			cStmt.close();
			int photo_id = 0;
			if (url_id != 0) {

				CallableStatement cpStmt = con
						.prepareCall("{CALL photoCheck(?,?)}");
				cpStmt.setInt(1, userid);
				cpStmt.setInt(2, url_id);
				cpStmt.execute();

				ResultSet spRs = cpStmt.getResultSet();

				if (spRs.next()) {
					photo_id = spRs.getInt(1);
					System.out.println("found the PhotoID" + photo_id);

				} else {

					CallableStatement istmt = con
							.prepareCall("{CALL insertPhoto(?,?,?,?)}");
					istmt.setInt(1, userid);
					istmt.setInt(2, url_id);
					istmt.setString(3, caption);
					if(index == 1)
						istmt.setString(4, "CIRCLES");
					if(index == 2)
						istmt.setString(4, "USERS");
					if(index == 0)
						istmt.setString(4, "ALL");
						

					istmt.execute();
					System.out.println("inserted the photo -- photoID");
					ResultSet photoid;
					photoid = istmt.getResultSet();
					if (photoid.next())
						photo_id = photoid.getInt(1);
					else
						photo_id = 0;

					photoid.close();
					istmt.close();

				}
				spRs.close();
				cpStmt.close();

			}

			
			String[] tag_array = tag.split("[\\s,]+");
			

			if (tag_array.length != 0 && photo_id != 0) {

				ArrayList<Integer> tag_ids = new ArrayList<Integer>();
				CallableStatement tstmt = con
						.prepareCall("{CALL insertTag(?)}");
				for (int i = 0; i < tag_array.length; i++) {

					System.out.println(tag_array[i]);

					tstmt.setString(1, tag_array[i].toString());
					tstmt.execute();
					ResultSet tagid = tstmt.getResultSet();

					System.out.println("inserted the tag -- tagID");
					if (tagid.next())
						tag_ids.add(tagid.getInt(1));
					else
						tag_ids.add(0);

					tagid.close();
				}

				tstmt.close();

				for (Integer tag_id : tag_ids) {
					CallableStatement ptstmt = con
							.prepareCall("{CALL insertPhotoTags(?,?,?)}");
					if (tag_id != 0) {

						ptstmt.setInt(1, photo_id);
						ptstmt.setInt(2, tag_id);
						ptstmt.setInt(3, userid);
						ptstmt.execute();
						System.out
								.println("inserted the PhotoTags-- No Need of returning photoTags");

					}
					ptstmt.close();
				}
				
				//create Inverted Index
				
				Boolean saveInvIndex = InvertedIndex(tag, photo_id);
				
				
				System.out.println("Index is this -------------"+index);
				System.out.println("Visibility length is this -------------"+visibilityList.size() );
				System.out.println("Photo ID is this -------------"+photo_id);
				if (index != 0 && visibilityList != null && photo_id != 0){
					
					if (index == 1){
						
						CallableStatement VCstmt = con
								.prepareCall("{CALL insertVisibleCircles(?,?)}");
						for (int i = 0; i < visibilityList.size(); i++) {

							System.out.println(visibilityList.get(i));
							VCstmt.setInt(1,photo_id);
							VCstmt.setInt(2,(int) visibilityList.get(i));
							VCstmt.execute();
						}

						VCstmt.close();
						
					}
					if (index == 2){
						
						CallableStatement VUstmt = con
								.prepareCall("{CALL insertVisibleUsers(?,?)}");
						for (int i = 0; i < visibilityList.size(); i++) {

							System.out.println(visibilityList.get(i));
							VUstmt.setInt(1,photo_id);
							VUstmt.setInt(2, (int)visibilityList.get(i));
							VUstmt.execute();
						}

						VUstmt.close();
						
					}
						
					
					
					
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}



	public static Photo getPhoto(int photoid){
		
		
		Photo existingphoto = getPhoto4mid(photoid);
		UserProfileDB.getTags(existingphoto);
		UserProfileDB.getAvgRating(existingphoto);
		return existingphoto;
	}
	
	public static Photo getPhoto4mid(int photo_id){
		CallableStatement cStmt;
		 Photo curphoto = new Photo();
		try {		
			
			cStmt = con.prepareCall("{CALL getPhoto4mPhotoid(?)}");
			cStmt.setInt(1, photo_id);
			 cStmt.execute();
		       
		       ResultSet rs1 = cStmt.getResultSet();
		      
		       while (rs1.next()) {
		    	   	    	   
		    	   curphoto.setPhoto_id(rs1.getInt(1));
		    	   curphoto.setCaptions(rs1.getString(2));
		    	   //need to define visibility in photo class
		    	   curphoto.setVisibility_choice(rs1.getString(3));
		    	   curphoto.setUploaded_dt(rs1.getTimestamp(4));
		    	   curphoto.setUrl(rs1.getString(5));
		    	   curphoto = UserProfileDB.getVisibilityforPhoto(curphoto, rs1.getInt(6));
		    
		    	   System.out.print("print completed");
		               
		          }
		       
		          
		          rs1.close();
		          cStmt.close();
		          
		          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return curphoto;
		
	}
	
	public static Boolean savePhotoTagsNScore(int tagnscorer_id,int photoid, String tags, int score ){
		
		String[] tag_array = tags.split("[\\s,]+");
		
		try{
		if (tag_array.length != 0 && photoid != 0) {

			ArrayList<Integer> tag_ids = new ArrayList<Integer>();
			CallableStatement tstmt = con.prepareCall("{CALL insertTag(?)}");
			for (int i = 0; i < tag_array.length; i++) {

				System.out.println(tag_array[i]);

				tstmt.setString(1, tag_array[i].toString());
				tstmt.execute();
				ResultSet tagid = tstmt.getResultSet();

				System.out.println("inserted the tag -- tagID");
				if (tagid.next())
					tag_ids.add(tagid.getInt(1));
				else
					tag_ids.add(0);

				tagid.close();
			}

			tstmt.close();

			for (Integer tag_id : tag_ids) {
				CallableStatement ptstmt = con
						.prepareCall("{CALL insertPhotoTags(?,?,?)}");
				if (tag_id != 0) {

					ptstmt.setInt(1, photoid);
					ptstmt.setInt(2, tag_id);
					ptstmt.setInt(3, tagnscorer_id);
					ptstmt.execute();
					System.out
							.println("inserted the PhotoTags-- No Need of returning photoTags");

				}
				ptstmt.close();
			}
			
			try{
			CallableStatement irstmt = con
					.prepareCall("{CALL insertRating(?,?,?)}");
			if (score != -1) {

				irstmt.setInt(1, tagnscorer_id);
				irstmt.setInt(2, photoid);
				irstmt.setInt(3, score);
				irstmt.execute();
				System.out
						.println("inserted the Rating");

			}
			irstmt.close();
			}catch(Exception e){
				
			}
			
		}
		
		// add it to Inverted Index
		InvertedIndex(tags,photoid);
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return true;
	}


	public static Boolean InvertedIndex(String tags,int photoid) {
		
		tags = tags.toLowerCase();
		String[] tag_array = tags.split("[\\s,]+");
		
		for (String tag_token : tag_array){
			
			
			try {

				//create a new Tag_token
				CallableStatement iInvstmt = con
						.prepareCall("{CALL insertInvIndex(?,?)}");
				
				iInvstmt.setString(1, tag_token);
				iInvstmt.setInt(2, photoid);
				iInvstmt.execute();
				iInvstmt.close();
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			}		
		
		}
		return true;
	}


	public static List<Photo> searchPhotos(String searchString,  int requester_id){
		searchString = searchString.toLowerCase();
		String[] search_array = searchString.split(" ");
		ArrayList<ArrayList<Integer>> list_of_list_of_photos = new ArrayList<ArrayList<Integer>>();
		
		for(String searchItem: search_array)
		{
			
			try{
				CallableStatement cStmt = con.prepareCall("{CALL getPhotofromInvIndex(?)}");
				cStmt.setString(1,searchItem );
				 cStmt.execute();
			       
			       ResultSet rs1 = cStmt.getResultSet();
			       ArrayList<Integer> list_of_photos = new ArrayList<Integer>();
			      
			       while (rs1.next()) {
			    	   
			    	   list_of_photos.add(rs1.getInt(1));		    
			    	   System.out.print("photo id read");
			               
			          }		          
			          rs1.close();
			          cStmt.close();
			          list_of_list_of_photos.add(list_of_photos);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			     
			
		}
		
		Set<Integer> intersection = new HashSet<Integer>(list_of_list_of_photos.get(0));
		
		for(int i=1;i<list_of_list_of_photos.size();i++){
			intersection.retainAll(list_of_list_of_photos.get(i));
		}
		
		Set<Integer> temp = intersection;
		
		List<Photo> search_ResultsPhoto = new ArrayList<Photo>();
		Iterator<Integer> iter = temp.iterator();
		
		
		System.out.println("-----before while in adding photos-------");
	    while (iter.hasNext()) {
	     // System.out.println(iter.next()+"-");
	      
	      search_ResultsPhoto.add(getPhoto(iter.next()));
	      
	    }
	    System.out.println("------after adding Photos------");
		
	    UserProfileDB.deletePhotosonRequester(search_ResultsPhoto, requester_id);
	    
	    System.out.println("------after filtering visibility------");
	    
	    System.out.println(search_ResultsPhoto.size());
	    
		return search_ResultsPhoto;
	}
	
	public static List<Photo> getUpdates(int userID) {
		List<Photo> updates = new ArrayList<Photo>();
		
		try {
			CallableStatement cStmt = con.prepareCall("{CALL getUpdates(?)}");
			cStmt.setInt(1, userID);
			cStmt.execute();
		       
		    ResultSet rs1 = cStmt.getResultSet();
		    
		    // For each photo, grab all necessary information
		    while (rs1.next()) {
		    	Photo currPhoto = new Photo();
		    	User currUser = new User();
		    	currPhoto.setPhoto_id(rs1.getInt(1));
		    	currUser.setUser_id(rs1.getInt(2));
		    	currUser.setF_name(rs1.getString(3));
		    	currUser.setL_name(rs1.getString(4));
		    	currPhoto.setUploader(currUser);
		    	currPhoto.setUrl(rs1.getString(5));
		    	currPhoto.setCaptions(rs1.getString(6));
		    	currPhoto.setUploaded_dt(rs1.getTimestamp(7));
		    	// Add tags
		    	CallableStatement tagStmt;
			    ResultSet rs2;
			    tagStmt = con.prepareCall("{CALL getTags4mPhotoid(?)}");
			    tagStmt.setInt(1, currPhoto.getPhoto_id());
			    tagStmt.execute();
				rs2 = tagStmt.getResultSet();
				// Grab all appropriate tag properties
				List<Tag> tags = new ArrayList<Tag>();
				while (rs2.next()) {
					Tag currTag = new Tag();
				   	currTag.setTag_id(rs2.getInt(1));
				   	currTag.setTagged_dt(rs2.getTimestamp(2));
				   	currTag.setTagger_id(rs2.getInt(3));
				   	currTag.setTag(rs2.getString(4));
				   	tags.add(currTag);
 				}
				
				UserProfileDB.getAvgRating(currPhoto);
				currPhoto.setTags(tags);
				updates.add(currPhoto);
			}
	    } catch(Exception e) {
			e.printStackTrace();
		}
		
		return updates;
	}
	
	public static List<Tag> getPhotoTags(int photoID) {
		List<Tag> tags = new ArrayList<Tag>();
		try {
			CallableStatement cStmt = con.prepareCall("{CALL getTags4mPhotoid(?)}");
			cStmt.setInt(1, photoID);
			cStmt.execute();
			ResultSet result = cStmt.getResultSet();
			
			while (result.next()) {
				Tag currTag = new Tag();
				currTag.setTag_id(result.getInt(1));
			   	currTag.setTagged_dt(result.getTimestamp(2));
			   	currTag.setTagger_id(result.getInt(3));
			   	currTag.setTag(result.getString(4));
			   	tags.add(currTag);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tags;
	}
	
	public static List<Photo> getVisiblePhotos(int userID) {
		List<Photo> visPhotos = new ArrayList<Photo>();
		
		try {
			CallableStatement cStmt = con.prepareCall("{CALL getVisiblePhotos(?)}");
			cStmt.setInt(1, userID);
			cStmt.execute();
		       
		    ResultSet rs1 = cStmt.getResultSet();
		    
		    // For each photo, grab all necessary information
		    while (rs1.next()) {
		    	Photo currPhoto = new Photo();
		    	User currUser = new User();
		    	currPhoto.setPhoto_id(rs1.getInt(1));
		    	currUser.setUser_id(rs1.getInt(2));
		    	currUser.setF_name(rs1.getString(3));
		    	currUser.setL_name(rs1.getString(4));
		    	currPhoto.setUploader(currUser);
		    	currPhoto.setUrl(rs1.getString(5));
		    	currPhoto.setCaptions(rs1.getString(6));
		    	currPhoto.setUploaded_dt(rs1.getTimestamp(7));
		    	// Add tags
		    	CallableStatement tagStmt;
			    ResultSet rs2;
			    tagStmt = con.prepareCall("{CALL getTags4mPhotoid(?)}");
			    tagStmt.setInt(1, currPhoto.getPhoto_id());
			    tagStmt.execute();
				rs2 = tagStmt.getResultSet();
				// Grab all appropriate tag properties
				List<Tag> tags = new ArrayList<Tag>();
				while (rs2.next()) {
					Tag currTag = new Tag();
				   	currTag.setTag_id(rs2.getInt(1));
				   	currTag.setTagged_dt(rs2.getTimestamp(2));
				   	currTag.setTagger_id(rs2.getInt(3));
				   	currTag.setTag(rs2.getString(4));
				   	tags.add(currTag);
 				}
				currPhoto.setTags(tags);
				visPhotos.add(currPhoto);
			}
	    } catch(Exception e) {
			e.printStackTrace();
		}
		
		return visPhotos;
	}
	
	public static int isUploadedByFriend(int userID, int photoID) {
		try {
			CallableStatement cStmt = con.prepareCall("{CALL isUploadedByFriend(?,?)}");
			cStmt.setInt(1, userID);
			cStmt.setInt(2, photoID);
			cStmt.execute();
		       
		    ResultSet rs1 = cStmt.getResultSet();
		    boolean result = rs1.first();
		    
		    return result ? 1 : 0;
		    
	    } catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public static float getAvgRating(int photoID) {
		try {
			CallableStatement cStmt = con.prepareCall("{CALL getAvgRating(?)}");
			cStmt.setInt(1, photoID);
			cStmt.execute();
		       
		    ResultSet rs1 = cStmt.getResultSet();

		    if (rs1.first()) {
		    	return rs1.getFloat(1);
		    } else {
		    	return 0;
		    }
		    
	    } catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public static float getAvgFriendRating(int userID, int photoID) {
		try {
			CallableStatement cStmt = con.prepareCall("{CALL getAvgFriendRating(?, ?)}");
			cStmt.setInt(1, userID);
			cStmt.setInt(2, photoID);
			cStmt.execute();
		       
		    ResultSet rs1 = cStmt.getResultSet();

		    if (rs1.first()) {
		    	return rs1.getFloat(1);
		    } else {
		    	return 0;
		    }
		    
	    } catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
