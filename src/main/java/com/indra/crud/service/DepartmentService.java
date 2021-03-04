package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.Department;

public interface DepartmentService {

	String insertDepartment(Department department);
	List<Department> searchAllDepartments();
	Department searchDepartment(Department department);
	String updateDepartment(Department department);	
	String deleteDepartment(Department department);
	
}
