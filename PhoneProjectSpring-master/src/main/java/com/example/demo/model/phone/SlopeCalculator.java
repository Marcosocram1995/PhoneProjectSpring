package com.example.demo.model.phone;

import com.example.demo.utiles.Slope;
import com.example.demo.utiles.Utiles;

public class SlopeCalculator implements Calculator {
	private Slope slope;
	private float valoration;
	private float coordinateX;

	public SlopeCalculator(Phone phone) {
		this.valoration = phone.getValoration();
		this.coordinateX = phone.getPrizeWithoutCurrencyType();
		this.slope = new Slope(coordinateX);
	}

	public float getCoordinateX() {
		return coordinateX;
	}

	public float getValoration() {
		return valoration;
	}

	public Slope getSlope() {
		return slope;
	}

	@Override
	public float calculate() {
		if (this.valoration < 5.0f) {
			slope.setSlope(-20);
			slope.nextDay();
			coordinateX = slope.getCoordinateX();
		}

		if (this.valoration == 10.0f) {
			slope.setSlope(20);
			slope.nextDay();
			coordinateX = slope.getCoordinateX();
		}
		return Utiles.convertNumberTwoDecimals(coordinateX);
	}
}
