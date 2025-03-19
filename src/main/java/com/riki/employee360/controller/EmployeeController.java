package com.riki.employee360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riki.employee360.model.Employee;
import com.riki.employee360.service.EmployeeService;

@Controller
class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring Boot with JSP!");
        return "hello";
    }
    
    @GetMapping("/employees/addForm")
    public String addForm() {
        return "addEmployee";
    }
    
    @PostMapping("/employees/add")
    public String addEmployee(Employee employee, Model model) {
    	employeeService.saveEmployee(employee);
    	model.addAttribute("message", "Create Employee Successfully!");
    	return "hello";
    }
    
    @GetMapping("/employees")
	public String searchEmployees(@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "10") int size, 
			Model model) {
    	List<Employee> employees = employeeService.searchEmployees(keyword, page, size);
    	int totalEmployees = employeeService.getTotalEmployeesByKeyword(keyword);
    	int totalPages = (int) Math.ceil((double) totalEmployees / size);
    	
    	model.addAttribute("employees", employees);
    	model.addAttribute("keyword", keyword);
    	model.addAttribute("currentPage", page);
    	model.addAttribute("totalPages", totalPages);
    	model.addAttribute("size", size);
    	return "employeeList";
    }
    
}
