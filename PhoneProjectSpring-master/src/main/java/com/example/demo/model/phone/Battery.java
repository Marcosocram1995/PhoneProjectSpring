package com.example.demo.model.phone;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Battery {
	@Column(name = "battery")
	private String mAhNumber;
	@Transient
	private final int MULTIPLIER = 190;

	public Battery() {
		super();
	}

	public Battery(Processor processor, Screen screen) {
		super();
		this.mAhNumber = String.valueOf(calculateBatery(processor, screen));
	}

	public int calculateBatery(Processor processor, Screen screen) {
		float result = Float.valueOf(processor.calculateResult()) + screen.getScreenSize();
		return (int) (result * MULTIPLIER);
	}

	public int getMAhNumber() {
		return Integer.valueOf(mAhNumber);
	}

	public void setMAhNumber(String mAhNumber) {
		this.mAhNumber = mAhNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mAhNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battery other = (Battery) obj;
		return mAhNumber == other.mAhNumber;
	}

	@Override
	public String toString() {
		return mAhNumber + "mAH";
	}

}
