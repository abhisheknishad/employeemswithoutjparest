package com.cg.apps.customerms.dao;

import com.cg.apps.customerms.entities.Customer;

public interface ICustomerDao {
	
	Customer add(Customer customer);
	
	Customer findById(long custId);
	
	Customer update(Customer customer);

}
