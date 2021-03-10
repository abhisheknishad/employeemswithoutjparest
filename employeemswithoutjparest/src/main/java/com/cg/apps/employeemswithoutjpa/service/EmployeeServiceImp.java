package com.cg.apps.employeemswithoutjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.employeemswithoutjpa.beans.Employee;
import com.cg.apps.employeemswithoutjpa.dao.EmployeeDaoImp;
import com.cg.apps.employeemswithoutjpa.dao.IEmployeeDao;
import com.cg.apps.employeemswithoutjpa.dao.StoreHolder;
import com.cg.apps.employeemswithoutjpa.exceptions.*;

@Service
public class EmployeeServiceImp implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;

	@Override
	public Employee addEmployee(String name, double salary) { // add method
		validateName(name);
		validateSalary(salary);
		Employee emp = new Employee(name, salary);
		dao.add(emp);
		return emp;
	}

	@Override
	public Employee findById(int id) { // Find by id method
		validateId(id);
		if (!(StoreHolder.store.containsKey(id))) {
			throw new EmployeeNotFoundException("Employee not found for id :" + id);
		}
		Employee emp = dao.findById(id);
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = dao.findAll();
		return employees;
	}

	@Override
	public Employee updateName(int id, String name) {
		validateName(name);
		Employee emp = findById(id);
		emp.setName(name);
		emp = dao.update(emp);
		return emp;
	}

	@Override
	public void deleteById(int id) {
		if (StoreHolder.store.containsKey(id)) {
			dao.delete(id);
		} else {
			throw new EmployeeNotFoundException("Employee not found for id :" + id);
		}

	}

	private void validateName(String name) {
		if (name.isEmpty() || name == null || name.trim().isEmpty()) {
			throw new InvalidEmployeeNameException("Name can't be null or emptyor greater than length 10");
		}

	}

	private void validateId(int id) {
		if (id < 0) {
			throw new InvalidIdException("id can't be negative");
		}

	}

	private void validateSalary(double salary) {
		if (salary < 0) {
			throw new InvalidSalaryException("salary can't be negative");
		}

	}

}
