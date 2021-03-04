package com.indra.crud.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Employee;
import com.indra.crud.repository.EmployeesRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeesRepository employeesRepository;
	/*
	@Override
	public String agregarEmpleado(Employee employee) {
		try {
			employeesRepository.save(employee);
			return "Empleado agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el empleado.";
		}
	}*/
	
	@Override
	public String insertEmployee(Employee employee) {
		try {
			employeesRepository.save(employee);
			return "Empleado agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el empleado";
		}
	}
	
	@Override
	public List<Employee> searchAllEmployees() {
		return (List<Employee>) employeesRepository.findAll();
	}
	
	@Override
	public Employee searchEmployee(Employee employee) {
		Optional<Employee> objetoRegreso = employeesRepository.findById(employee.getEmployeeId()); 
		
		if(objetoRegreso.isPresent()) {
			employee = objetoRegreso.get();
		}
		
		return employee;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		//Optional<Employee> objetoRegreso = employeesRepository.findById(employee.getEmployeeId()); 
		
		/*if(objetoRegreso.isPresent()) {
			Employee employeeRegreso = objetoRegreso.get();
			
			
			if(!employee.getFirstName().equals(employeeRegreso.getFirstName()) && !employee.getFirstName().isEmpty()) {
				employeeRegreso.setFirstName(employee.getFirstName());
			} else if(!employee.getLastName().equals(employeeRegreso.getLastName()) && !employee.getLastName().isEmpty()) {
				employeeRegreso.setLastName(employee.getLastName());
			} else if(!employee.getEmail().equals(employeeRegreso.getEmail()) && !employee.getEmail().isEmpty()) {
				employeeRegreso.setEmail(employee.getEmail());
			} else if(!employee.getPhoneNumber().equals(employeeRegreso.getPhoneNumber()) && !employee.getPhoneNumber().isEmpty()) {
				employeeRegreso.setPhoneNumber(employee.getPhoneNumber());
			} else if(!employee.getHireDate().equals(employeeRegreso.getHireDate()) && !employee.getHireDate().){
				
			}
			
			employeesRepository.save(employee);
			return "Empleado actualizado con exito";
		} else {
			return "Error al actualizar el empleado";
		}*/
		
		try {
			employeesRepository.save(employee);
			return true;
		} catch (Exception ex) {
			return false;
		}
		
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		try {
			//System.out.println("Lista de JobHistory: " + employee.getJobHistoryList());
			/*
			Iterable<JobHistory> jobHistoryIter = jobHistoryRepository.findAll();	
			for(JobHistory jobHistory: jobHistoryIter) {
				if(jobHistory.getId() ==  new JobHistoryIdentity(employee.getEmployeeId(), "*")) {
					System.out.println(jobHistory.toString());
				}
			}
			*/
			employeesRepository.deleteById(employee.getEmployeeId());			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public List<Employee> searchByHireDateAfter(Date hireDate) {
		
		return (List<Employee>) employeesRepository.findByHireDateAfter(hireDate);
	}
	
	public List<Employee> findByFirstNameEndsWith(String firstName) {
		
		return (List<Employee>) employeesRepository.findByFirstnameEndsWith(firstName);
	}
	
}
