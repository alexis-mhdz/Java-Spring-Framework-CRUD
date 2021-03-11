package com.indra.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.crud.model.Employee;
import com.indra.crud.model.Job;
import com.indra.crud.service.EmployeeServiceImp;
import com.indra.crud.service.JobServiceImp;

@RestController
@RequestMapping(value = "/api")
public class JobRestController {
	
	@Autowired
	private JobServiceImp jobServiceImp;
	
	@GetMapping("/trabajos")
	List<Job> all() {
	    return jobServiceImp.searchAllJobs();
	}
	
	@PostMapping("/trabajos/guardar")
	String newJob(@RequestBody Job job) {
		return jobServiceImp.insertJob(job);
	}

	@GetMapping("/trabajos/{jobId}")
	Job one(@PathVariable String jobId) {
		Job job = new Job();
		job.setJobId(jobId);
	    return jobServiceImp.searchJob(job);
	}
	
}
