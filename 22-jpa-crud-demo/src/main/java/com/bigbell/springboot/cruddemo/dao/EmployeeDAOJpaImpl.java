package com.bigbell.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigbell.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired	
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query query =
				entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// return the results
		return employees;

	}

	@Override
	public Employee findeById(int id) {
		
		// get employee
		Employee employee =
				entityManager.find(Employee.class, id);
		
		// return employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// save or update the employee
		Employee dbEmployee = entityManager.merge(employee);
		
		// update with id from db ... so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		
		// delete object with primary key
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();

	}

}
