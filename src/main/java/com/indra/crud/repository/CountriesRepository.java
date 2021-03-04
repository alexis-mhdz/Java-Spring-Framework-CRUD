package com.indra.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.crud.model.Country;

public interface CountriesRepository extends CrudRepository<Country, String> {

}
