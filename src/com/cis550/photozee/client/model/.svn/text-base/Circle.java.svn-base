package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;

public class Circle implements Serializable,JsonSerializable {	
	
	private int circle_id;
	private String circle_name;
	private Timestamp circlecreated_dt;
	private List<Integer> friend_ids;
	private List<String> friend_names;
	private List<FriendMapping> friend_maps;
	
	
	public Circle(){}
	
	public Circle(int circleid,String circlename,List<Integer> friendlist){
		circle_id = circleid;
		circle_name = circlename;
		friend_ids = friendlist;		
	}
	
	
	public int getCircle_id() {
		return circle_id;
	}
	public void setCircle_id(int circle_id) {
		this.circle_id = circle_id;
	}
	public String getCircle_name() {
		return circle_name;
	}
	public void setCircle_name(String circle_name) {
		this.circle_name = circle_name;
	}
	public Timestamp getCirclecreated_dt() {
		return circlecreated_dt;
	}
	public void setCirclecreated_dt(Timestamp circlecreated_dt) {
		this.circlecreated_dt = circlecreated_dt;
	}
	public List<Integer> getFriend_ids() {
		return friend_ids;
	}
	public void setFriend_ids(List<Integer> friend_ids) {
		this.friend_ids = friend_ids;
	}

	public List<String> getFriend_names() {
		return friend_names;
	}

	public void setFriend_names(List<String> friend_names) {
		this.friend_names = friend_names;
	}

	public String toJson() {
        Serializer serializer = (Serializer) GWT.create(Serializer.class);
        return serializer.serialize(this);
	}
	
	public List<FriendMapping> getFriend_maps() {
		return friend_maps;
	}

	public void setFriend_maps(List<FriendMapping> friend_maps) {
		this.friend_maps = friend_maps;
	}


}
