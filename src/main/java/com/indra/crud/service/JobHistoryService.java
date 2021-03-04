package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.JobHistory;

public interface JobHistoryService {
	
	String insertJobHistory(JobHistory jobHistory);
	List<JobHistory> searchAllJobHistory();
	JobHistory searchJobHistory(JobHistory jobHistory);
	String updateJobHistory(JobHistory jobHistory);	
	String deleteJobHistory(JobHistory jobHistory);
}
