package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.Location;

public interface LocationService {

	String insertLocation(Location location);
	List<Location> searchAllLocations();
	Location searchLocation(Location location);
	String updateLocation(Location location);	
	String deleteLocation(Location location);
	
}
