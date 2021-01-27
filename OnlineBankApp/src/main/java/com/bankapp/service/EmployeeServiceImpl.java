package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.EmployeeRepo;
import com.bankapp.entities.Employee;
import com.bankapp.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("employee with id " + empId + "not found"));
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee deleteEmployee(int empId) {
		Employee empToDelete = getEmployeeById(empId);
		employeeRepo.delete(empToDelete);
		return empToDelete;
	}

	@Override
	public Employee updateEmployee(int empId, Employee employee) {
		Employee empToUpdate = getEmployeeById(empId);
		empToUpdate.setAddress(employee.getAddress());
		empToUpdate.setDob(employee.getDob());
		empToUpdate.setEmail(employee.getEmail());
		empToUpdate.setPhone(employee.getPhone());
		return employeeRepo.save(empToUpdate);
	}

}
