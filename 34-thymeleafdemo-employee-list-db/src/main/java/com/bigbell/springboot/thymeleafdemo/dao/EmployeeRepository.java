package com.bigbell.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigbell.springboot.thymeleafdemo.entity.Employee;
	
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// that's it ... no need to write any code!!
}
