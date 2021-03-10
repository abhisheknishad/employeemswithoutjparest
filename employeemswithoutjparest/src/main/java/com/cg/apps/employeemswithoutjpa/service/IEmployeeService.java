package com.cg.apps.employeemswithoutjpa.service;

import java.util.List;

import com.cg.apps.employeemswithoutjpa.beans.Employee;

public interface IEmployeeService {
	Employee addEmployee(String name, double salary);

	Employee findById(int id);

	List<Employee> findAll();

	Employee updateName(int id, String name);

	void deleteById(int id);
}
