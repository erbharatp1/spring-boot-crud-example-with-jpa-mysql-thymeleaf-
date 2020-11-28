package com.bharat.demo.service;

import java.util.List;
import java.util.Optional;

import com.bharat.demo.model.Employee;

public interface EmployeeService {

	void save(Employee employee);

	void delete(Employee emp);

	List<Employee> findAll();

	Optional<Employee> findById(long employeeId);

}
