package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Phone;
import com.indra.crud.repository.PhonesRepository;

@Service
public class PhoneServiceImp implements PhoneService {

	@Autowired
	private PhonesRepository phonesRepository;
	
	@Override
	public String insertPhone(Phone phone) {
		try {
			phonesRepository.save(phone);
			return "Telefono agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el telefono";
		}
	}

	@Override
	public List<Phone> searchAllPhones() {
		return (List<Phone>) phonesRepository.findAll();
	}

	@Override
	public Phone searchPhone(Phone phone) {
		Optional<Phone> returnObject = phonesRepository.findById(phone.getId()); 
		
		if(returnObject.isPresent()) {
			phone = returnObject.get();
		}
		
		return phone;
	}

	@Override
	public String updatePhone(Phone phone) {
		try {
			phonesRepository.save(phone);
			return "Telefono actualizado con exito";
		} catch (Exception ex) {
			return "Error al actualizar el telefono";
		}
	}

	@Override
	public String deletePhone(Phone phone) {
		try {
			phonesRepository.deleteById(phone.getId());			
			return "Telefono eliminado correctamente";
		} catch (Exception ex) {
			return "Error al eliminar el telefono";
		}
	}

}
