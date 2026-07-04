package com.shrine.model;

public class LoginUser {
	private Long staffAccountId;
	private String userId;
	private String staffName;
	private String role;
	
	public LoginUser(Long staffAccountId,String userId,String staffName,String role) {
		this.staffAccountId = staffAccountId;
		this.userId = userId;
		this.staffName = staffName;
		this.role = role;
	}
	
	public Long getStaffAccountId() {return staffAccountId;}
	public String getUserId() {return userId;}
	public String getStaffName() {return staffName;}
	public String getRole() {return role;}
	
	public boolean isAdmin() {return "ADMIN".equals(role);}
	public boolean isStaff() {return "STAFF".equals(role);}
	

}
