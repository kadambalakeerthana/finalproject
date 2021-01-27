package com.bankapp.service;

import java.util.List;

import com.bankapp.entities.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int empId);

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(int empId, Employee employee);

	public Employee deleteEmployee(int empId);
}
