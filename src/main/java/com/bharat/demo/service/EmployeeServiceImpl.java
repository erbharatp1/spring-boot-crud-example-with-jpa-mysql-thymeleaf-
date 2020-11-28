package com.bharat.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharat.demo.model.Employee;
import com.bharat.demo.repository.EmployeeRepository;

/**
 * 
 * @author Bharat
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	@Transactional
	public void delete(Employee emp) {
		employeeRepo.delete(emp);

	}

	@Override
	public List<Employee> findAll() {

		return employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> findById(long employeeId) {

		return employeeRepo.findById(employeeId);
	}

}
