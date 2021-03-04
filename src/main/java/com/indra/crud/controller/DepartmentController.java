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

import com.indra.crud.model.Department;
import com.indra.crud.service.DepartmentService;

@Controller
@RequestMapping(value = "/departamentos")
public class DepartmentController {
	private final static Logger log = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("departmentList", departmentService.searchAllDepartments());
		
		return "departments";
	}	
	
	@PostMapping("/crear")
	public String create(Department department, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("mensaje", "Error al agregar el Departamento")
								.addFlashAttribute("clase", "danger");
		} else {			
			departmentService.insertDepartment(department);
			redirectAttributes.addFlashAttribute("mensaje", "Departamento agregado correctamente")
								.addFlashAttribute("clase", "success");
		}
		return "redirect:/departamentos/";			
	}

}
