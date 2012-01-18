package com.cis550.photozee.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	 public void login(String pw, String email, AsyncCallback<String> async);
}
