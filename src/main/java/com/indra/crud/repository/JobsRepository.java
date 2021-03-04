package com.indra.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.crud.model.Job;

public interface JobsRepository extends CrudRepository<Job, String> {

}
