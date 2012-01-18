package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;

public class Rating implements Serializable,JsonSerializable {
	
	public Rating(){
		
	}
	
	private int scorer_id;
	private int score;
	private Timestamp scored_dt;
	
	public Rating(int scorer,int scores){
		this.score = scores;
		this.scorer_id = scorer;
	}
	public int getScorer_id() {
		return scorer_id;
	}
	public void setScorer_id(int scorer_id) {
		this.scorer_id = scorer_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Timestamp getScored_dt() {
		return scored_dt;
	}
	public void setScored_dt(Timestamp scored_dt) {
		this.scored_dt = scored_dt;
	}
	public String toJson() {
        Serializer serializer = (Serializer) GWT.create(Serializer.class);
        return serializer.serialize(this);
}

	

}
