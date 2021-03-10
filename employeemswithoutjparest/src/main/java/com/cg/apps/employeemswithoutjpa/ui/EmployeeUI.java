package com.cg.apps.employeemswithoutjpa.ui;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.employeemswithoutjpa.beans.Employee;
import com.cg.apps.employeemswithoutjpa.exceptions.*;
import com.cg.apps.employeemswithoutjpa.service.*;

@Component
public class EmployeeUI {
	@Autowired
	private IEmployeeService service;
	public static void main(String [] args) {
		EmployeeUI project = new EmployeeUI();
		project.start();
	}
	public void start() {
		try {
		Employee abhishek=service.addEmployee("Abhishek",40000);
		Employee john = service.addEmployee("John", 50000);
		Employee  raghav=service.addEmployee("Raghav", 60000);
		Employee  peter=service.addEmployee("peter", 70000);
		
		
		System.out.println("*****DISPLAY SINGLE EMPLOYEE*****");				//Displaying Single Employee
		display(abhishek);
		
		
		System.out.println("\n*****DISPLAY BY ID******");						//Displaying Employee By id
		Employee employeeFetched=service.findById(3);
		display(employeeFetched);
		
		/*int inputId=2;
		service.removeById(inputId);*/
		
		System.out.println("\n****DISPLAY ALL EMPLOYEE*****");					//Displaying All Employee
		List<Employee>employees=service.findAll();
		displayAll(employees);
		
		}catch(InvalidIdException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidSalaryException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidEmployeeNameException e) {
			System.out.println(e.getMessage());
		}
		catch(EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		}		
		
	}
	void displayAll(Collection<Employee>employees) {
		for(Employee emp:employees) {
			display(emp);
		}
		
	}
	void display(Employee employee) {
		System.out.println("Id:"+employee.getId()+"\nName:"+employee.getName()+"\nSalary:"+employee.getSalary());
	}

}
