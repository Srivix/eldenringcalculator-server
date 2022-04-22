package com.eldenringcalculator.user.model;

import java.util.List;

import com.eldenringcalculator.role.model.RoleDto;

public class UserDto {
	
	private String email;
	private String username;
	private List<RoleDto> role;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the role
	 */
	public List<RoleDto> getRoles() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRoles(List<RoleDto> roles) {
		this.role = roles;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}