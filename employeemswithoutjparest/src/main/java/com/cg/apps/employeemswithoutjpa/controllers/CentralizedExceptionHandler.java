package com.cg.apps.employeemswithoutjpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.apps.employeemswithoutjpa.exceptions.*;

	@RestControllerAdvice
	public class CentralizedExceptionHandler {

	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(EmployeeNotFoundException.class)
	    public String handleStudentNotFound(EmployeeNotFoundException e){
	        return  e.getMessage();
	    }

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(InvalidEmployeeNameException.class)
	    public  String handleInvalidName(InvalidEmployeeNameException e){
	        return e.getMessage();
	    }

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(InvalidSalaryException.class)
	    public String handleInvalidScore(InvalidSalaryException e){
	        return e.getMessage();
	    }

}
