package com.indra.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Department {
	@Id
	@GeneratedValue(generator="departmentSeq")
	@SequenceGenerator(name="departmentSeq", sequenceName="DEPARTMENTS_SEQ", allocationSize=1)
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	@Column(name="MANAGER_ID")
	private Integer managerId;
	@Column(name="LOCATION_ID")
	private Integer locationId;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Departament [departamentId=" + departmentId + ", departamentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}
}
