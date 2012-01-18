package com.cis550.photozee.client;

import java.util.List;

import com.cis550.photozee.client.model.User;
import com.cis550.photozee.shared.FieldVerifier;
import com.google.gwt.user.client.History;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Photozee implements EntryPoint {

	public void onModuleLoad() {
		
		
		String initToken = History.getToken();
    	
	    if (initToken.length() == 0) {
	      History.newItem("login");
	    }
	    
    	History.addValueChangeHandler(new MyHistoryListener());
    	History.fireCurrentHistoryState(); 
    }

	
}
