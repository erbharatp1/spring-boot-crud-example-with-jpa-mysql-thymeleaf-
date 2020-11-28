package com.bharat.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharat.demo.model.Employee;
/**
 * 
 * @author Bharat
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 
}
