package com.example.demo.IntervalBattery;

import com.example.demo.model.phone.Battery;

public interface Handler {

	public void setNext(Handler handler);

	public int handle(Battery request);
}
