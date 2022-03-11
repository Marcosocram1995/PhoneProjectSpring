package com.example.demo.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRol {
	// usar Sets me obliga a importar la dependencia GUAVA

	ADMIN(ApplicationUserPermission.USER_READ, ApplicationUserPermission.USER_WRITE),
	GUEST(ApplicationUserPermission.USER_READ);

	private final Set<ApplicationUserPermission> permissions;

	ApplicationUserRol(ApplicationUserPermission... permisions) {
		this.permissions = new HashSet();
		for (ApplicationUserPermission applicationUserPermission : permisions) {
			this.permissions.add(applicationUserPermission);
		}
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}

	public static List<String> getRolNames() {
		List<String> rolList = new ArrayList<>();
		for (ApplicationUserRol rol : values()) {
			rolList.add(rol.name());
		}
		return rolList;
	}

	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		Set<SimpleGrantedAuthority> permissionsAuth = getPermissions().stream()
				// el map crea una nueva lista donde sustituye cada permiso por una authority de
				// tipo simple
				// recuerda que getPermision() te da "student:read" o algo asi
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		// le add el usuario actual de la enumeracion y volvemos al
		// ApllicationSecurityConfig
		permissionsAuth.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissionsAuth;
	}
}
