package com.cis550.photozee.server.dataaccess;

import com.cis550.photozee.client.model.*;

import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserProfileDB {

	private UserProfileDB() {
	}

	static Connection con = DataConn.getConn();

	public static UserProfile getuserProfile(int userid, int requester_id) {

		UserProfile userprof = new UserProfile();
		getUser(userprof, userid);
		getPhotos(userprof);
		for (Photo foto : userprof.getPhotos()) {
			getTags(foto);
			getAvgRating(foto);
			getVisibilityforPhoto(foto,userprof.getUser_id());
			
		}
		getCircles(userprof);
		for (Circle circle : userprof.getCircles()) {
			getFrens(circle);
		}
		
		if(userid != requester_id)
			deletePhotosonRequester(userprof,requester_id);
		return userprof;
	}

	public static UserProfile getUser(UserProfile userprof, int userid) {

		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL getfromUserDB(?)}");
			cStmt.setInt(1, userid);
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();

			while (rs1.next()) {
				userprof.setUser_id(rs1.getInt(1));
				userprof.setF_name(rs1.getString(2));
				userprof.setL_name(rs1.getString(3));
				userprof.setAge(rs1.getInt(4));
				userprof.setGender(rs1.getString(5));
				userprof.setEmail(rs1.getString(6));
				userprof.setAddress(rs1.getString(7));
				userprof.setDob(rs1.getTimestamp(8));
				userprof.setType(rs1.getString(9));
				System.out.print("userprofile Table Loaded");
				System.out.print(rs1.getString(9));
				// need to implement or get the interests;

			}

			rs1.close();
			cStmt.close();
			
			// Get interests
			CallableStatement intStmt = con.prepareCall("{CALL getInterests(?)}");
			intStmt.setInt(1, userid);
			intStmt.execute();
			
			ResultSet intResult = intStmt.getResultSet();
			List<String> interests = new ArrayList<String>();
			while (intResult.next()) {
				interests.add(intResult.getString(1));
			}
			userprof.setInterests(interests);
			
			if (userprof.getType().equals("PROF")) {
				System.out.print("inside Prof");
				CallableStatement profStmt = con.prepareCall("{CALL getProfessor(?)}");
				System.out.println(userprof.getUser_id());
				profStmt.setInt(1, userprof.getUser_id());
				profStmt.execute();

				ResultSet profrs1 = profStmt.getResultSet();
				Professor prof = new Professor();
				while (profrs1.next()) {
					prof.setResearchArea(profrs1.getString(1));
					prof.setDepartment(profrs1.getString(2));
					System.out.print("Professor Table Loaded");
				}

				profrs1.close();
				profStmt.close();

				CallableStatement adviseesStmt = con
						.prepareCall("{CALL getAdvisees(?)}");
				adviseesStmt.setInt(1, userprof.getUser_id());
				adviseesStmt.execute();

				List<Advisorsees> list_of_advisees = new ArrayList<Advisorsees>();
				ResultSet adviseesrs1 = adviseesStmt.getResultSet();
				while (adviseesrs1.next()) {

					Advisorsees advisee = new Advisorsees();
					advisee.setAdvisorsees_id(adviseesrs1.getInt(1));
					advisee.setStart_year(adviseesrs1.getTimestamp(2));
					advisee.setEnd_year(adviseesrs1.getTimestamp(3));
					list_of_advisees.add(advisee);

				}

				prof.setAdvisees(list_of_advisees);
				adviseesrs1.close();
				adviseesStmt.close();

				userprof.setProfessor(prof);
				System.out.print("Loaded the professor table and advises list");
				// Load the professor table and advises list
			} else if (userprof.getType().equals("STUD")) {
				// load the student
				
				CallableStatement studStmt;
				studStmt = con.prepareCall("{CALL getStudent(?)}");
				studStmt.setInt(1, userprof.getUser_id());
				studStmt.execute();

				ResultSet studrs1 = studStmt.getResultSet();
				Student student = new Student();
				while (studrs1.next()) {
					
					student.setJoin_year(studrs1.getTimestamp(1));
					student.setGrad_year(studrs1.getTimestamp(2));
					student.setMajor(studrs1.getString(3));
					student.setGpa(studrs1.getDouble(4));					
				}

				studrs1.close();
				studStmt.close();

				CallableStatement advisorStmt = con
						.prepareCall("{CALL getAdvisor(?)}");
				advisorStmt.setInt(1, userprof.getUser_id());
				advisorStmt.execute();

				ResultSet advisors1 = advisorStmt.getResultSet();
				while (advisors1.next()) {

					Advisorsees advisor = new Advisorsees();
					advisor.setAdvisorsees_id(advisors1.getInt(1));
					advisor.setStart_year(advisors1.getTimestamp(2));
					advisor.setEnd_year(advisors1.getTimestamp(3));
					student.setAdvisor(advisor);
				}
				
				advisors1.close();
				advisorStmt.close();

				userprof.setStudent(student);
				System.out.print("Loaded the student table and advisor list");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userprof;
	}

	public static UserProfile getPhotos(UserProfile userprof) {

		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL getfromPhotos(?)}");
			cStmt.setInt(1, userprof.getUser_id());
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();

			List<Photo> photos = new ArrayList<Photo>();
			while (rs1.next()) {

				Photo curphoto = new Photo();

				curphoto.setPhoto_id(rs1.getInt(1));
				curphoto.setCaptions(rs1.getString(2));
				curphoto.setVisibility_choice(rs1.getString(3));
				curphoto.setUploaded_dt(rs1.getTimestamp(4));
				curphoto.setUrl(rs1.getString(5));		
				
				photos.add(curphoto);

				System.out.print("print completed");

			}

			userprof.setPhotos(photos);

			rs1.close();
			cStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userprof;
	}
	
	public static Photo getAvgRating(Photo photo){
		
		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL getAvgRating(?)}");
			cStmt.setInt(1, photo.getPhoto_id());
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();
			List<Tag> tags = new ArrayList<Tag>();

			while (rs1.next()) {

				photo.setAvg_score(rs1.getDouble(1));
				photo.setNo_of_raters(rs1.getInt(2));

				System.out.print("print completed");

			}
			photo.setTags(tags);

			rs1.close();
			cStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photo;
		
	}
	
	public static Photo getVisibilityforPhoto(Photo photo, int photo_owner_id){
		
		try{
			
		List<Integer> visible_users = new ArrayList<Integer>();
		if (photo.getVisibility_choice().equals("USERS")) {
			
			CallableStatement  VUStmt = con.prepareCall("{CALL getVisibleUsers4mVU(?)}");
			VUStmt.setInt(1, photo.getPhoto_id());
			VUStmt.execute();
			ResultSet VUrs1 = VUStmt.getResultSet();			
			while (VUrs1.next()) {
				visible_users.add(VUrs1.getInt(1));
			}
			

		} else if (photo.getVisibility_choice().equals("CIRCLES")) {

			CallableStatement  VUStmt = con.prepareCall("{CALL getVisibleUsers4mVC(?)}");
			VUStmt.setInt(1, photo.getPhoto_id());
			VUStmt.execute();
			ResultSet VUrs1 = VUStmt.getResultSet();	
			while (VUrs1.next()) {
				visible_users.add(VUrs1.getInt(1));
			}
			
			
		} else {
			// load the list of all users
			
			CallableStatement  UStmt = con.prepareCall("{CALL getallUsersExceptMe(?)}");
			UStmt.setInt(1, photo_owner_id);
			UStmt.execute();
			ResultSet Urs1 = UStmt.getResultSet();			
			while (Urs1.next()) {
				visible_users.add(Urs1.getInt(1));
			}
					
		}
		//adding Owner of the User to see the photo
		visible_users.add(photo_owner_id);
		photo.setVisible_frenids(visible_users);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return photo;
		
	}

	public static Photo getTags(Photo photo) {
		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL getTags4mPhotoid(?)}");
			cStmt.setInt(1, photo.getPhoto_id());
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();
			List<Tag> tags = new ArrayList<Tag>();

			while (rs1.next()) {

				Tag tag = new Tag();

				tag.setTag_id(rs1.getInt(1));
				tag.setTagged_dt(rs1.getTimestamp(2));

				tag.setTagger_id(rs1.getInt(3));
				tag.setTag(rs1.getString(4));
				tags.add(tag);

				System.out.print("print completed");

			}
			photo.setTags(tags);

			rs1.close();
			cStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photo;
	}

	public static UserProfile getCircles(UserProfile userprof) {

		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL getCircleids(?)}");
			cStmt.setInt(1, userprof.getUser_id());
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();

			List<Circle> circles = new ArrayList<Circle>();
			while (rs1.next()) {

				Circle curcircle = new Circle();

				curcircle.setCircle_id(rs1.getInt(1));
				curcircle.setCirclecreated_dt(rs1.getTimestamp(2));
				curcircle.setCircle_name(rs1.getString(3));

				System.out.print("print completed");
				circles.add(curcircle);

			}

			userprof.setCircles(circles);

			rs1.close();
			cStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userprof;
	}

	public static Circle getFrens(Circle circle) {

		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL getFrens4mCircle(?)}");
			cStmt.setInt(1, circle.getCircle_id());
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();
			List<Integer> fren_ids = new ArrayList<Integer>();
			List<String> fren_names = new ArrayList<String>();
			List<FriendMapping> fms = new ArrayList<FriendMapping>();
			while (rs1.next()) {

				Integer frendid;
				String friendname;

				frendid = rs1.getInt(1);
				friendname = rs1.getString(2);
				fren_ids.add(frendid);
				fren_names.add(friendname);

				FriendMapping fm = new FriendMapping();
				fm.setFriend_id(rs1.getInt(1));
				fm.setFriend_fname(rs1.getString(3));
				fm.setFriend_lname(rs1.getString(4));
				fm.setFriend_email(rs1.getString(5));
				fm.setFriend_type(rs1.getString(6));
				fms.add(fm);

			}

			circle.setFriend_maps(fms);
			circle.setFriend_ids(fren_ids);
			circle.setFriend_names(fren_names);
			rs1.close();
			cStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return circle;
	}

	public static ArrayList<UserProfile> getFrensProfile(int user_id, int requester_id) {

		ArrayList<UserProfile> frens_profile = new ArrayList<UserProfile>();

		List<Integer> frens_list = new ArrayList<Integer>();
		CallableStatement cStmt;
		try {

			cStmt = con.prepareCall("{CALL getFrensofUser(?)}");
			cStmt.setInt(1, user_id);
			cStmt.execute();

			ResultSet rs1 = cStmt.getResultSet();

			while (rs1.next()) {
				frens_list.add(rs1.getInt(1));
				System.out.print("user added");

			}

			rs1.close();
			cStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Integer fren : frens_list) {
			UserProfile fren_profile = getuserProfile(fren,requester_id);
			frens_profile.add(fren_profile);
		}

		return frens_profile;
	}

	public static String toJson(int user_id, int requester_id) {

		UserProfile user = UserProfileDB.getuserProfile(user_id, requester_id);
		System.out.println();

		String result = "{\"id\":";
		result += user.getUser_id() + ", ";
		result += "\"name\":";
		result += "\"" + user.getF_name() + " " + user.getL_name() + "\", ";
		result += "\"children\":";
		result += "[";

		List<Circle> circles = user.getCircles();
		int j = 0;
		for (Circle circle : circles) {
			List<FriendMapping> frens = circle.getFriend_maps();
			int i = 1;
			for (FriendMapping fren : frens) {
				// do some string operation with Friends
				result += "{\"id\":";
				result += fren.getFriend_id() + ", ";
				result += "\"name\":";
				result += "\"" + fren.getFriend_fname() + " "
						+ fren.getFriend_lname() + "\", ";
				result += "\"type\":\"" + fren.getFriend_type() + "\" ";
				result += "}";
				if (i == frens.size()) {

				} else {
					result += ",";

				}
				i = i + 1;
			}
			if (j + 1 == circles.size()) {

			} else {
				if (circles.get(j).getFriend_ids().size() == 0 ||circles.get(j+1).getFriend_ids().size() == 0 ) {

				} else {
					result += ",";
				}

			}
			j = j + 1;

		}

		result += "]}";
		return result;

	}

	public static UserProfile deletePhotosonRequester(UserProfile user,int requester_id){
		
		
		
		//record all the photos with requested user..
		for(int i=0;i<user.getPhotos().size();i++){
			
		  user.getPhotos().get(i).getVisible_frenids();
		 
		  Boolean present = false;
		   for(int j=0 ;j < user.getPhotos().get(i).getVisible_frenids().size(); j++){
			   if(user.getPhotos().get(i).getVisible_frenids().get(j) == requester_id)
				  present = true;
		   }
		   
		   if(!present)
		   {
			   System.out.println("Removed the PhotoID "+ user.getPhotos().get(i).getPhoto_id());
			   user.getPhotos().remove(i);
			   System.out.println("---removed--" +user.getPhotos().size());
		   }
		 
		 
		}
		
		//find the unique of the removed list..
	
		return user;
	}

	public static List<Photo> deletePhotosonRequester(List<Photo> photos,int requester_id){
		
		int no_of_photos = photos.size();
		for(int i=0;i<photos.size();i++){
						 
			  Boolean present = false;
			   for(int j=0 ;j < photos.get(i).getVisible_frenids().size(); j++){
				   if(photos.get(i).getVisible_frenids().get(j) == requester_id)
					  present = true;
			   }
			   
			   if(!present)
			   {
				   System.out.println("Removed the PhotoID "+ photos.get(i).getPhoto_id());
				   photos.remove(i);
				   System.out.println("---removed--" +photos.size());
			   }
			 
			 
			}
		
		return photos;
	}

	public static Boolean addInterests(int userID, String strInterests) {
		String[] interests = strInterests.split(",");
		
		for (String interest : interests) {
			try {
				CallableStatement cStmt = con.prepareCall("{CALL addInterests(?, ?)}");
				cStmt.setInt(1, userID);
				cStmt.setString(2, interest);
				cStmt.execute();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		return false;
	}
}
