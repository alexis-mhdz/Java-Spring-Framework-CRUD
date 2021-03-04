package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.Job;

public interface JobService {

	String insertJob(Job job);
	List<Job> searchAllJobs();
	Job searchJob(Job job);
	String updateJob(Job job);	
	String deleteJob(Job job);
	
}
