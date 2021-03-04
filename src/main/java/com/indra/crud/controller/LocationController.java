package com.indra.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.crud.model.Location;
import com.indra.crud.service.LocationService;

@Controller
@RequestMapping(value = "/localizaciones")
public class LocationController {
	private final static Logger log = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private LocationService locationService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("locationList", locationService.searchAllLocations());
		
		return "locations";
	}	
	
	@PostMapping("/crear")
	public String create(Location location, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("mensaje", "Error al agregar la localización")
								.addFlashAttribute("clase", "danger");
		} else {			
			locationService.insertLocation(location);
			redirectAttributes.addFlashAttribute("mensaje", "Localización agregada correctamente")
								.addFlashAttribute("clase", "success");
		}
		return "redirect:/paises/";			
	}

}
