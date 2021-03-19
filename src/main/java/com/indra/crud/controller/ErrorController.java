package com.indra.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	@GetMapping("/accessdenied")
	public String accessdenied(Model model) {
		return "errors/403";
	}
}
