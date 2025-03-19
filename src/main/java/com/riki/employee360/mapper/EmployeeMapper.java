package com.riki.employee360.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.riki.employee360.model.Employee;


@Mapper
public interface EmployeeMapper {
	
	@Insert("INSERT INTO employees(name, position, phone, email) " +
            "VALUES(#{name}, #{position}, #{phone}, #{email})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmployee(Employee employee);

	@Select("SELECT LPAD(id::text, 3, '0') AS id, name, position, phone, email " +
	"FROM employees " +
	"WHERE name ILIKE '%' || #{keyword} || '%' OR position ILIKE '%' || #{keyword} || '%' " +
	"ORDER BY id LIMIT #{limit} OFFSET #{offset}")
	List<Employee> searchEmployees(@Param("keyword") String keyword, @Param("limit") int size, @Param("offset") int offset);
	
	@Select("SELECT COUNT(*) FROM employees " +
	"WHERE name ILIKE '%' || #{keyword} || '%' OR position ILIKE '%' || #{keyword} || '%'")
	int getTotalEmployeesByKeyword(@Param("keyword") String keyword);
	
}


