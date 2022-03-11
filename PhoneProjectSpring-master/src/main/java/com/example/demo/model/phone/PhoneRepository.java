package com.example.demo.model.phone;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
	ArrayList<Optional<Phone>> findByBrand(String brand);
}
