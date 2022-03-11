package com.example.demo.phoneTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.phone.Processor;


class ProcessorTest {

	@Test
	void test() {
		Processor processor = new Processor(5);
		assertEquals(5, processor.getCoreNumber());
		System.out.println(processor);
	}
}