package com.example.demo.phoneTests;

import org.junit.jupiter.api.Test;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.Phone.BuilderPhone;
import com.example.demo.utiles.Slope;

class PriceTest {

	@Test
	void test() {
		Phone phone = new BuilderPhone("Samsung", "AC 200").builder();
		Slope slope = new Slope(phone.getPrizeWithoutCurrencyType());
		System.out.println(phone.getValoration());
		System.out.println(phone.getPrizeWithCurrencyType());
		if (phone.getValoration() < 5.00f) {
			slope.nextDay();
			phone.setPrice(slope.getCoordinateX());
		}
		System.out.println(phone.getPrizeWithCurrencyType());
	}
}
