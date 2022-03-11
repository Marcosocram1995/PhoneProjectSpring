package com.example.demo.model.phone;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ObjectMother.PhoneList;

@Service
public class PhoneService {

	private PhoneRepository phoneRepository;

	public ArrayList<Phone> getPhoneList() {
		PhoneList phoneList = new PhoneList();
		return phoneList.getPhoneList();
	}

	public PhoneService(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
//		enterNewPhonesToTheDatabase();
	}

	public void enterNewPhonesToTheDatabase() {
		this.phoneRepository.saveAll(getPhoneList());
	}

	public ArrayList<Optional<Phone>> findByBrand(String brand) {
		return phoneRepository.findByBrand(brand);
	}

	public Optional<Phone> findById(int id) {
		return phoneRepository.findById(id);
	}
}