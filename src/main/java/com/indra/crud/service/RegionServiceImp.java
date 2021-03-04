package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Region;
import com.indra.crud.repository.RegionsRepository;

@Service
public class RegionServiceImp implements RegionService {

	@Autowired
	private RegionsRepository regionsRepository;
	
	@Override
	public String insertRegion(Region region) {
		try {
			regionsRepository.save(region);
			return "Región agregada correctamente";
		} catch (Exception ex) {
			return "Error al agregar la región";
		}
	}

	@Override
	public List<Region> searchAllRegions() {
		return (List<Region>) regionsRepository.findAll();
	}

	@Override
	public Region searchRegion(Region region) {
		Optional<Region> returnObject = regionsRepository.findById(region.getRegionId()); 
		
		if(returnObject.isPresent()) {
			region = returnObject.get();
		}
		
		return region;
	}

	@Override
	public String updateRegion(Region region) {
		try {
			regionsRepository.save(region);
			return "Región actualizada con exito";
		} catch (Exception ex) {
			return "Error al actualizar la región";
		}
	}

	@Override
	public String deleteRegion(Region region) {
		try {
			regionsRepository.deleteById(region.getRegionId());			
			return "Región eliminada correctamente";
		} catch (Exception ex) {
			return "Error al eliminar la región";
		}
	}

}
