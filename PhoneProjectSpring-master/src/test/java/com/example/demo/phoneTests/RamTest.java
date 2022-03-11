package com.example.demo.phoneTests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.phone.Ram;

class RamTest {

	@Test
	void test() {
		Ram ram = new Ram(4);
		System.out.println(ram.getCapacity());
	}
}