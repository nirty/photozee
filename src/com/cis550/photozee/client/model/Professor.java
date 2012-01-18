package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;

public class Professor implements Serializable {
	
	private String researchArea;
	private String department;
	private List<Advisorsees> advisees;
	
	
	public String getResearchArea() {
		return researchArea;
	}
	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<Advisorsees> getAdvisees() {
		return advisees;
	}
	public void setAdvisees(List<Advisorsees> advisees) {
		this.advisees = advisees;
	}
	

}
