package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.Phone;

public interface PhoneService {
	String insertPhone(Phone phone);
	List<Phone> searchAllPhones();
	Phone searchPhone(Phone phone);
	String updatePhone(Phone phone);	
	String deletePhone(Phone phone);
}
