package com.bigbell.springboot.cruddemo.dao;

import java.util.List;

import com.bigbell.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findeById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
