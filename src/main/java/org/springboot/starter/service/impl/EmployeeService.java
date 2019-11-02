package org.springboot.starter.service.impl;

import java.util.List;

import org.springboot.starter.model.EmployeeModel;
import org.springboot.starter.retail.entities.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	EmployeeModel getById(Integer id);
	
	List<Employee> getEmployees();
}
