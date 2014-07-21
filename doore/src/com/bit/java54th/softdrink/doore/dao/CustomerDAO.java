package com.bit.java54th.softdrink.doore.dao;


public interface CustomerDAO {
	public CustomerVO findCustomerById(int customerId);
	public CustomerVO findCustomerByEmail(String customerEmail);
	public int createCustomer(String customerName, int customerConnection, String customerEmail, String customerPassword, int customerAutoLogin, String customerRegistry);
	public int updateCustomer(int customerId, String customerName);
	public int deleteCustomer(int customerId);

}
