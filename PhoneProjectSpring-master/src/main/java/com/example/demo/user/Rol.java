package com.example.demo.user;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Rol {

	@Column(name = "id_rol")
	private int id;

	@Column(name = "rol")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rol(String name) {
		super();
		this.name = name;
	}

	public Rol() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Rol [name=" + name + "]";
	}
}
