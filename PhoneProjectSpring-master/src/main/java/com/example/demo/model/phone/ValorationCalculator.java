package com.example.demo.model.phone;

import com.example.demo.utiles.Utiles;

public class ValorationCalculator implements Calculator {
	private final int MAX_VALORATION = 10;
	private final int VALORATION_DIVISION = 10000;
	private final int FOURTH_OF = 4;
	private long antutu;

	public ValorationCalculator(long antutu) {
		super();
		this.antutu = antutu;
	}

	@Override
	public float calculate() {
		float valoration = (this.antutu / this.VALORATION_DIVISION);
		valoration = valoration / this.FOURTH_OF;
		if (valoration > this.MAX_VALORATION) {
			valoration = this.MAX_VALORATION;
		}
		return Utiles.convertNumberTwoDecimals(valoration);
	}
}