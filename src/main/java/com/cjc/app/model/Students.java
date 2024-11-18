package com.cjc.app.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students {

	private List<Student> stulist;

	public List<Student> getStulist() {
		return stulist;
	}

	public void setStulist(List<Student> stulist) {
		this.stulist = stulist;
	}
	
	
}
