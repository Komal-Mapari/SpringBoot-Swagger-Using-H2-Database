package com.cjc.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Student {

	@Id
	private Integer rollno;
	private String name;
	private String address;
	private String email;
	private Float marks;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + ", email=" + email + ", marks="
				+ marks + "]";
	}
	
	
}
