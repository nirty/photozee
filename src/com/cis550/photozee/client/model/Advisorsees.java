package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Advisorsees implements Serializable {
	
	private int advisorsees_id;	
	private Timestamp start_year;
	private Timestamp end_year;
	
	public int getAdvisorsees_id() {
		return advisorsees_id;
	}
	public void setAdvisorsees_id(int advisorsees_id) {
		this.advisorsees_id = advisorsees_id;
	}
	public Timestamp getStart_year() {
		return start_year;
	}
	public void setStart_year(Timestamp timestamp) {
		this.start_year = timestamp;
	}
	public Timestamp getEnd_year() {
		return end_year;
	}
	public void setEnd_year(Timestamp end_year) {
		this.end_year = end_year;
	}

}
