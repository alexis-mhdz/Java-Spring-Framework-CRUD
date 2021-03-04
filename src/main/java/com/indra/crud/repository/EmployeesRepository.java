package com.indra.crud.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.crud.model.Employee;

public interface EmployeesRepository extends CrudRepository<Employee, Integer> {
	List<Employee> findByHireDateAfter(Date hireDate);
	
	//@Query(value = "SELECT employeeId, firstName, lastName, email, hireDate, salary FROM Employee")
	//List<Employee> searchAllEmployeesWhithSpecificFields();
	
	@Query(value="SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE %?1", nativeQuery = true)
	List<Employee> findByFirstnameEndsWith(String firstName);
	
}
