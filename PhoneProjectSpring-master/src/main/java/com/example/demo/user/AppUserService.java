package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.security.ApplicationUserRol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
	private List<AppUser> users;

	@Autowired
	private UserRepository userRepository;

	public List<AppUser> getUsers() {
		return users;
	}

	public AppUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		createUsers();
		save();
	}

	private void save() {
		this.userRepository.saveAll(this.users);
	}

	private void createUsers() {
		users = new ArrayList<>();
		users.add(new AppUser("marcos", "123"));
		addRoleAdminToUser("marcos");
	}

	public void addRoleAdminToUser(String username) {
		findUserByUsername(username).ifPresent((a) -> a.addRole(ApplicationUserRol.ADMIN.name()));
	}

	private Optional<AppUser> findUserByUsername(String username) {
		return users.stream().filter((a) -> a.getUsername().equals(username)).findFirst();
	}
}