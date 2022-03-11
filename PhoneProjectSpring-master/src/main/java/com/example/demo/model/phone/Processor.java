package com.example.demo.model.phone;

import java.text.DecimalFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Embeddable
public class Processor {

	private int coreNumber;
	private String clockRate;

	public Processor() {
		super();
	}

	public Processor(int coreNumber) {
		this.coreNumber = coreNumber;
		this.clockRate = calculateVelocity();
	}

	private String calculateVelocity() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String format = "";
		if (coreNumber <= 4) {
			format = decimalFormat.format(Math.random() * (2 - 1) + 1);
		}
		if (coreNumber > 4) {
			format = decimalFormat.format(Math.random() * (3.5 - 2) + 2);
		}
		return format.replace(",", ".");
	}

	public float calculateResult() {
		return Float.valueOf(clockRate) + (coreNumber * Float.valueOf(clockRate));
	}

	public int getCoreNumber() {
		return coreNumber;
	}

	public void setCoreNumber(int coreNumber) {
		this.coreNumber = coreNumber;
	}

	public String getVelocity() {
		return clockRate;
	}

	public void setVelocity(String velocity) {
		this.clockRate = velocity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coreNumber, clockRate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processor other = (Processor) obj;
		return coreNumber == other.coreNumber && Objects.equals(clockRate, other.clockRate);
	}

	@Override
	public String toString() {
		return "[coreNumber=" + coreNumber + ", velocity=" + clockRate + "]";
	}

}
