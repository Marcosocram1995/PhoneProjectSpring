package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.ObjectMother.PhoneList;
import com.example.demo.model.phone.PhoneRepository;

@SpringBootTest
class PhoneProyectApplicationTests {

	@Autowired
	private PhoneRepository phoneRepository;

	@Test
	void contextLoads() {
		PhoneList generator = new PhoneList();
		phoneRepository.saveAll(generator.getPhoneList());
	}
}