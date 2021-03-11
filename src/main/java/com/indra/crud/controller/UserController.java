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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.crud.model.Authority;
import com.indra.crud.model.User;
import com.indra.crud.service.AuthorityServiceImp;
import com.indra.crud.service.UserServiceImp;


@Controller
@RequestMapping(value = "/usuarios")
public class UserController {
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImp userServiceImp;
	@Autowired
	private AuthorityServiceImp authorityServiceImp;
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("userList", userServiceImp.searchAllUsers());
		return "users/index";
	}
	
	@GetMapping("/{username}")
	public String show(@PathVariable("username") String username, Model model) {
		
		User user = new User();
		user.setUsername(username);
		System.out.println(user.getUsername());

		user = userServiceImp.searchUser(user);
		System.out.println(user.toString());
		
		model.addAttribute("user", user);
		
		return "users/show";
	}
	
	@GetMapping("editar/{username}")
	public String edit(@PathVariable("username") String username, Model model) {
		
		User user = new User();
		user.setUsername(username);
		//System.out.println(employee.getEmployeeId());

		user = userServiceImp.searchUser(user);
		//System.out.println(employee.toString());
		
		model.addAttribute("user", user);
		
		return "users/edit";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("authority") String rol, User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("message", "Error al editar el Usuario")
								.addFlashAttribute("alertType", "danger");
		} else {
			//System.out.println("EmployeeId" + employee.getEmployeeId());
			//Boolean enabled = user.getEnabled();
			//user = userServiceImp.searchUser(user);
			//user.setEnabled(enabled);
			Authority authority = new Authority();
			authority.setUsername(user.getUsername());
			//user.setPassword(encoder.encode(user.getPassword()));
			//authority = authorityServiceImp.searchAuthority(authority);
			authority.setAuthority(rol);
			//System.out.println("Paso 1");
			if(userServiceImp.updateUser(user)) {
				System.out.println(authority.toString());
				authorityServiceImp.updateAuthority(authority);
				redirectAttributes.addFlashAttribute("message", "Usuario editado correctamente")
									.addFlashAttribute("alertType", "success");	
			} else {
				redirectAttributes.addFlashAttribute("message", "Error al editar el Usuario")
				.addFlashAttribute("alertType", "success");					
			}
		}
		return "redirect:/usuarios/";			
	}
	
	/*
	@GetMapping("/crear")
	public String create(Model model) {		
		return "users/create";
	}
	
	@PostMapping("/store")
	public String store(User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("message", "Error al agregar el Usuario")
								.addFlashAttribute("alertType", "danger");
		} else {			
			userServiceImp.insertUser(user);
			redirectAttributes.addFlashAttribute("message", "Usuario agregado correctamente")
								.addFlashAttribute("alertType", "success");
		}
		return "redirect:/usuarios/";			
	}
	*/

}
