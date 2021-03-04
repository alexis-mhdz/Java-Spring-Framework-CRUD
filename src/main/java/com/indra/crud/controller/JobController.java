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

import com.indra.crud.model.Job;
import com.indra.crud.service.JobService;

@Controller
@RequestMapping(value = "/trabajos")

public class JobController {
	private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private JobService jobService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("jobList", jobService.searchAllJobs());
		
		return "jobs";
	}	
	
	@PostMapping("/crear")
	public String create(Job job, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("mensaje", "Error al agregar el Trabajo")
								.addFlashAttribute("clase", "danger");
		} else {			
			jobService.insertJob(job);
			redirectAttributes.addFlashAttribute("mensaje", "Trabajo agregado correctamente")
								.addFlashAttribute("clase", "success");
		}
		return "redirect:/trabajos/";			
	}

}
