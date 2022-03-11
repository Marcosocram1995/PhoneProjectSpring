package com.example.demo.rol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.security.ApplicationUserRol;

@Service
public class RolService {
	@Autowired
	private RolRepository rolRepository;

	public RolService(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
		// saveRoles();
	}

	public List<Rol> getRolesFromDB() {
		return (List<Rol>) this.rolRepository.findAll();
	}
	
	private void saveRoles() {
		this.rolRepository.saveAll(getRolesFromAPP());
	}

	private List<Rol> getRolesFromAPP() {
		List<Rol> roles = new ArrayList<>();
		List<String> rolNames = ApplicationUserRol.getRolNames();
		rolNames.forEach(rol -> {
			Rol rolCreated = new Rol(rol);
			roles.add(rolCreated);
		});
		return roles;
	}
}
