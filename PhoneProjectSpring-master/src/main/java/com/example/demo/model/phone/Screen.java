package com.example.demo.model.phone;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.example.demo.utiles.Utiles;

@Embeddable
public class Screen {
	@Column(name = "screen")
	private String screenSize;

	public Screen() {
		super();
	}

	public Screen(float screenSize) {
		super();
		this.screenSize = String.valueOf(Utiles.convertNumberTwoDecimals(screenSize));
	}

	public float getScreenSize() {
		return Float.valueOf(screenSize);
	}

	@Override
	public int hashCode() {
		return Objects.hash(screenSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return Objects.equals(screenSize, other.screenSize);
	}

	@Override
	public String toString() {
		return screenSize;
	}

}
