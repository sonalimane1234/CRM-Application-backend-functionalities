package com.crm.dto;

public class LoginResponse {

	private String message;
    private String role;
    
    
	public LoginResponse() {
		super();
	}
	public LoginResponse(String message, String role) {
		super();
		this.message = message;
		this.role = role;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}
