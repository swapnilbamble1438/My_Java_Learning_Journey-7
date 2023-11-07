package com.model;

public class EmailResponse {
	
	String token;
	
	public EmailResponse(String token)
	{
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "EmailResponse [token=" + token + "]";
	}
	
	

}
