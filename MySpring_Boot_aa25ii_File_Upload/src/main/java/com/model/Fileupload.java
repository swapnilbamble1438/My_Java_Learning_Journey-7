package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Fileupload")
public class Fileupload {
	
	@Id
	@GeneratedValue
	(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String image;
	
	public Fileupload() {
	
	}

	public Fileupload(int id, String name, String image) {

		this.name = name;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Fileupload [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	
	
}
