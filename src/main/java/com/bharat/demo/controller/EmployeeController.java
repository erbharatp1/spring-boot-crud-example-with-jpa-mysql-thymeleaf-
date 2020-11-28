package com.bharat.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bharat.demo.model.Employee;
import com.bharat.demo.service.EmployeeService;

/**
 * 
 * @author Bharat
 *
 */
@Controller
@RequestMapping("/employees/")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("signup")
	public String showSignUpForm(Employee emp) {
		logger.info("EmployeeController.showSignUpForm(){}",emp);
		return "add-employee";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		logger.info("EmployeeController.showUpdateForm(){}" , model.toString());
		List<Employee> empList = employeeService.findAll();
		model.addAttribute("employees", empList);
		return "index";
	}

	@PostMapping("add")
	public String addEmployee(Employee emp, BindingResult result, Model model) {
		logger.info("EmployeeController.addEmployee(){}",emp);
		if (result.hasErrors()) {
			return "add-employee";
		}

		employeeService.save(emp);
		return "redirect:list";
	}

	@GetMapping("edit/{employeeId}")
	public String showUpdateForm(@PathVariable("employeeId") Long employeeId, Model model) {
		Employee emp = employeeService.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + employeeId));
		logger.info("EmployeeController.showUpdateForm() {}", employeeId);
		model.addAttribute("employees", emp);
		return "update-employee";
	}

	@PostMapping("update/{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") long employeeId, Employee emp, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			emp.setEmployeeId(employeeId);
			return "update-employee";
		}

		employeeService.save(emp);
		List<Employee> empList = employeeService.findAll();
		model.addAttribute("employees", empList);
		return "index";
	}

	@GetMapping("delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") long employeeId, Model model) {
		logger.info("EmployeeController.deleteEmployee(){}", employeeId);
		Employee emp = employeeService.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + employeeId));
		employeeService.delete(emp);
		List<Employee> empList = employeeService.findAll();
		model.addAttribute("employees", empList);
		return "index";
	}
}
