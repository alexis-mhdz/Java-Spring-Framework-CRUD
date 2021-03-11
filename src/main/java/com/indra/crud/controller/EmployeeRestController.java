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
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	
	@GetMapping("/empleados")
	List<Employee> all() {
	    return employeeServiceImp.searchAllEmployees();
	}
	
	@PostMapping("/empleados")
	String newEmployee(@RequestBody Employee employee) {
		return employeeServiceImp.insertEmployee(employee);
	}

	@GetMapping("/empleados/{employeeId}")
	Employee one(@PathVariable int employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		return employeeServiceImp.searchEmployee(employee);
	}

	
}
