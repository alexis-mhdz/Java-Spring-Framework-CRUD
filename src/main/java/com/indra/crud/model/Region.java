package com.indra.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
public class Region {
	@Id
	@GeneratedValue(generator="regionSeq")
	@SequenceGenerator(name="regionSeq", sequenceName="REGIONS_SEQ", allocationSize=1)
	@Column(name="REGION_ID")
	private int regionId;
	@Column(name="REGION_NAME")
	private String regionName;
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}
	
}
