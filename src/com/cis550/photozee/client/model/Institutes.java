package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;

public class Institutes implements Serializable,JsonSerializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Institutes(){}
	 
	 private int instituition_id;
	 private String institution_name;
	 private Timestamp start_year;
	 private Timestamp end_year;
	 
	 public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	public Timestamp getStart_year() {
		return start_year;
	}
	public void setStart_year(Timestamp start_year) {
		this.start_year = start_year;
	}
	public Timestamp getEnd_year() {
		return end_year;
	}
	public void setEnd_year(Timestamp end_year) {
		this.end_year = end_year;
	}
	public int getInstituition_id() {
		return instituition_id;
	}
	public void setInstituition_id(int instituition_id) {
		this.instituition_id = instituition_id;
	}

	public String toJson() {
        Serializer serializer = (Serializer) GWT.create(Serializer.class);
        return serializer.serialize(this);
}

}
