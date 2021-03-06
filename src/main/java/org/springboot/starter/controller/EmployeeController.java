package org.springboot.starter.controller;

import java.util.List;

import org.springboot.starter.model.EmployeeModel;
import org.springboot.starter.retail.entities.Employee;
import org.springboot.starter.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServicve;
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		employee = employeeServicve.createEmployee(employee);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get-employees")
	public ResponseEntity<List<Employee>> getEmployeeList(){
		List<Employee> employeeList = employeeServicve.getEmployees();
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(employeeList, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get-employees/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeList(@PathVariable("id") Integer id){
		EmployeeModel employeeList = employeeServicve.getById(id);
		ResponseEntity<EmployeeModel> response = new ResponseEntity<EmployeeModel>(employeeList, HttpStatus.OK);
		return response;
	}
}
