package com.cg.apps.employeemswithoutjpa.exceptions;

public class InvalidIdException extends RuntimeException{
	public InvalidIdException(String msg) {
		super(msg);
	}

}