package com.example.demo.model.phone;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("phone")
public class PhoneController {

	@Autowired
	private PhoneService phoneService;

	@GetMapping("list")
	public ResponseEntity<Response> list() {
		Response response = buildResponse(Map.of("allPhones", phoneService.getPhoneList()));
		return ResponseEntity.ok(response);
	}

	@GetMapping("findByBrand")
	public ResponseEntity<Response> findByBrand(@RequestParam("brand") String brand) {
		brand.toLowerCase();
		Response response = buildResponse(Map.of("brandPhones", phoneService.findByBrand(brand)));
		return ResponseEntity.ok(response);
	}

	@GetMapping("findById")
	public ResponseEntity<Response> findById(@RequestParam("id") int id) {
		Response response = buildResponse(Map.of("idPhone", phoneService.findById(id)));
		return ResponseEntity.ok(response);
	}

	private Response buildResponse(Map<?, ?> data) {
		Response build = Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("phones recovered")
				.Status(HttpStatus.OK)
				.Data(data)
				.build();
		return build;
	}
}