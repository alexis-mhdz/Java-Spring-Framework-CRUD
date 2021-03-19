package com.indra.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.crud.model.Authority;
import com.indra.crud.model.User;
import com.indra.crud.service.AuthorityServiceImp;
import com.indra.crud.service.UserServiceImp;

@Controller
public class AuthController {
	private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private UserServiceImp userServiceImp;
	@Autowired
	private AuthorityServiceImp authorityServiceImp;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/login")
	public String login() {
		return "auth/login";
	}
	  
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "auth/login";
	}
	  
	@GetMapping("/register")
	public String register() {
		return "auth/register";
	}
	  
	@PostMapping("register/save")
	public String save(User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("message", "Error al registrar usuario")
				.addFlashAttribute("alertType", "danger");
			return "redirect:/register";
		} else {			
			user.setEnabled(true);
			user.setPassword(encoder.encode(user.getPassword()));
			Authority authority = new Authority();
			authority.setUsername(user.getUsername());
			authority.setAuthority("guest");
			userServiceImp.insertUser(user);
			authorityServiceImp.insertAuthority(authority);
			
			redirectAttributes.addFlashAttribute("message", "Usuario registrado correctamente")
				.addFlashAttribute("alertType", "success");
			return "redirect:/login";
		}
		//return "redirect:/";
	}
}
