package com.cg.apps.employeemswithoutjpa.dao;

import java.util.*;

import org.springframework.stereotype.Component;

import com.cg.apps.employeemswithoutjpa.beans.Employee;
@Component
public class StoreHolder {
	private StoreHolder() {
	}

	public static Map<Integer, Employee> store = new HashMap<>();

	public Map<Integer, Employee> getStore() {
		return store;
	}

}
