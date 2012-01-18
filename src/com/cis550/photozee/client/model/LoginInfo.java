package com.cis550.photozee.client.model;

import java.io.Serializable;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;

public class LoginInfo implements Serializable {
      private boolean loggedIn = false;
	  private String loginUrl;
	  private String logoutUrl;
	  private String emailAddress;
	  private String nickname;
	  private String password;

	  public boolean isLoggedIn() {
	    return loggedIn;
	  }

	  public void setLoggedIn(boolean loggedIn) {
	    this.loggedIn = loggedIn;
	  }

	  public String getLoginUrl() {
	    return loginUrl;
	  }

	  public void setLoginUrl(String loginUrl) {
	    this.loginUrl = loginUrl;
	  }

	  public String getLogoutUrl() {
	    return logoutUrl;
	  }

	  public void setLogoutUrl(String logoutUrl) {
	    this.logoutUrl = logoutUrl;
	  }

	  public String getEmailAddress() {
	    return emailAddress;
	  }

	  public void setEmailAddress(String emailAddress) {
	    this.emailAddress = emailAddress;
	  }

	  public String getNickname() {
	    return nickname;
	  }

	  public void setNickname(String nickname) {
	    this.nickname = nickname;
	  }
	  
	  public String getPassword() {
		  return password;
	  }
	  
	  public void setPassword(String password) {
		  this.password = password;
	  }
	
}
