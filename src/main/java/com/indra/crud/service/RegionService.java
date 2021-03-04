package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.Region;

public interface RegionService {
	String insertRegion(Region region);
	List<Region> searchAllRegions();
	Region searchRegion(Region region);
	String updateRegion(Region region);	
	String deleteRegion(Region region);
}
