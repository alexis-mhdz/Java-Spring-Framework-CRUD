package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Country;
import com.indra.crud.repository.CountriesRepository;

@Service
public class CountryServiceImp implements CountryService {

	@Autowired
	private CountriesRepository countriesRepository;
	
	@Override
	public String insertCountry(Country country) {
		try {
			countriesRepository.save(country);
			return "País agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el país";
		}
	}

	@Override
	public List<Country> searchAllCountries() {
		return (List<Country>) countriesRepository.findAll();
	}

	@Override
	public Country searchCountry(Country country) {
		Optional<Country> returnObject = countriesRepository.findById(country.getCountryId()); 
		
		if(returnObject.isPresent()) {
			country = returnObject.get();
		}
		
		return country;
	}

	@Override
	public String updateCountry(Country country) {
		try {
			countriesRepository.save(country);
			return "País actualizado con exito";
		} catch (Exception ex) {
			return "Error al actualizar el país";
		}
	}

	@Override
	public String deleteCountry(Country country) {
		try {
			countriesRepository.deleteById(country.getCountryId());			
			return "País eliminado correctamente";
		} catch (Exception ex) {
			return "Error al eliminar el país";
		}
	}

}
