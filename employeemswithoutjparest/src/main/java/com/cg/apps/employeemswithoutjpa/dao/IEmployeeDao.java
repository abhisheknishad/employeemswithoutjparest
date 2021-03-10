package com.cg.apps.employeemswithoutjpa.dao;

import java.util.List;

import com.cg.apps.employeemswithoutjpa.beans.Employee;

public interface IEmployeeDao {
	void add(Employee employee);
	Employee findById(int id);
	void removeById(int id);
	List<Employee>findAll();
	Employee update(Employee emp);
	void delete(int id);
}
