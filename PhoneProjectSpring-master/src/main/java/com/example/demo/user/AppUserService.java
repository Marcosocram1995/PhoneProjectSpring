package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.rol.Rol;
import com.example.demo.rol.RolRepository;
import com.example.demo.rol.RolService;
import com.example.demo.security.ApplicationUserRol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserService {
	private List<AppUser> users;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolRepository rolRepository;

	public List<AppUser> getUsers() {
		return users;
	}

	public AppUserService(UserRepository userRepository, RolRepository rolRepository) {
		this.userRepository = userRepository;
		this.rolRepository = rolRepository;
		createUsers();
		save();
	}

	private void save() {
		this.userRepository.saveAll(this.users);
	}

	private void createUsers() {
		users = new ArrayList<>();
		users.add(new AppUser("marcos", "123"));
		users.get(0).addRole(rolRepository.findByName(ApplicationUserRol.ADMIN.name()));
	}

//	public void addRoleToUser(String username, String role) {
//		findUserByUsername(username).ifPresent((a) -> {
//			a.addRole();
//		});
//	}

	private Optional<AppUser> findUserByUsername(String username) {
		return users.stream().filter((a) -> a.getUsername().equals(username)).findFirst();
	}
}