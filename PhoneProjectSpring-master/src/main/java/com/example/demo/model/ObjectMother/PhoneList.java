package com.example.demo.model.ObjectMother;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.Phone.BuilderPhone;

public class PhoneList {

	private LinkedList<String> brand = new LinkedList<>(List.of("Samsung", "Apple", "Motorola", "Nokia", "Huawei",
			"Oppo", "Honor", "TCL", "Alcatel", "Doogee", "Realme", "Cubot", "Oukitel", "Ulefone", "Elephone", "Google",
			"OnePlus", "Nubia", "Vivo", "Meizu", "Mywigo", "Sony", "Umidigi", "Vernee", "Wiko", "ZTE", "Lenovo"));
	private LinkedList<String> model = new LinkedList<>(List.of("Edge x30", "Note 10 Pro", "GT Neo 2", "Nord 2",
			"Mate 20X", "11T", "iPhone 13", "F3", "Edge", "Find N", "Pixel 2 XL", "10 PRO", "iQOO 8", "X3 NFC",
			"11 Lite", "8i", "9AT", "Pixel 3A", "GT Neo 2", "C21Y", "Narzo 50i", "20SE", "Pixel 3", "Civi", "P40 Lite",
			"GT Master", "iQOO 7", "Reno 6", "Galaxy S20", "K40", "9RT", "F2 PRO", "X60", "Galaxy S21", "Magic 6", "9R",
			"Z30", "G100"));

	private ArrayList<Phone> phoneList = new ArrayList<>();
	
	public ArrayList<Phone> getPhoneList() {
		return this.phoneList;
	}

	public PhoneList() {
		super();
		this.brand.forEach((concreteMark) -> {
			this.model.forEach((concreteModel) -> {
				this.phoneList.add(new BuilderPhone(concreteMark.toLowerCase(), concreteModel.toLowerCase()).builder());
			});
		});
	}

	public ArrayList<Optional<Phone>> findByBrand(String brand) {
		ArrayList<Optional<Phone>> optionalPhoneList = new ArrayList<>();
		this.phoneList.stream()
		.filter(phone ->
		phone.getBrand().equalsIgnoreCase(brand))
		.forEach(phone -> 
		optionalPhoneList.add(Optional.ofNullable(phone)));
		return optionalPhoneList;
	}
	
//	public Optional<Phone> findById(int id) {
//		return Optional.ofNullable(this.phoneList.stream()
//				.filter(phone -> 
//				phone.getId() == id)
//				.findFirst()
//				.get());			
//	}
}