package com.riki.employee360.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.riki.employee360.model.Employee;


@Mapper
public interface EmployeeMapper {
	
	@Insert("INSERT INTO employees(name, position, phone, email) " +
            "VALUES(#{name}, #{position}, #{phone}, #{email})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmployee(Employee employee);
	
}


