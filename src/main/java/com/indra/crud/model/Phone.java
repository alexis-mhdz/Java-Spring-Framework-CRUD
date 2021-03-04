package com.indra.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PHONE")
public class Phone {
	@Id
	@GeneratedValue(generator="phoneSeq")
	@SequenceGenerator(name="phoneSeq", sequenceName="PHONES_SEQ", allocationSize=1)
	@Column(name="ID")
	private int id;
	@Column(name="EXTENSION")
	private String extension;
	@Column(name="ISD_CODE")
	private String isdCode;
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	@Column(name="TYPE")
	private String type;
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getIsdCode() {
		return isdCode;
	}
	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", extension=" + extension + ", isdCode=" + isdCode + ", phoneNumber="
				+ phoneNumber + ", type=" + type + ", employeeId=" + employeeId + "]";
	}
}
