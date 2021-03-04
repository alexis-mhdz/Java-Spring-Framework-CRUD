package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.Country;

public interface CountryService {

	String insertCountry(Country country);
	List<Country> searchAllCountries();
	Country searchCountry(Country country);
	String updateCountry(Country country);	
	String deleteCountry(Country country);
	
}
