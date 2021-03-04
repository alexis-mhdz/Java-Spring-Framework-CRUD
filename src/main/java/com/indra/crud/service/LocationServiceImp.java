package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Location;
import com.indra.crud.repository.LocationsRepository;

@Service
public class LocationServiceImp implements LocationService {

	@Autowired
	private LocationsRepository locationsRepository;
	
	@Override
	public String insertLocation(Location location) {
		try {
			locationsRepository.save(location);
			return "Localización agregada correctamente";
		} catch (Exception ex) {
			return "Error al agregar la localización";
		}
	}

	@Override
	public List<Location> searchAllLocations() {
		return (List<Location>) locationsRepository.findAll();
	}

	@Override
	public Location searchLocation(Location location) {
		Optional<Location> returnObject = locationsRepository.findById(location.getLocationId()); 
		
		if(returnObject.isPresent()) {
			location = returnObject.get();
		}
		
		return location;
	}

	@Override
	public String updateLocation(Location location) {
		try {
			locationsRepository.save(location);
			return "Localización actualizada con exito";
		} catch (Exception ex) {
			return "Error al actualizar la localización";
		}
	}

	@Override
	public String deleteLocation(Location location) {
		try {
			locationsRepository.deleteById(location.getLocationId());			
			return "Localización eliminada correctamente";
		} catch (Exception ex) {
			return "Error al eliminar la localización";
		}
	}

}
