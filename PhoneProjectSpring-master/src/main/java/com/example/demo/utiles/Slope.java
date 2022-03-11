package com.example.demo.utiles;

import java.util.ArrayList;

public class Slope {
	private float coordinateX;
	private int coordinateY = 0;
	private int slope = -20;
	private ArrayList<Float> history;

	public float getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}

	public float getHistory(int coordinateY) {
		return this.history.get(coordinateY);
	}

	public ArrayList<Float> getArrayHistory() {
		return this.history;
	}

	public Slope(float coordinateX) {
		this.coordinateX = coordinateX;
		this.history = new ArrayList<>();
	}

	public void nextDay() {
		this.coordinateX = this.coordinateX + this.slope;
		if (this.coordinateX < 0) {
			this.coordinateX = 0;
		}
		this.history.add(this.coordinateY, coordinateX);
		this.coordinateY++;
	}
}
