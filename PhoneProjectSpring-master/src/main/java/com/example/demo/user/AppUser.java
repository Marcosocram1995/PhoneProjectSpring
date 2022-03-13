package com.example.demo.user;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import net.bytebuddy.asm.Advice.This;

@Entity
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	@ElementCollection
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "roles")
	private Collection<String> roles = new ArrayList<>();

	public Long getId() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public AppUser(String username, String password, Collection<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles.addAll(roles);
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	public String[] getRoles() {
		return this.roles.toArray(new String[0]);
	}
}
