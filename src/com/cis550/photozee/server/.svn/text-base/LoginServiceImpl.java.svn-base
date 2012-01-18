package com.cis550.photozee.server;

import com.cis550.photozee.client.LoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.cis550.photozee.server.dataaccess.UserDB;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {
	
	private static final long serialVersionUID = 1L;
	@Override
	public String login(String pw_attempt, String email) {
		String userID = UserDB.getUserId(email);
		if (!userID.startsWith("33")) {
			return userID;
		} else {
			boolean valid = pw_attempt.equals(UserDB.getPasswordHash(email));
			if (valid) {
				return userID;
			} else {
				return "0";
			}
		}		
		// BCrypt portion:
		//String hashFromDB = UserDB.getPasswordHash(pw);
		//boolean valid = BCrypt.checkpw(password, hashFromDB);
	}

}
