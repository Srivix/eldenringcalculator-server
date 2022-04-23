package com.eldenringcalculator.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.eldenringcalculator.role.model.RoleEntity;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@NotEmpty
	@Email(message = "Email should be valid")
	@Column(unique = true, name = "email", nullable = false)
	private String email;
	
	@NotEmpty
	@Size(min= 4)
	@Column(unique = true, name = "username", nullable = false)
	private String username;
	
	@NotEmpty
	@Size(min=8)
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user"),
	inverseJoinColumns=@JoinColumn(name="role"),
	uniqueConstraints = {@UniqueConstraint(columnNames= {"user","role"})})
	private List<RoleEntity> roles;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @return the role
	 */
	public List<RoleEntity> getRoles() {
		return roles;
	}

	/**
	 * @param role the role to set
	 */
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

}
