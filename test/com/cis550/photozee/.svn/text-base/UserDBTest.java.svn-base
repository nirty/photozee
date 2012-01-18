package com.cis550.photozee;

import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.cis550.photozee.client.model.User;
import com.cis550.photozee.server.dataaccess.UserDB;

import junit.framework.TestCase;

public class UserDBTest extends TestCase {

	public void testGetUser() {
		
		List<User> list = UserDB.getAllUsers();
		
		for(User user : list)
		{
			System.out.print(user.getUser_id());
			System.out.print(user.getEmail());
			System.out.print(user.getF_name());
			System.out.print(user.getL_name());
			System.out.println();
		}
	}
	
	public void testGetUserS() {
		
	System.out.println(UserDB.getUsers());
	}
	
	public void testGetUser1() {
	ArrayList<Circle> list = UserDB.getCircleids(33000);
	for(Circle cir:list)
		
		System.out.println(cir.getCircle_id());
	
	}
	
	public void insertCircle() {
	
		UserDB.CreateCircle(33008, "Testing From DB user 33008");
			
	}
	
	public void addFriend(){
		
		List<Integer> circle_ids = new ArrayList<Integer>();
		circle_ids.add(33005);
		circle_ids.add(33006);
		circle_ids.add(33007);
		circle_ids.add(33008);
		circle_ids.add(33009);
		UserDB.addFriend(33000,"kishor@kishor.com", circle_ids);
		System.out.println();
		
	}
	
	public void getFrenreqsSent(){
		
		
		List<FriendMapping> frens = UserDB.friendRequestsSent(33000);
		System.out.println();
	}

}
