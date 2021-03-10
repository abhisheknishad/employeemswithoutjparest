package com.cg.apps.employeemswithoutjpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.employeemswithoutjpa.beans.Employee;
import com.cg.apps.employeemswithoutjpa.exceptions.EmployeeNotFoundException;

import java.util.*;

import javax.annotation.PostConstruct;

@Repository
public class EmployeeDaoImp implements IEmployeeDao {

	@Autowired
	private StoreHolder storeHolder;

	private Map<Integer, Employee> store;

	@PostConstruct
	public void afterInit() {
		store = storeHolder.getStore();
	}

	public int generateId() {
		int generateId=store.size()+1;
		return generateId;
	}

	@Override
	public void add(Employee employee) {
		int id = generateId();
		employee.setId(id);
		store.put(id, employee);

	}

	@Override
	public Employee findById(int id) {
		if(!store.containsKey(id)) {
			throw new EmployeeNotFoundException("employee doesn't exist for id="+id);
		}
		Employee emp=store.get(id);
	    return emp; 
	}

	@Override
	public void removeById(int id) {
		store.remove(id);

	}

	@Override
	public List<Employee> findAll() {
		Collection<Employee> employee = store.values();
		List<Employee> list = new ArrayList<>(employee);
		return list;
	}

	@Override
	public Employee update(Employee emp) {
		store.put(emp.getId(),emp);
		return emp;
	}

	@Override
	public void delete(int id) {
		store.remove(id);
		
	}

}
