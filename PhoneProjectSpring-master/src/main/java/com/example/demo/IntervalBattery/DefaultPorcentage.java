package com.example.demo.IntervalBattery;

import com.example.demo.model.phone.Battery;

public class DefaultPorcentage extends BaseHandler {

	@Override
	public int handle(Battery request) {
		return 3;
	}
}