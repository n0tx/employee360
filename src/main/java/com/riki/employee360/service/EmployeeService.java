package com.riki.employee360.service;

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
}
