package com.example.demo.utiles;

import java.text.DecimalFormat;

public class Utiles {

	public static int getRandomWholeNumber(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

	public static float getRandomDecimalNumber(int min, int max) {
		return (float) (Math.random() * (max - min) + min);
	}

	public static float convertNumberTwoDecimals(float result) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String format = decimalFormat.format(result);
		format = format.replace(',', '.');
		return Float.valueOf(format).floatValue();
	}
}
