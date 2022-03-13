package com.example.demo.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
		createUsers();
	}

	private void createUsers() {
		this.users = new ArrayList<>();
		this.users.add(new AppUser("marcos", "123"));
		addRoleAdminToUser("marcos");
	}

	private void addRoleAdminToUser(String username) {
		findUserByUsername(username).ifPresent((a) -> a.addRole(ApplicationUserRol.ADMIN.name()));
	}

	private Optional<AppUser> findUserByUsername(String username) {
		return this.users.stream().filter((a) -> a.getUsername().equals(username)).findFirst();
	}
}