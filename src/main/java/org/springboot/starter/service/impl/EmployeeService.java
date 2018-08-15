package org.springboot.starter.service.impl;

import java.util.List;

import org.springboot.starter.entity.Employee;
import org.springboot.starter.model.EmployeeModel;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	EmployeeModel getById(Integer id);
	
	List<Employee> getEmployees();
}
