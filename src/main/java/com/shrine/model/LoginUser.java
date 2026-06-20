package com.shrine.model;

public class LoginUser {
	private String userId;
	private String role;
	
	public LoginUser(String userId,String role) {
		this.userId = userId;
		this.role = role;
	}
	
	public String getUserId() {return userId;}
	public String getRole() {return role;}
	
	public boolean isAdmin() {return "ADMIN".equals(role);}
	public boolean isStaff() {return "STAFF".equals(role);}
	

}
