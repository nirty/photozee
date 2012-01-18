package com.cis550.photozee;

import java.util.List;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.client.model.UserProfile;
import com.cis550.photozee.server.dataaccess.UserProfileDB;

import junit.framework.TestCase;

public class UserProfileDBTest extends TestCase {

	public void testGetuserProfile() {
		UserProfile user = UserProfileDB.getuserProfile(33000,33000);
		System.out.print("hello");
	}
	
	
	public void getFrenProfiles(){
		List<UserProfile> list = UserProfileDB.getFrensProfile(33000,33000);
		
		for(UserProfile fren: list){
		System.out.println(fren.getF_name());
		}
	}
	
	public void testtoJson() {
		System.out.println("");
		String result =  UserProfileDB.toJson(33000,33000);
		System.out.println(result);
	}

	public void testGetPhotovisibility(){
		Photo newphoto= new Photo();
		newphoto.setPhoto_id(33000);
		newphoto.setVisibility_choice("ALL");
		Photo result = UserProfileDB.getVisibilityforPhoto(newphoto,33000);
		System.out.println(result);
	}
	
	public void testremovePhotos(){
		UserProfile user = UserProfileDB.getuserProfile(33000,33000);
		UserProfile user_temp = user;
		UserProfileDB.deletePhotosonRequester(user,33060);
		System.out.println(user);
		System.out.println("test");
	}
	
	public void testaddinterest(){
		UserProfileDB.addInterests(33000, "chess,swimming");
		System.out.println("test");
	}
}
