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

import com.indra.crud.model.JobHistory;
import com.indra.crud.service.JobHistoryService;

@Controller
@RequestMapping(value = "/historiales-de-trabajo")
public class JobHistoryController {
	private final static Logger log = LoggerFactory.getLogger(JobHistoryController.class);
	
	@Autowired
	private JobHistoryService jobHistoryService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("jobHistoryList", jobHistoryService.searchAllJobHistory());
		
		return "jobHistories";
	}	
	
	@PostMapping("/crear")
	public String create(JobHistory jobHistory, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("mensaje", "Error al agregar el Historial de trabajo")
								.addFlashAttribute("clase", "danger");
		} else {			
			jobHistoryService.insertJobHistory(jobHistory);
			redirectAttributes.addFlashAttribute("mensaje", "Historial de trabajo agregado correctamente")
								.addFlashAttribute("clase", "success");
		}
		return "redirect:/historiales-de-trabajo/";			
	}
}
