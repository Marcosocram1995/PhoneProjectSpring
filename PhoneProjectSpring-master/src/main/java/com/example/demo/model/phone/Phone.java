package com.example.demo.model.phone;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.utiles.Utiles;

import lombok.Data;

@Entity
@Data
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model")
	private String model;
	@Embedded
	@Column(nullable = false)
	private Processor processor;
	@Embedded
	@Column(nullable = false)
	private Ram ram;
	@Embedded
	@Column(nullable = false)
	private Screen screen;
	@Embedded
	@Column(nullable = false)
	private Battery battery;
	@Column(nullable = false)
	private long antutu;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private float valoration;

	public static class BuilderPhone {
		private String brand;
		private String model;
		private Processor processor;
		private Ram ram;
		private Screen screen;
		private Battery battery;
		private long antutu;
		private float price;
		private float valoration;
		private final int MIN_CORE = 1;
		private final int MAX_CORE = 8;
		private final int MIN_SCREEN = 4;
		private final int MAX_SCREEN = 7;

		public BuilderPhone(String brand, String model) {
			super();
			this.brand = brand;
			this.model = model;
			this.processor = new Processor(Utiles.getRandomWholeNumber(MIN_CORE, MAX_CORE));
			this.ram = new Ram(this.processor.getCoreNumber());
			this.screen = new Screen(Utiles.getRandomDecimalNumber(MIN_SCREEN, MAX_SCREEN));
			this.battery = new Battery(this.processor, this.screen);
			AntutuCalculator antutuCalculator = new AntutuCalculator(processor, ram);
			this.antutu = (long) antutuCalculator.calculate();
			PriceCalculator prizeCalculator = new PriceCalculator(this.ram, this.processor, this.screen, this.battery);
			this.price = prizeCalculator.calculate();
			ValorationCalculator valorationCalculator = new ValorationCalculator(antutu);
			this.valoration = valorationCalculator.calculate();
		}

		public Phone builder() {
			return new Phone(this);
		}

		public String getBrand() {
			return brand;
		}

		public String getModel() {
			return model;
		}

		public Processor getProcessor() {
			return processor;
		}

		public Ram getRam() {
			return ram;
		}

		public Screen getScreen() {
			return screen;
		}

		public Battery getBattery() {
			return battery;
		}

		public long getAntutu() {
			return antutu;
		}

		public float getPrize() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public float getValoration() {
			return valoration;
		}

		public void setValoration(float valoration) {
			this.valoration = valoration;
		}
	}

	public Phone(BuilderPhone builderPhone) {
		this.brand = builderPhone.getBrand();
		this.model = builderPhone.getModel();
		this.processor = builderPhone.getProcessor();
		this.ram = builderPhone.getRam();
		this.screen = builderPhone.getScreen();
		this.battery = builderPhone.getBattery();
		this.antutu = builderPhone.getAntutu();
		this.price = builderPhone.getPrize();
		this.valoration = builderPhone.getValoration();
	}

	public Phone() {
		super();
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public Processor getProcessor() {
		return processor;
	}

	public Ram getRam() {
		return ram;
	}

	public Screen getScreen() {
		return screen;
	}

	public Battery getBattery() {
		return battery;
	}

	public long getAntutu() {
		return antutu;
	}

	public String getPrizeWithCurrencyType() {
		String priceWithCurrencyType = String.valueOf(this.price) + " €";
		return priceWithCurrencyType;
	}

	public float getPrizeWithoutCurrencyType() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getValoration() {
		return this.valoration;
	}

	public void setValoration(float valoration) {
		this.valoration = valoration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(antutu, battery, brand, id, model, price, processor, ram, screen, valoration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return antutu == other.antutu && Objects.equals(battery, other.battery) && Objects.equals(brand, other.brand)
				&& id == other.id && Objects.equals(model, other.model)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(processor, other.processor) && Objects.equals(ram, other.ram)
				&& Objects.equals(screen, other.screen)
				&& Float.floatToIntBits(valoration) == Float.floatToIntBits(other.valoration);
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", brand=" + brand + ", model=" + model + ", processor=" + processor + ", ram=" + ram
				+ ", screen=" + screen + ", battery=" + battery + ", antutu=" + antutu + ", price=" + price
				+ ", valoration=" + valoration + "]";
	}
}
