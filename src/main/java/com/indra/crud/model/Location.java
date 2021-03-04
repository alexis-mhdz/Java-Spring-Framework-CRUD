package com.indra.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Location {
	@Id
	@GeneratedValue(generator="locationSeq")
	@SequenceGenerator(name="locationSeq", sequenceName="LOCATIONS_SEQ", allocationSize=1)
	@Column(name="LOCATION_ID")
	private int locationId;
	@Column(name="STREET_ADDRESS")
	private String streetAdrees;
	@Column(name="POSTAL_CODE")
	private String postalCode;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	@Column(name="COUNTRY_ID")
	private String countryId;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getStreetAdrees() {
		return streetAdrees;
	}
	public void setStreetAdrees(String streetAdrees) {
		this.streetAdrees = streetAdrees;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", streetAdrees=" + streetAdrees + ", postalCode=" + postalCode
				+ ", city=" + city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}
}
