package com.cg.apps.employeemswithoutjpa.exceptions;

public class InvalidEmployeeNameException extends RuntimeException{
	public InvalidEmployeeNameException(String msg) {
		super(msg);
	}

}
