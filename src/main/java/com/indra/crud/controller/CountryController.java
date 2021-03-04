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

import com.indra.crud.model.Country;
import com.indra.crud.service.CountryService;

@Controller
@RequestMapping(value = "/paises")
public class CountryController {
	private final static Logger log = LoggerFactory.getLogger(CountryController.class);
		
	@Autowired
	private CountryService countryService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("countryList", countryService.searchAllCountries());
		
		return "countries";
	}	
	
	@PostMapping("/crear")
	public String create(Country country, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("mensaje", "Error al agregar el País")
								.addFlashAttribute("clase", "danger");
		} else {			
			countryService.insertCountry(country);
			redirectAttributes.addFlashAttribute("mensaje", "País agregado correctamente")
								.addFlashAttribute("clase", "success");
		}
		return "redirect:/paises/";			
	}

}
