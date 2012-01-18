package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;

public class Photo implements Serializable,JsonSerializable,Comparable<Photo> {
	public Photo(){}
	
	private int photo_id;
	private User uploader;
	private String url;
	private String captions;
	private List<Tag> tags;
	private List<Rating> ratings;
	private double avg_score;
	private Timestamp uploaded_dt;
	private String visibility_choice;
	private List<Integer> visible_frenids;
	private double relScore;
	private int no_of_raters;
	
	public double getAvg_score() {
		return avg_score;
	}
	public void setAvg_score(double avg_score) {
		this.avg_score = avg_score;
	}
	
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCaptions() {
		return captions;
	}
	public void setCaptions(String captions) {
		this.captions = captions;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public Timestamp getUploaded_dt() {
		return uploaded_dt;
	}
	public void setUploaded_dt(Timestamp uploaded_dt) {
		this.uploaded_dt = uploaded_dt;
	}
	public String toJson() {
        Serializer serializer = (Serializer) GWT.create(Serializer.class);
        return serializer.serialize(this);
}
	public List<Integer> getVisible_frenids() {
		return visible_frenids;
	}
	public void setVisible_frenids(List<Integer> visible_frenids) {
		this.visible_frenids = visible_frenids;
	}
	public String getVisibility_choice() {
		return visibility_choice;
	}
	public void setVisibility_choice(String visibility_choice) {
		this.visibility_choice = visibility_choice;
	}
	public User getUploader() {
		return uploader;
	}
	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
	public double getRelScore() {
		return relScore;
	}
	public void setRelScore(double relScore) {
		this.relScore = relScore;
	}
	
	public int compareTo(Photo p) {
		if (this.relScore < p.relScore) {
			return -1;
		} else if (this.relScore == p.relScore) {
			return 0;
		} else {
			return 1;
		}
	}
	public int getNo_of_raters() {
		return no_of_raters;
	}
	public void setNo_of_raters(int no_of_raters) {
		this.no_of_raters = no_of_raters;
	}
}
