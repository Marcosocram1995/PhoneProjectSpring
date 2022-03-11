package com.example.demo.model.phone;

public class AntutuCalculator implements Calculator {

	private final int ANTUTU_MULTIPLIER = 12000;
	private float ramCapacity;
	private float processorRate;

	public AntutuCalculator(Processor processor, Ram ram) {
		this.ramCapacity = ram.getCapacity();
		this.processorRate = processor.calculateResult();
	}

	@Override
	public float calculate() {
		float capacity = this.ramCapacity + this.ramCapacity;
		return (this.processorRate + capacity) * ANTUTU_MULTIPLIER;
	}
}