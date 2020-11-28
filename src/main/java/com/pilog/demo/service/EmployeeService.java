package com.pilog.demo.service;

import java.util.List;
import java.util.Optional;

import com.pilog.demo.model.Employee;

public interface EmployeeService {

	void save(Employee employee);

	void delete(Employee emp);

	List<Employee> findAll();

	Optional<Employee> findById(long employeeId);

}
