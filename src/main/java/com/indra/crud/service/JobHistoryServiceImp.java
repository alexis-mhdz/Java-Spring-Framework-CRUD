package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.JobHistory;
import com.indra.crud.repository.JobHistoryRepository;

@Service
public class JobHistoryServiceImp implements JobHistoryService {

	@Autowired
	private JobHistoryRepository jobHistoryRepository;
	
	@Override
	public String insertJobHistory(JobHistory jobHistory) {
		try {
			jobHistoryRepository.save(jobHistory);
			return "Historial de trabajo agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el historial de trabajo";
		}
	}

	@Override
	public List<JobHistory> searchAllJobHistory() {
		return (List<JobHistory>) jobHistoryRepository.findAll();
	}

	@Override
	public JobHistory searchJobHistory(JobHistory jobHistory) {
		//jobHistoryRepository.findById(new JobHistoryIdentity(200, new Date(01/07/20))
		Optional<JobHistory> objetoRegreso = jobHistoryRepository.findById(jobHistory.getId()); 

		JobHistory jobHistoryReturn = new JobHistory();
		
		if(objetoRegreso.isPresent()) {
			jobHistoryReturn = objetoRegreso.get();
		}
		return jobHistoryReturn;
	}

	@Override
	public String updateJobHistory(JobHistory jobHistory) {
		try {
			jobHistoryRepository.save(jobHistory);
			return "Historial de trabajo actualizado con exito";
		} catch (Exception ex) {
			return "Error al actualizar el historial de trabajo";
		}
	}

	@Override
	public String deleteJobHistory(JobHistory jobHistory) {
		try {
			jobHistoryRepository.deleteById(jobHistory.getId());			
			return "Historial de trabajo eliminado correctamente";
		} catch (Exception ex) {
			return "Error al eliminar el historial de trabajo";
		}
	}

}
