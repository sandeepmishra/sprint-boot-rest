package org.springboot.starter.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springboot.starter.entity.Employee;
import org.springboot.starter.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public Employee getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

}
