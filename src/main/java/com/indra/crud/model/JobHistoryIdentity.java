package com.indra.crud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class JobHistoryIdentity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	@Column(name="START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	public JobHistoryIdentity() {}
	public JobHistoryIdentity(int employeeId, Date startDate) {
		super();
		setEmployeeId(employeeId);
		setStartDate(startDate);
	}
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
		/*
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String dateString = formatter.format(startDate);
		System.out.println(dateString);
		this.startDate = dateString;
		*/

		/*
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		startDate = sdf.format(new Date()); 
		System.out.println(fecha);
		*/
		/*
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		try {
			date = format.parse(startDate.toString());    			
		} catch (Exception ex) {}
		*/
		this.startDate = startDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobHistoryIdentity other = (JobHistoryIdentity) obj;
		if (employeeId != other.employeeId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
}
