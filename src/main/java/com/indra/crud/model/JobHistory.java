package com.indra.crud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JOB_HISTORY")
public class JobHistory {
	/*
	@Column(name="EMPLOYE_ID")
	private int employeeId;
	@Column(name="START_DATE")
	private Date startDate;
	*/
	@EmbeddedId
	private JobHistoryIdentity id;
	@Column(name="END_DATE")
	private Date endDate;
	@Column(name="JOB_ID")
	private String jobId;
	@Column(name="DEPARTMENT_ID")
	private Integer departmentId;
	//@JoinColumn(name="customerId",referencedColumnName="id_customer")
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false, insertable = false)
    private Employee employee;
	/*
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	*/
	public JobHistoryIdentity getId() {
		return id;
	}
	public void setId(JobHistoryIdentity id) {
		this.id = id;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		/*
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String dateString = formatter.format(endDate);
		System.out.println("Fecha de sálida: " + endDate);
		*/
		this.endDate = endDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "JobHistory [id=" + id + ", endDate=" + endDate + ", jobId=" + jobId + ", departmentId=" + departmentId
				+ "]";
	}
}
