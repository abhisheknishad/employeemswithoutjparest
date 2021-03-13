package com.cg.apps.customerms.entities;

import java.util.Set;

public class Customer {

	private long custId;
	private String name;
	private Account account;
	Set<Item>boughtItems;
	
	public Customer() {}
	public Customer(long custId, String name, Account account, Set<Item> boughtItems) {
		this.custId = custId;
		this.name = name;
		this.account = account;
		this.boughtItems = boughtItems;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Set<Item> getBoughtItems() {
		return boughtItems;
	}
	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}
	@Override
	public int hashCode() {
		return (int)custId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (custId != other.custId)
			return false;
		return true;
	}
	
	
}
