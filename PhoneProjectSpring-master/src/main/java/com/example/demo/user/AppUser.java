package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.demo.rol.Rol;

@Entity
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "roles")
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Rol> roles = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void addRole(Rol role) {
		this.roles.add(role);
	}

	public String[] getRoles() {
		return this.roles.toArray(new String[0]);
	}
}
