package com.indra.crud.service;

import java.util.Date;
import java.util.List;

import com.indra.crud.model.Employee;

public interface EmployeeService {
	String insertEmployee(Employee employee);
	List<Employee> searchAllEmployees();
	Employee searchEmployee(Employee employee);
	Boolean updateEmployee(Employee employee);
	Boolean deleteEmployee(Employee employee);
	List<Employee> searchByHireDateAfter(Date hireDate);
	//List<Employee> searchAllEmployeesWhithSpecificFields();
	List<Employee> findByFirstNameEndsWith(String firstName);
}