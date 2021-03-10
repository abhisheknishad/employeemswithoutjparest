package com.cg.apps.employeemswithoutjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.apps.employeemswithoutjpa.beans.Employee;
import com.cg.apps.employeemswithoutjpa.dto.EmployeeDetails;
import com.cg.apps.employeemswithoutjpa.service.IEmployeeService;
import com.cg.apps.employeemswithoutjpa.util.EmployeeUtil;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;
    
    @Autowired
    private EmployeeUtil util;

    @GetMapping(value = "/byid/{id}")
    public EmployeeDetails fetchEmployee(@PathVariable("id") int employeeId) {
        Employee employee = service.findById(employeeId);
        EmployeeDetails emp=util.toDetails(employee);
        return emp;
    }

    @GetMapping
    public List<EmployeeDetails> allEmployee() {
        List<Employee> list = service.findAll();
        List<EmployeeDetails>desired=util.toDetailsList(list);
        return desired;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Employee requestData) {
        Employee created = service.addEmployee(requestData.getName(),requestData.getSalary());
        return "created employee with id=" + created.getId();
    }


    @PutMapping("/changename")
    public EmployeeDetails changeName(@RequestBody Employee employee) {
        employee = service.updateName(employee.getId(), employee.getName());
        EmployeeDetails emp=util.toDetails(employee);
        return emp;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Employee employee){
        service.deleteById(employee.getId());
        return "student deleted for id="+employee.getId();
    }


}
