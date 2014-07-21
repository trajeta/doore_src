package com.bit.java54th.softdrink.doore.dao;

public abstract class DAOFactory {

	// List of DAO types supported by the factory
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	public abstract ProductDAO getProductDAO();
	public abstract CustomerDAO getCustomerDAO();
	public abstract VillageDAO getVillageDAO();
	public abstract SharingDAO getSharingDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL:
				return new MySqlDAOFactory(); 
			default: 
				return null;
		}
	}
}
