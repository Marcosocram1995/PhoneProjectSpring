package com.example.demo.phoneTests;

import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.ObjectMother.PhoneList;
import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneController;
import com.example.demo.model.phone.PhoneService;
import com.example.demo.model.phone.Response;

@SpringBootTest
class PhoneTest {
//
//	@MockBean
//	private PhoneService phoneService;
//	@Autowired
//	private PhoneController phoneController;
//	private static PhoneList phoneList;
//
//	@Test
//	void testList() {
//		when(phoneService.getPhoneList()).thenReturn(phoneList.getPhoneList());
//		ResponseEntity<Response> list = phoneController.list();
//		System.err.println(list.toString());
//	}
//
//	@Test
//	void testFindBrand() {
//		String brand = "Motorola";
//		when(phoneService.findByBrand(brand)).thenReturn(phoneList.findByBrand(brand));
//		ResponseEntity<Response> findByBrand = phoneController.findByBrand(brand);
//		System.err.println(findByBrand.toString());
//	}
//
//	@Test
//	void testFindId() {
//		int id = 1;
//		when(phoneService.findById(id)).thenReturn(phoneList.findById(id));
//		ResponseEntity<Response> findById = phoneController.findById(id);
//		System.err.println(findById.toString());
//	}
//
//	@BeforeAll
//	private static void setIdPhone() {
//		phoneList = new PhoneList();
//		for (int i = 0; i < phoneListSize(); i++) {
//			getPhone(i).setId(i + 1);
//		}
//	}
//
//	private static Phone getPhone(int id) {
//		return phoneList.getPhoneList().get(id);
//	}
//
//	private static int phoneListSize() {
//		return phoneList.getPhoneList().size();
//	}
}
