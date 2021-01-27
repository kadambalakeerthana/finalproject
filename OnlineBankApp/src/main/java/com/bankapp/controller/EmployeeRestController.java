package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entities.Employee;
import com.bankapp.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> allEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(path = "employee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable(name = "empId") int empId) {
		return employeeService.getEmployeeById(empId);
	}

	@PostMapping(path = "employee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PutMapping(path = "employee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@PathVariable(name = "empId") int empId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(empId, employee);
	}

	@DeleteMapping(path = "employee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee deleteEmployee(@PathVariable(name = "empId") int empId) {
		return employeeService.deleteEmployee(empId);
	}
}
