package com.example.demo.model.phone;

import java.util.ArrayList;

import com.example.demo.IntervalBattery.DefaultPorcentage;
import com.example.demo.IntervalBattery.FifthInterval;
import com.example.demo.IntervalBattery.FirstInterval;
import com.example.demo.IntervalBattery.FourthInterval;
import com.example.demo.IntervalBattery.Handler;
import com.example.demo.IntervalBattery.SecondInterval;
import com.example.demo.IntervalBattery.SeventhInterval;
import com.example.demo.IntervalBattery.SixthInterval;
import com.example.demo.IntervalBattery.ThirdInterval;

public class BatteryPercentageCalculator implements Calculator {

	ArrayList<Handler> intervalListBattery;
	private Battery battery;
	Handler initial;

	public BatteryPercentageCalculator(Battery batery) {
		this.battery = batery;
		intervalListBattery = new ArrayList<Handler>();
		fillArrayIntervals();
		addNext(intervalListBattery);
	}

	@Override
	public float calculate() {
		return initial.handle(this.battery);
	}

	private void fillArrayIntervals() {
		intervalListBattery.add(new FirstInterval());
		intervalListBattery.add(new SecondInterval());
		intervalListBattery.add(new ThirdInterval());
		intervalListBattery.add(new FourthInterval());
		intervalListBattery.add(new FifthInterval());
		intervalListBattery.add(new SixthInterval());
		intervalListBattery.add(new SeventhInterval());
		intervalListBattery.add(new DefaultPorcentage());
	}

	private void addNext(ArrayList<Handler> intervalListBattery) {
		initial = intervalListBattery.get(0);
		for (int i = 0; i < intervalListBattery.size() - 1; i++) {
			intervalListBattery.get(i).setNext(intervalListBattery.get(i + 1));
		}
	}

}
