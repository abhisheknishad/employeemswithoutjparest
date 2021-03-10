package com.cg.apps.employeemswithoutjpa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.apps.employeemswithoutjpa.beans.Employee;
import com.cg.apps.employeemswithoutjpa.dto.EmployeeDetails;


@Component
public class EmployeeUtil {

	    public EmployeeDetails toDetails(Employee emp){
	        EmployeeDetails details=new EmployeeDetails(emp.getId(), emp.getName(),emp.getSalary());
	        return details;
	    }

	    public List<EmployeeDetails> toDetailsList(Collection<Employee> employees){
	        List<EmployeeDetails>desired=new ArrayList<>();
	        for (Employee employee:employees){
	            EmployeeDetails details=toDetails(employee);
	            desired.add(details);
	        }
	        return desired;

	    }

	}
