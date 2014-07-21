package com.bit.java54th.softdrink.doore.dao;

public class CustomerVO {
	private int customerId;
	private String customerName;
	private int customerConnection;
	private boolean customerAutoLogin;
	private String customerEmail;
	private String customerPassword;
	private String customerRegistry;
	private String customerLastUpdate;
	
	public CustomerVO(int customerId, String customerName, int customerConnection, String customerEmail, String customerPassword, String customerRegistry, String customerLastUpdate) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerConnection = customerConnection;
		this.customerAutoLogin = false;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerRegistry = customerRegistry;
		this.customerLastUpdate = customerLastUpdate;
	}
	
	public CustomerVO(int customerId, String customerName, int customerConnection, boolean customerAutoLogin, String customerEmail, String customerPassword, String customerRegistry, String customerLastUpdate) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerConnection = customerConnection;
		this.customerAutoLogin = false;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerRegistry = customerRegistry;
		this.customerLastUpdate = customerLastUpdate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerConnection() {
		return customerConnection;
	}

	public void setCustomerConnection(int customerConnection) {
		this.customerConnection = customerConnection;
	}

	public boolean isCustomerAutoLogin() {
		return customerAutoLogin;
	}

	public void setCustomerAutoLogin(boolean customerAutoLogin) {
		this.customerAutoLogin = customerAutoLogin;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerRegistry() {
		return customerRegistry;
	}

	public void setCustomerRegistry(String customerRegistry) {
		this.customerRegistry = customerRegistry;
	}

	public String getCustomerLastUpdate() {
		return customerLastUpdate;
	}

	public void setCustomerLastUpdate(String customerLastUpdate) {
		this.customerLastUpdate = customerLastUpdate;
	}


}
