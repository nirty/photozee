package com.cis550.photozee.server.dataaccess;

import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.model.Circle;
import com.cis550.photozee.client.model.FriendMapping;
import com.cis550.photozee.client.model.User;


public class UserDB {
	
	
public static Boolean ConfirmFriend(int user_id,int friend_id,List<Integer> Usercircle_ids){
		

		List<Integer> friendreqsIDs_retrieved = new ArrayList<Integer>();		
		List<Integer> frensCircle_ids = new ArrayList<Integer>();
		
		Connection con = DataConn.getConn();
		   try{
		   
			CallableStatement cStmt = con.prepareCall("{CALL retrieveFriendRequest(?,?)}");
			cStmt.setInt(1,user_id);
			cStmt.setInt(2,friend_id);
			cStmt.execute();
			ResultSet instResult = cStmt.getResultSet();
			
			while (instResult.next()) {
				
				friendreqsIDs_retrieved.add(instResult.getInt(1));
				frensCircle_ids.add(instResult.getInt(2));
			}
			cStmt.close();
		   }
		   
		   catch(Exception e){
			   System.out.println("No Friend Request Found");
			   e.printStackTrace();
			   return false;
		   }
		   
		   
		   for(Integer circleid: Usercircle_ids)
		   {
		   
		   try{
			   
				CallableStatement IStmt = con.prepareCall("{CALL insertUserFriendCircle(?,?,?)}");
				IStmt.setInt(1,user_id);
				IStmt.setInt(2,friend_id);
				IStmt.setInt(3,circleid);
				IStmt.execute();
				IStmt.close();
			   }
			   
			   catch(Exception e){
				   System.out.println("Error in Inserting Users Friends");
				   e.printStackTrace();
				   return false;
			   }
		   }
		   
		   for(Integer circleid: frensCircle_ids)
		   {
		   
		   try{
			   
				CallableStatement PStmt = con.prepareCall("{CALL insertUserFriendCircle(?,?,?)}");
				PStmt.setInt(1,friend_id);
				PStmt.setInt(2,user_id);
				PStmt.setInt(3,circleid);
				PStmt.execute();
				PStmt.close();
			   }
			   
			   catch(Exception e){
				   System.out.println("Error in Inserting Friends details");
				   e.printStackTrace();
				   return false;
			   }
		   }
		   
		   for(Integer frenrequestID : friendreqsIDs_retrieved){
			   
			   try{
				   
					CallableStatement ZStmt = con.prepareCall("{CALL deleteFrenqRequest(?)}");
					ZStmt.setInt(1,frenrequestID);
					ZStmt.execute();
					ZStmt.close();
				   }
				   
				   catch(Exception e){
					   System.out.println("Error in Deleting Friends details");
					   e.printStackTrace();
					   return false;
				   }
			   
		   } 
		
		return true;
		
	}
	
	public static List<FriendMapping> friendRequestsRecieved(int user_id){
		
		  List<FriendMapping> friendreqs_recieved = new ArrayList<FriendMapping>();
		   try{
		   Connection con = DataConn.getConn();
			CallableStatement cStmt = con.prepareCall("{CALL getFriendRequest4me(?)}");
			cStmt.setInt(1,user_id);
			cStmt.execute();
			ResultSet instResult = cStmt.getResultSet();

			
			while (instResult.next()) {
				FriendMapping friendreq = new FriendMapping();
				friendreq.setFriend_id(instResult.getInt(1));
				friendreq.setFriend_fname(instResult.getString(2));
				friendreq.setFriend_lname(instResult.getString(3));
				friendreq.setFriend_type(instResult.getString(4));
				friendreqs_recieved.add(friendreq);
			}
			
			instResult.close();
			cStmt.close();
		   }
			catch(Exception e){
				
				e.printStackTrace();
			}
		  
		   
		   return friendreqs_recieved;
		
	}
	public static List<FriendMapping> friendRequestsSent(int user_id){
		
		   List<FriendMapping> friendreqs_sent = new ArrayList<FriendMapping>();
		   try{
		   Connection con = DataConn.getConn();
			CallableStatement cStmt = con.prepareCall("{CALL getFriendRequestsSent(?)}");
			cStmt.setInt(1,user_id);
			cStmt.execute();
			ResultSet instResult = cStmt.getResultSet();

			
			while (instResult.next()) {
				FriendMapping friendreq = new FriendMapping();
				friendreq.setFriend_id(instResult.getInt(1));
				friendreq.setFriend_fname(instResult.getString(2));
				friendreq.setFriend_lname(instResult.getString(3));
				friendreq.setFriend_type(instResult.getString(4));
				friendreqs_sent.add(friendreq);
			}
			
			instResult.close();
			cStmt.close();
		   }
			catch(Exception e){
				
				e.printStackTrace();
			}
		  
		   
		   return friendreqs_sent;
		   
	   }
	
public static int CreateCircle(int user_id,String Circle_name){
		
		CallableStatement cStmt;
			try{
			Connection con = DataConn.getConn();
			cStmt = con.prepareCall("{CALL insertCircleNameAndID(?,?)}");
			cStmt.setInt(1, user_id);
			cStmt.setString(2,Circle_name);
			cStmt.execute();
			ResultSet result = cStmt.getResultSet();
			result.first();
			int circleID = result.getInt(1);
			cStmt.close();
			return circleID;
			}
			catch (Exception e){
				e.printStackTrace();
				
			}
			
			return -1;
		
	}
	
