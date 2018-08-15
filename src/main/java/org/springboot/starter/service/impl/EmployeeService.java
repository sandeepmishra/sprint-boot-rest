package org.springboot.starter.service.impl;

import java.util.List;

import org.springboot.starter.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	Employee getById(Integer id);
	
	List<Employee> getEmployees();
}
