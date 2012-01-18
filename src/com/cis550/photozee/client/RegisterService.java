package com.cis550.photozee.client;


import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@RemoteServiceRelativePath("RegisterService")
public interface RegisterService extends RemoteService {
	public String register(String fName, String lName, String address, String month, 
			String day, String year, String gender, String inst, String email, String pw, 
			String type, String advisor, String joinYear, String gradYear,
			String major, String gpa, String dept, String research);
	public List<String> getAllProfs();
}
