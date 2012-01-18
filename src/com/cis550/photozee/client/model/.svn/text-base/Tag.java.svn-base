package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;

public class Tag implements Serializable,JsonSerializable {
	public Tag(){}
	
	private int tag_id;	
	private String tag;
	private int tagger_id;
	private Timestamp tagged_dt;
	
	
	public Tag(String tagg,int tagger)
	{
		this.tag = tagg;
		this.tagger_id = tagger;
	}
	
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getTagger_id() {
		return tagger_id;
	}
	public void setTagger_id(int tagger_id) {
		this.tagger_id = tagger_id;
	}
	public Timestamp getTagged_dt() {
		return tagged_dt;
	}
	public void setTagged_dt(Timestamp tagged_dt) {
		this.tagged_dt = tagged_dt;
	}
	public String toJson() {
        Serializer serializer = (Serializer) GWT.create(Serializer.class);
        return serializer.serialize(this);
}
	

}
