package com.bit.java54th.softdrink.doore.dao;

public class MySqlDAOFactory extends DAOFactory {
	public ProductDAO getProductDAO() {
		return new MySqlProductDAO();	
	}
	
	public CustomerDAO getCustomerDAO() {
		return new MySqlCustomerDAO();	
	}
		
	public VillageDAO getVillageDAO() {
		return new MySqlVillageDAO();	
	}
	
	public SharingDAO getSharingDAO() {
		return new MySqlSharingDAO();	
	}

}