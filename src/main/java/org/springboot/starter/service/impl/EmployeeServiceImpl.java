package org.springboot.starter.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springboot.starter.entity.Employee;
import org.springboot.starter.model.EmployeeModel;
import org.springboot.starter.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.glasnost.orika.MapperFacade;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	private MapperFacade mapperFacade;

	
	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		emp.getAddresses().forEach(add->System.out.println(add.getEmpNo()));
		return emp;
	}

	@Override
	public EmployeeModel getById(Integer id) {
		Employee emp = employeeRepository.getOne(id);
		EmployeeModel model = mapperFacade.map(emp, EmployeeModel.class);
		return model;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

}
