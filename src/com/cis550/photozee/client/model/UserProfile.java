package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.Serializer;

//This class is an extension of basic User class.
// this will extend USer and contains 
//details about Photos
//Circles
//institutions
// - Except for Student or Advisor. Those class will implement this..

public class UserProfile extends User implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserProfile(){}
	
	private List<Photo> photos;
	private List<Institutes> institutions;
	private List<Circle> circles;

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Institutes> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<Institutes> institutions) {
		this.institutions = institutions;
	}

	public List<Circle> getCircles() {
		return circles;
	}

	public void setCircles(List<Circle> circles) {
		this.circles = circles;
	}
	// details about Photos

	public List<String> getFriendnames(int circleid){
		
		List<Circle> circles = this.getCircles();
		for(Circle circle: circles){
			if(circle.getCircle_id()==circleid){
				return circle.getFriend_names();
			}
		}
		return null;
	}
	
	public ArrayList<Integer> getFriendIdsofAllCircles(){
		
		
		ArrayList<Integer> fren_ids = new ArrayList<Integer>();
		
		List<Circle> list_of_circles = this.getCircles();
		
		for(Circle circle:list_of_circles){
			fren_ids.addAll(circle.getFriend_ids());
		}
		return fren_ids;
		
	}
	
	public String toJson() {
        Serializer serializer = (Serializer) GWT.create(Serializer.class);
        return serializer.serialize(this);
	}


}
