package com.cg.apps.employeemswithoutjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.employeemswithoutjpa.ui.EmployeeUI;


@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args){
       ConfigurableApplicationContext context= SpringApplication.run(EmployeeApplication.class, args);
       EmployeeUI employeeUI=context.getBean(EmployeeUI.class);
       employeeUI.start();

    }

}
