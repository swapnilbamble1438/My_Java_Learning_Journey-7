package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private String sname;
	private String scity;

	public Student() {
		
	}

	public Student(Long sid, String sname, String scity) {
		this.sid = sid;
		this.sname = sname;
		this.scity = scity;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
	}
	
	
	
	
	
	
	
	
	

}
