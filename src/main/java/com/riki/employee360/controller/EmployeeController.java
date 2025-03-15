package com.riki.employee360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    
}
