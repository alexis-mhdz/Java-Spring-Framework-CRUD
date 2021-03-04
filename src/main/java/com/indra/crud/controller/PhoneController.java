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

import com.indra.crud.model.Phone;
import com.indra.crud.service.PhoneService;

@Controller
@RequestMapping(value = "/telefonos")
public class PhoneController {
	private final static Logger log = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	private PhoneService phoneService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("phoneList", phoneService.searchAllPhones());
		
		return "phones";
	}	
	
	@PostMapping("/crear")
	public String create(Phone phone, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("mensaje", "Error al agregar el Teléfono")
								.addFlashAttribute("clase", "danger");
		} else {			
			phoneService.insertPhone(phone);
			redirectAttributes.addFlashAttribute("mensaje", "Teléfono agregado correctamente")
								.addFlashAttribute("clase", "success");
		}
		return "redirect:/telefonos/";			
	}
}
