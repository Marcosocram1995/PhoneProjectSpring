package com.example.demo.user;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.phone.Response;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private AppUserService appUserService;

	@GetMapping("createUser")
	public ResponseEntity<Response> createUser(@RequestParam("name") String name,
			@RequestParam("password") String password) {
		appUserService.createUsers(name, password);
		Response response = buildResponse(Map.of("usersCreated", null));
		return ResponseEntity.ok(response);
	}


	private Response buildResponse(Map<?, ?> data) {
		Response build = Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("phones recovered")
				.Status(HttpStatus.OK)
				.Data(data).build();
		return build;
	}

}
