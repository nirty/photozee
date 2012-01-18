package com.cis550.photozee.server;

import java.sql.Date;
import java.util.List;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.cis550.photozee.client.RegisterService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.cis550.photozee.server.dataaccess.UserDB;

public class RegisterServiceImpl extends RemoteServiceServlet implements
		RegisterService {

	@Override
	public String register(String fName, String lName, String address,
			String month, String day, String year, String gender, String inst, String email,
			String pw, String type, String advisor, String joinYear, String gradYear,
			String major, String gpa, String dept, String research) {
		// Put month, day, year into a proper date for SQL insertion
		// Do the same for gender and type
		DateTimeFormatter format = DateTimeFormat.forPattern("MMM");
	    DateTime instance = format.parseDateTime(month);
	    int mo_num = instance.getMonthOfYear();
		Date dob = new Date(Integer.parseInt(year) - 1900, mo_num - 1, Integer.parseInt(day));
		String sex = gender.equals("Male") ? "M" : "F";
		
		// Calculate age
		DateTime now = new DateTime();
		DateMidnight bday = new DateMidnight(Integer.parseInt(year), mo_num, Integer.parseInt(day));
		int age = Years.yearsBetween(bday, now).getYears();
		
		// Split institutions into separate strings
		String[] insts = inst.split(",");
		
		// Convert joinYear and gradYear to valid date objects
		Date join;
		Date grad;
		if (joinYear != null && gradYear != null) {
			join = new Date(Integer.parseInt(joinYear) - 1900, 0, 1);
			grad = new Date(Integer.parseInt(gradYear) - 1900, 0, 1);
		} else {
			join = null;
			grad = null;
		}
		
		// Insert data into tables
		String userID = UserDB.addUser(fName.trim(), lName.trim(), age, 
				address.trim(), dob, sex, email, pw, type, advisor);
		UserDB.addUserInst(userID, insts, join, grad);
		if (type.equals("STUD")) {
			// Convert GPA to floating point number
			float gpaNum = Float.parseFloat(gpa);
			
			UserDB.addAdvisor(userID, advisor, join, grad);
			UserDB.addStudent(userID, join, grad, major.trim(), gpaNum);
		} else if (type.equals("PROF")) {
			UserDB.addProfessor(userID, dept.trim(), research.trim());
		}
		return userID;
	}
	public List<String> getAllProfs() {
		return UserDB.getAllProfs();
	}
	
}
