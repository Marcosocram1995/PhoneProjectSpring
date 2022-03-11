package com.example.demo.IntervalBattery;

import com.example.demo.model.phone.Battery;

public class FifthInterval extends BaseHandler{
	
	private final int min = 4000;
	private final int max = 4999;
	
	@Override
	public int handle(Battery batery) {
		if (batery.getMAhNumber()>=min && batery.getMAhNumber()<=max) {
			return 25;
		}
		return super.handle(batery);
	}

}
