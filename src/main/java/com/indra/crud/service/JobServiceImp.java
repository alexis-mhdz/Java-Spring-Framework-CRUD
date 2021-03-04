package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Job;
import com.indra.crud.repository.JobsRepository;

@Service
public class JobServiceImp implements JobService {

	@Autowired
	private JobsRepository jobRepository;
	
	@Override
	public String insertJob(Job job) {
		try {
			jobRepository.save(job);
			return "Trabajo agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el trabajo";
		}
	}

	@Override
	public List<Job> searchAllJobs() {
		return (List<Job>) jobRepository.findAll();
	}

	@Override
	public Job searchJob(Job job) {
		Optional<Job> returnObject = jobRepository.findById(job.getJobId()); 
		
		if(returnObject.isPresent()) {
			job = returnObject.get();
		}
		
		return job;
	}

	@Override
	public String updateJob(Job job) {
		try {
			jobRepository.save(job);
			return "Trabajo actualizado con exito";
		} catch (Exception ex) {
			return "Error al actualizar el trabajo";
		}
	}

	@Override
	public String deleteJob(Job job) {
		try {
			jobRepository.deleteById(job.getJobId());			
			return "Empleado eliminado correctamente";
		} catch (Exception ex) {
			return "Error al eliminar el empleado";
		}
	}

}