	public static FriendMapping addFriend(int userid,String email,List<Integer> circle_ids){
		
		FriendMapping addedFriend = new FriendMapping();
		try{
			
			
			Connection con = DataConn.getConn();
			CallableStatement cStmt = con.prepareCall("{CALL getUserFromEmail(?)}");
			cStmt.setString(1,email);
			cStmt.execute();
			ResultSet instResult = cStmt.getResultSet();

			if (instResult.next()) {
				
				int friend_id = instResult.getInt(1);
				addedFriend.setFriend_id(instResult.getInt(1));
				addedFriend.setFriend_fname(instResult.getString(2));
				addedFriend.setFriend_lname(instResult.getString(3));
				addedFriend.setFriend_type(instResult.getString(4));
				
				CallableStatement inFRStmt = con.prepareCall("{CALL insertFriendRequest(?,?)}");
				inFRStmt.setInt(1,userid);
				inFRStmt.setInt(2,addedFriend.getFriend_id());				
				inFRStmt.execute();
				
				ResultSet frenRequestID = inFRStmt.getResultSet();
				if(frenRequestID.next()){					
					int frenRequest_id = frenRequestID.getInt(1);					
					for(Integer circle_id : circle_ids){
						
						CallableStatement inFRCStmt = con.prepareCall("{CALL insertFrenRequestCircles(?,?)}");
						inFRCStmt.setInt(1,frenRequest_id);
						inFRCStmt.setInt(2,circle_id);				
						inFRCStmt.execute();
					}					
				}
				
				
			} 
			else{
				
				return addedFriend;				
			}			
			}
			catch (Exception e){
				e.printStackTrace();
			}
		
		return addedFriend;
	}
	
