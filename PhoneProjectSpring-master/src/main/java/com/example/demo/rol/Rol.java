package com.example.demo.rol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.user.AppUser;

@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "users")
	@ManyToMany(cascade = CascadeType.ALL)
	private List<AppUser> appusers;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<AppUser> getAppusers() {
		return appusers;
	}

	public void addUser(AppUser appUser) {
		this.appusers.add(appUser);
	}

	public Rol() {

	}

	public Rol(String name) {
		super();
		this.name = name;
		this.appusers = new ArrayList<>();
	}
}
