package com.indra.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.crud.model.JobHistory;
import com.indra.crud.model.JobHistoryIdentity;

public interface JobHistoryRepository extends CrudRepository<JobHistory, JobHistoryIdentity> {

}