	public static List<User> getAllUsers(){
		String query = "select * from user;";
		Connection newconn = DataConn.getConn();
		List<User> userslist = new ArrayList<User>();
		
		Statement select;
		try {
			
			select = newconn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			while (result.next()) {
				
				int id = result.getInt(1);
				String fname = result.getString(2);
				String lname = result.getString(3);
				String email = result.getString(6);
				
				User newuser = new User(id,fname,lname,email);
				userslist.add(newuser);
            }
            
            // clean up
            result.close();
            newconn.close();
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userslist;
	}
	
public static String getUsers(){
		
		String query = "select * from user;";
		
		
		Connection newconn = DataConn.getConn();
		
		Statement select;
		String output = "";
		try {
			
			select = newconn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			while (result.next()) {
				
			System.out.println();
				for(int i = 1; i<10; i++){
					output += result.getString(i);
				}
				output += "\n";
				
            }
            
            // clean up
            result.close();
            newconn.close();
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}

	public static String getPasswordHash(String email) {
		String query = "select pw from user where email = '" + email + "';";
		System.out.println(query);
		Connection newconn = DataConn.getConn();
		
		Statement select;
		String output = "";
		try {
			
			select = newconn.createStatement();
			ResultSet result = select.executeQuery(query);
			result.first();
			if (result.getRow() != 0) {
				output = result.getString(1);
	
			} else {
				output = "";
			}
            // clean up
            result.close();
            newconn.close();
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static String getUserId(String email) {
		String query = "select user_id from user where email = '" + email + "';";
		
		Connection newconn = DataConn.getConn();
		
		Statement select;
		String output = "";
		try {
			
			select = newconn.createStatement();
			ResultSet result = select.executeQuery(query);
			result.first();
			output = result.getString(1);
            
            // clean up
            result.close();
            newconn.close();
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			if (e.toString().contains("empty result set")) {
				output = "The username or password you entered is incorrect.";
			}
		}
		
		return output;
	}

	public static String addUser(String fName, String lName, int age, String address,
			Date dob, String gender, String email,
			String pw, String type, String advisor) {
		
		Connection con = DataConn.getConn();
		CallableStatement cStmt;
		String result = "";
		try {		
			
			cStmt = con.prepareCall("{CALL insertUser(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cStmt.setString(1, fName);
			cStmt.setString(2, lName);
			cStmt.setInt(3, age);
			cStmt.setString(4, gender);
			cStmt.setString(5, email);
			cStmt.setString(6, address);
			cStmt.setDate(7, dob);
			cStmt.setString(8, type);
			cStmt.setString(9, pw);
			cStmt.execute();
		       
		    ResultSet rs = cStmt.getResultSet();
		    
		    while (rs.next()) {
		    	result = rs.getString(1);
		    }
		    
		    // clean up
		    rs.close();
		    con.close();
		    
		} catch (SQLException e) {
			System.out.println(e.toString());
			if (e.toString().contains("MySQLIntegrityConstraintViolationException")) {
				result = "The email address " + email + " already exists in the system. Please enter another email address.";
			}
		}
		
		return result;
	}
	
	public static void addAdvisor(String studID, String advName, Date join, Date grad) {
		String[] name = advName.split(" ");
		String query = "select user_id from user where f_name = '" + name[0] + "' AND l_Name = '" + name[1] + "' AND type = 'PROF';";
		System.out.println(query);
		Connection newconn = DataConn.getConn();
		Statement select;
		String advID = "";
		try {
			
			select = newconn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			result.first();
            advID = result.getString(1);
            
            CallableStatement cStmt = newconn.prepareCall("{CALL insertAdvisor(?, ?, ?, ?)}");
			cStmt.setInt(1, Integer.parseInt(studID));
			cStmt.setInt(2, Integer.parseInt(advID));
			cStmt.setDate(3, join);
			cStmt.setDate(4, grad);
			cStmt.execute();
			
            // clean up
            result.close();
            newconn.close();
            
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getAllProfs() {
		String query = "select f_name, l_name from user where type = 'PROF';";
		
		Connection newconn = DataConn.getConn();
		
		Statement select;
		List<String> profs = new ArrayList<String>();
		try {
			
			select = newconn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			while (result.next()) {
				profs.add(result.getString(1) + " " + result.getString(2));
            }
            
            // clean up
            result.close();
            newconn.close();
            
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return profs;
	}
	
	public static String getUserName(String userID) {
		String query = "select f_name from user where user_id = " + userID + ";";
		
		Connection newconn = DataConn.getConn();
		
		Statement select;
		String name = "";
		try {
			
			select = newconn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			result.first();
			name = result.getString(1);
            
            // clean up
            result.close();
            newconn.close();
            
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	 public static ArrayList<Circle> getCircleids(int userid){
	    	
	    	CallableStatement cStmt;
	    	Connection con = DataConn.getConn();
	    	 ArrayList<Circle> circles = new ArrayList<Circle>();
	    	 
	    	 
			try {
				
				cStmt = con.prepareCall("{CALL getCircleids(?)}");
			
				cStmt.setInt(1, userid);
				cStmt.execute();
		       
				ResultSet rs1 = cStmt.getResultSet();
		       
		     
		       while (rs1.next()) {
		    	   
		    	   Circle curcircle = new Circle();
		    	   
		    	   curcircle.setCircle_id(rs1.getInt(1));
		    	   curcircle.setCirclecreated_dt(rs1.getTimestamp(2));
		    	   curcircle.setCircle_name(rs1.getString(3));    	    
		    	   circles.add(curcircle);
		               
		          }


		          
		          rs1.close();
		          cStmt.close();
		          
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
			return circles;
	    	
	    }

	public static ArrayList<User> getUserids(int user_id) {
		
		ArrayList<User> users_list = new ArrayList<User>();
		CallableStatement cStmt;
		try {		
			Connection con = DataConn.getConn();
			cStmt = con.prepareCall("{CALL getallUsersExceptMe(?)}");
			cStmt.setInt(1, user_id);
			cStmt.execute();
		       
		       ResultSet rs1 = cStmt.getResultSet();
		      
		       while (rs1.next()) {
		    	   
		    	   User userprof = new User();
		    	   userprof.setUser_id(rs1.getInt(1));
		    	   userprof.setF_name(rs1.getString(2));
		    	   userprof.setL_name(rs1.getString(3));
		    	   userprof.setAge(rs1.getInt(4));
		    	   userprof.setGender(rs1.getString(5));
		    	   userprof.setEmail(rs1.getString(6));
		    	   userprof.setAddress(rs1.getString(7));
		    	   userprof.setDob(rs1.getTimestamp(8));
		    	   userprof.setType(rs1.getString(9));
		    	   System.out.print("print completed");
		           users_list.add(userprof); 
		          }
		          
		          rs1.close();
		          cStmt.close();
		          
		          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users_list;
	}
	
	public static void addProfessor(String profID, String dept, String research) {
		CallableStatement cStmt;
		try {		
			Connection con = DataConn.getConn();
			cStmt = con.prepareCall("{CALL insertProfessor(?, ?, ?)}");
			cStmt.setInt(1, Integer.parseInt(profID));
			cStmt.setString(2, research);
			cStmt.setString(3, dept);
			cStmt.execute();
			
			// clean up
			cStmt.close();
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addStudent(String studID, Date join, Date grad, String major, float gpa) {
		CallableStatement cStmt;
		try {		
			Connection con = DataConn.getConn();
			cStmt = con.prepareCall("{CALL insertStudent(?, ?, ?, ?, ?)}");
			cStmt.setInt(1, Integer.parseInt(studID));
			cStmt.setDate(2, join);
			cStmt.setDate(3, grad);
			cStmt.setString(4, major);
			cStmt.setFloat(5, gpa);
			cStmt.execute();
			
			// clean up
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addUserInst(String userID, String[] insts, Date join, Date grad) {
		
		ArrayList<String> query = new ArrayList<String>();
		for (int i = 0; i < insts.length; i++) {
			String inst = insts[i].trim();
			query.add("select inst_id from institution where inst_name = '" + inst + "';");
			System.out.println(query.get(i));
		}
		
		try {		
			Connection con = DataConn.getConn();
			for (int i = 0; i < query.size(); i++) {
				Statement select = con.createStatement();
				ResultSet result = select.executeQuery(query.get(i));
				
				CallableStatement cStmt;
				if (!result.next()) {
					cStmt = con.prepareCall("{CALL insertInstitution(?)}");
					cStmt.setString(1, insts[i].trim());
					cStmt.execute();
					
					ResultSet instResult = cStmt.getResultSet();
					instResult.first();
					
					CallableStatement userInstStmt = con.prepareCall("{CALL insertUserInst(?, ?, ?, ?)}");
					userInstStmt.setInt(1, Integer.parseInt(userID));
					userInstStmt.setInt(2, instResult.getInt(1));
					userInstStmt.setDate(3, join);
					userInstStmt.setDate(4, grad);
					userInstStmt.execute();
				} else {
					cStmt = con.prepareCall("{CALL insertUserInst(?, ?, ?, ?)}");
					cStmt.setInt(1, Integer.parseInt(userID));
					cStmt.setInt(2, result.getInt(1));
					cStmt.setDate(3, join);
					cStmt.setDate(4, grad);
					cStmt.execute();
				}
			}
			// clean up
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<User> getFriendRecs(int userID) {
		List<User> friendRecs = new ArrayList<User>();
		CallableStatement cStmt;
		try {		
			Connection con = DataConn.getConn();
			cStmt = con.prepareCall("{CALL findPotentialFriends(?)}");
			cStmt.setInt(1, userID);
			cStmt.execute();
			
			ResultSet rs1 = cStmt.getResultSet();
		      
		    while (rs1.next()) {
		    	User userprof = new User();
		    	userprof.setUser_id(rs1.getInt(1));
		    	userprof.setF_name(rs1.getString(2));
		    	userprof.setL_name(rs1.getString(3));
		        friendRecs.add(userprof); 
		    }
		    // clean up
		    rs1.close();
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return friendRecs;
	}
}
