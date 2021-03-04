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

import com.indra.crud.model.Region;
import com.indra.crud.service.RegionService;

@Controller
@RequestMapping(value = "/regiones")
public class RegionController {
	private final static Logger log = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	private RegionService regionService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("regionList", regionService.searchAllRegions());
		
		return "phones";
	}	
	
	@PostMapping("/crear")
	public String create(Region region, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("mensaje", "Error al agregar la Región")
								.addFlashAttribute("clase", "danger");
		} else {			
			regionService.insertRegion(region);
			redirectAttributes.addFlashAttribute("mensaje", "Región agregada correctamente")
								.addFlashAttribute("clase", "success");
		}
		return "redirect:/regiones/";			
	}
}
