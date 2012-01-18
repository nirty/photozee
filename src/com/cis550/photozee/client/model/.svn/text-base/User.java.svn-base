package com.cis550.photozee.client.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;


public class User implements Serializable,JsonSerializable {
	
	public User()
	{}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String f_name;
	private String l_name;
	private int age;
	private String gender;
	private String email;
	private String address;
	private Timestamp dob;
	private String type;
	private String password;
	private List<String> interests;
	private Student student;
	private Professor professor;
	
	public List<String> getInterests() {
		return interests;
	}


	public void setInterests(List<String> interests) {
		this.interests = interests;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	
	
	public User(int userid,String fname,String lname,String email)
	{
		this.user_id = userid;
		this.f_name = fname;
		this.l_name =lname;
		this.email = email;
	}
	

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toJson() {
        Serializer serializer = (Serializer) GWT.create(Serializer.class);
        return serializer.serialize(this);
}
	
	
	

}
