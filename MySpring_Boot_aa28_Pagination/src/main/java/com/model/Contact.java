package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private String cnickname;
	private String cwork;
	private String cemail;
	private String cphone;
	private String cimage;
	@Column(length = 100000)
	private String cdescription;
	
	
	public Contact() {
		
	}

	public Contact(int cid, String cname, String cnickname, String cwork, String cemail, String cphone, String cimage,
			String cdescription) {
	
		this.cid = cid;
		this.cname = cname;
		this.cnickname = cnickname;
		this.cwork = cwork;
		this.cemail = cemail;
		this.cphone = cphone;
		this.cimage = cimage;
		this.cdescription = cdescription;
		
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCnickname() {
		return cnickname;
	}

	public void setCnickname(String cnickname) {
		this.cnickname = cnickname;
	}

	public String getCwork() {
		return cwork;
	}

	public void setCwork(String cwork) {
		this.cwork = cwork;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCimage() {
		return cimage;
	}

	public void setCimage(String cimage) {
		this.cimage = cimage;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}



	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", cname=" + cname + ", cnickname=" + cnickname + ", cwork=" + cwork
				+ ", cemail=" + cemail + ", cphone=" + cphone + ", cimage=" + cimage + ", cdescription=" + cdescription
				+ "]";
	}
	
	
	
	
	
	

}
