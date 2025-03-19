package com.riki.employee360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riki.employee360.mapper.EmployeeMapper;
import com.riki.employee360.model.Employee;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void saveEmployee(Employee employee) {
		employeeMapper.insertEmployee(employee);
	}

	public List<Employee> searchEmployees(String keyword, int page, int size) {
		int offset = (page - 1) * size;
		return employeeMapper.searchEmployees(keyword, size, offset);
	}

	public int getTotalEmployeesByKeyword(String keyword) {
		return employeeMapper.getTotalEmployeesByKeyword(keyword); 
	}
}
