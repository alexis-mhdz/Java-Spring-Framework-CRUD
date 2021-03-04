package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Department;
import com.indra.crud.repository.DepartmentsRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@Override
	public String insertDepartment(Department department) {
		try {
			departmentsRepository.save(department);
			return "Departamento agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el departamento";
		}
	}

	@Override
	public List<Department> searchAllDepartments() {
		return (List<Department>) departmentsRepository.findAll();
	}

	@Override
	public Department searchDepartment(Department department) {
		Optional<Department> returnObject = departmentsRepository.findById(department.getDepartmentId()); 
		
		if(returnObject.isPresent()) {
			department = returnObject.get();
		}
		
		return department;
	}

	@Override
	public String updateDepartment(Department department) {
		try {
			departmentsRepository.save(department);
			return "Departamento actualizado con exito";
		} catch (Exception ex) {
			return "Error al actualizar el departamento";
		}
	}

	@Override
	public String deleteDepartment(Department department) {
		try {
			departmentsRepository.deleteById(department.getDepartmentId());			
			return "Departamento eliminado correctamente";
		} catch (Exception ex) {
			return "Error al eliminar el departamento";
		}
	}

}
