package com.example.demo.model.phone;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Ram {
	@Column(name = "ram")
	private String capacity;
	@Transient
	private final String UNIT_MEASURE_RAM = "GB";
	@Transient
	private final int MEGABYTES_PER_CORE = 500;
	@Transient
	private final int CONVERTER_MB_TO_GB = 1000;

	public Ram() {
		super();
	}

	public Ram(int core) {
		this.capacity = calculateCapacity(core) + UNIT_MEASURE_RAM;
	}

	private float calculateCapacity(int core) {
		float megabytes = core * MEGABYTES_PER_CORE;
		float gigabytes = converterMegabytesToGygabytes(megabytes);
		return gigabytes;
	}

	private float converterMegabytesToGygabytes(float megabytes) {
		return megabytes / CONVERTER_MB_TO_GB;
	}

	public float getCapacity() {
		String[] split = capacity.split("G");
		return Float.valueOf(split[0]);
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ram other = (Ram) obj;
		return Objects.equals(capacity, other.capacity);
	}

	@Override
	public String toString() {
		return capacity;
	}
}