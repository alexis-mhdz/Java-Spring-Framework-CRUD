package com.indra.crud.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	@Id
	@GeneratedValue(generator="employeeSeq")
	@SequenceGenerator(name="employeeSeq", sequenceName="EMPLOYEES_SEQ", allocationSize=1)
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="HIRE_DATE")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	
	@ManyToOne
    @JoinColumn(name = "JOB_ID", nullable = false)
	private Job job;
	
	@Column(name="SALARY")
	private double salary;
	
	@Column(name="COMMISSION_PCT")
	private Double commisionPCT;
	
	@Column(name="MANAGER_ID")
	private Integer managerId;
	/*
	@ManyToOne
    @JoinColumn(name = "MANAGER_ID", nullable = false, updatable = false, insertable = false)
	private Manager manager;
	*/
	
	/*
	@Column(name="DEPARTMENT_ID")
	private Integer departmentId;
	*/
	
	@ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "DEPARTMENT_ID", nullable = true)
	private Department department;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
	private List<JobHistory> jobHistoryList;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	/*
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}*/
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Double getCommissionPCT() {
		return commisionPCT;
	}
	public void setCommissionPCT(Double commisionPCT) {
		this.commisionPCT = commisionPCT;
	}
	/*
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	*/
	public Department getDepartment() {
		return department;
	}
	public Integer getManagerId() {
		return managerId;
		
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	/*
	public Department getDepartment() {
		return department;
	}
	*/
	public void setDepartment(Department department) {
		this.department = department;
	}
	/*
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	*/
	public List<JobHistory> getJobHistoryList() {
		return jobHistoryList;
	}
	public void setJobHistoryList(List<JobHistory> jobHistoryList) {
		this.jobHistoryList = jobHistoryList;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", job=" + job + ", salary="
				+ salary + ", commisionPCT=" + commisionPCT + ", managerId=" + managerId + ", department=" + department
				+ ", jobHistoryList=" + jobHistoryList + "]";
	}
}
