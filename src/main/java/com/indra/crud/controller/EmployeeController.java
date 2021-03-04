package com.indra.crud.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.crud.model.Employee;
import com.indra.crud.service.DepartmentServiceImp;
import com.indra.crud.service.EmployeeServiceImp;
import com.indra.crud.service.JobServiceImp;

@Controller
@RequestMapping(value = "/empleados")
public class EmployeeController {
	private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	@Autowired
	private JobServiceImp jobServiceImp;
	@Autowired
	private DepartmentServiceImp departmentServiceImp;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("employeeList", employeeServiceImp.searchAllEmployees());
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList = employeeServiceImp.findByFirstNameEndsWith("s");
		
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
		
		return "employees/index";
	}
	
	/*
	@GetMapping("/especifico")
	public String indexSpecific(Model model) {
		
		model.addAttribute("employeeList", employeeServiceImp.searchAllEmployeesWhithSpecificFields());
		
		return "employees/index";
	}
	*/
	
	@GetMapping("/{employeeId}")
	public String show(@PathVariable("employeeId") int employeeId, Model model) {
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		System.out.println(employee.getEmployeeId());

		employee = employeeServiceImp.searchEmployee(employee);
		System.out.println(employee.toString());
		
		model.addAttribute("employee", employee);
		
		return "employees/show";
	}
	
	@GetMapping("fecha-inicio-posterior/{hireDate}")
	public String showByStartDate(@PathVariable("hireDate") Date hireDate, Model model) {
		
		model.addAttribute("employeeList", employeeServiceImp.searchByHireDateAfter(hireDate));
		
		/*
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList = employeeServiceImp.searchByHireDateAfter(hireDate);
		for(Employee employee : employeeList) {
			System.out.println(employee.toString());
		}
		*/
		
		return "employees/index";
	}
		
	@GetMapping("/crear")
	public String create(Model model) {
		
		model.addAttribute("jobList", jobServiceImp.searchAllJobs());
		model.addAttribute("departmentList", departmentServiceImp.searchAllDepartments());
		model.addAttribute("managerList", employeeServiceImp.searchAllEmployees());
		
		return "employees/create";
	}
	
	@PostMapping("/store")
	public String store(Employee employee, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("message", "Error al agregar el Empleado")
								.addFlashAttribute("alertType", "danger");
		} else {			
			employeeServiceImp.insertEmployee(employee);
			redirectAttributes.addFlashAttribute("message", "Empleado agregado correctamente")
								.addFlashAttribute("alertType", "success");
		}
		return "redirect:/empleados/";			
	}	
	
	@GetMapping("editar/{employeeId}")
	public String edit(@PathVariable("employeeId") int employeeId, Model model) {
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		//System.out.println(employee.getEmployeeId());

		employee = employeeServiceImp.searchEmployee(employee);
		//System.out.println(employee.toString());
		
		model.addAttribute("employee", employee);
		model.addAttribute("jobList", jobServiceImp.searchAllJobs());
		model.addAttribute("departmentList", departmentServiceImp.searchAllDepartments());
		model.addAttribute("managerList", employeeServiceImp.searchAllEmployees());
		
		return "employees/edit";
	}
	
	@PostMapping("/update")
	public String update(Employee employee, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				log.error("Existe un error - " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("message", "Error al editar el Empleado")
								.addFlashAttribute("alertType", "danger");
		} else {
			//System.out.println("EmployeeId" + employee.getEmployeeId());
			employee.setEmployeeId(employee.getEmployeeId());
			if(employeeServiceImp.updateEmployee(employee)) {
				redirectAttributes.addFlashAttribute("message", "Empleado editado correctamente")
									.addFlashAttribute("alertType", "success");	
			} else {
				redirectAttributes.addFlashAttribute("message", "Error al editar el Empleado")
				.addFlashAttribute("alertType", "success");					
			}
		}
		return "redirect:/empleados/";			
	}
	
	@GetMapping("delete/{employeeId}")
	public String delete(@PathVariable("employeeId") int employeeId, Model model, RedirectAttributes redirectAttributes) {
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		//System.out.println(employee.getEmployeeId());

		if(employeeServiceImp.deleteEmployee(employee)) {
			redirectAttributes.addFlashAttribute("message", "Empleado eliminado correctamente")
			.addFlashAttribute("alertType", "success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Error al eliminar el Empleado")
			.addFlashAttribute("alertType", "danger");
		}
		//System.out.println(employee.toString());
				
		return "redirect:/empleados/";			
	}
	
	@InitBinder()
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}
