package com.pilog.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilog.demo.model.Employee;
/**
 * 
 * @author Bharat
 *
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
 
}
