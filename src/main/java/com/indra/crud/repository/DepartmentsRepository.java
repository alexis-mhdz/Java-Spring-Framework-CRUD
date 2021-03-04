package com.indra.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.crud.model.Department;

public interface DepartmentsRepository extends CrudRepository<Department, Integer> {

}
