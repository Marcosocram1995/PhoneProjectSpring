package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
		return this.users;
	}

	public void save(List<UserDetails> usersDetails) {
		for (int i = 0; i < usersDetails.size(); i++) {
			this.users.get(i).setPassword(usersDetails.get(i).getPassword());
		}
		this.userRepository.saveAll(this.users);
	}

	public AppUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.users = new ArrayList<>();
	}

	public void createUsers(String name, String password) {
		this.users.add(new AppUser(name, password));
		addRoleAdminToUser(name);
	}

	private void addRoleAdminToUser(String username) {
		findUserByUsername(username).ifPresent((a) -> a.addRole(ApplicationUserRol.ADMIN.name()));
	}

	private Optional<AppUser> findUserByUsername(String username) {
		return this.users.stream().filter((a) -> a.getUsername().equals(username)).findFirst();
	}
}