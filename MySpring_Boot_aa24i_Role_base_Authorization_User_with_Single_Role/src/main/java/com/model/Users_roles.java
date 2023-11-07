package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_roles")
public class Users_roles {
	
	@Id
	private int user_id;
	private int role_id;

	public Users_roles() {
		
	}

	public Users_roles(int user_id, int role_id) {
		
		
		this.user_id = user_id;
		this.role_id = role_id;
	}
	


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "Users_roles [ user_id=" + user_id + ", role_id=" + role_id + "]";
	}

	
	
	
	

}
