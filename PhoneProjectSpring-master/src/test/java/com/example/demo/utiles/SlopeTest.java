package com.example.demo.utiles;

import org.junit.jupiter.api.Test;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.SlopeCalculator;
import com.example.demo.model.phone.Phone.BuilderPhone;

class SlopeTest {

	@Test
	void test() {
		Slope slope = new Slope(541.95f);
		slope.nextDay();
		System.out.println(slope.getCoordinateX());
		slope.nextDay();
		System.out.println(slope.getCoordinateX());
		slope.nextDay();
		System.out.println(slope.getCoordinateX());
		System.out.println(slope.getHistory(0));
	}

	@Test
	void testCalculator() {
		Phone phone = new BuilderPhone("Samsung", "AC 200").builder();
		System.out.println(phone.getPrizeWithCurrencyType());
		SlopeCalculator slopeCalculator = new SlopeCalculator(phone);

		for (int i = 0; i < 5; i++) {
			phone.setPrice(slopeCalculator.calculate());
			System.out.println(phone.getPrizeWithCurrencyType());
		}
	}
}
