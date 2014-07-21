package com.bit.java54th.softdrink.doore.dao;

import java.util.logging.*;
import java.sql.*;

import com.bit.java54th.softdrink.doore.dao.MySqlCustomerDAO;

public class MySqlCustomerDAO implements CustomerDAO {
	String databaseURL = "jdbc:mysql://182.211.145.33/doore";
	String username = "root";
	String password = "softdrink123";

	
	
	public CustomerVO findCustomerById(int customerId) {
		Connection conn = null;
		Statement stmt = null;
		
		CustomerVO customerVO = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM customers where customer_id=" + customerId;

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) {
				String customerName = rset.getString("customer_name");
				int customerConnection = rset.getInt("customer_connection");
				boolean customerAutoLogin = rset.getBoolean("customer_auto_login");
				String customerEmail = rset.getString("customer_email");
				String customerPassword = rset.getString("customer_password");
				String customerRegistryDay = rset.getString("customer_registry");
				String customerLastUpdate = rset.getString("customer_last_update");
				
				customerVO = new CustomerVO(customerId, customerName, customerConnection, customerAutoLogin, customerEmail, customerPassword, customerRegistryDay, customerLastUpdate);
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		
		return customerVO;
	}
	
	public CustomerVO findCustomerByEmail(String customerEmail) {
		Connection conn = null;
		Statement stmt = null;
		
		CustomerVO customerVO = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM customers where customer_email='"+customerEmail+"'";

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) {
				String customerName = rset.getString("customer_name");
				int customerConnection = rset.getInt("customer_connection");
				boolean customerAutoLogin = rset.getBoolean("customer_auto_login");
				String customerPassword = rset.getString("customer_password");
				String customerRegistryDay = rset.getString("customer_registry");
				String customerLastUpdate = rset.getString("customer_last_update");
				int customerId = rset.getInt("customer_id");
				
				customerVO = new CustomerVO(customerId, customerName, customerConnection, customerAutoLogin, customerEmail, customerPassword, customerRegistryDay, customerLastUpdate);
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		
		return customerVO;
	}
	
	public int createCustomer(String customerName, int customerConnection, String customerEmail, String customerPassword, int customerAutoLogin, String customerRegistry) {
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			
			String sqlStr = "INSERT INTO customers(customer_name, customer_connection, customer_email, customer_password, customer_auto_login, customer_registry) VALUES ( '"
			+ customerName + "', " 
					+ customerConnection + ", '" 
						+ customerEmail + "', '"
						+ customerPassword + "', "
						+ customerAutoLogin +  ", now()) ";
			result = stmt.executeUpdate(sqlStr);
			
			
		} catch (SQLException ex) {
		Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex2) {
		Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null, ex2);
		} finally {
			try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE,
					null, ex);
			}
		}
		return result;
	}
	
	public int updateCustomer(int customerId, String customerName) {
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			
			String sqlStr = "UPDATE customers SET customer_name ='"
			+ customerName + "' WHERE customer_id = " + customerId;
			System.out.println(sqlStr);
			result = stmt.executeUpdate(sqlStr);
			
		} catch (SQLException ex) {
		Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex2) {
		Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null, ex2);
		} finally {
			try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE,
					null, ex);
			}
		}
		return result;
	}
	
	public int deleteCustomer(int customerId) {
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			
			String sqlStr = "DELETE FROM customers WHERE customer_id = " + customerId;
			System.out.println(sqlStr);
			result = stmt.executeUpdate(sqlStr);
		
			
		} catch (SQLException ex) {
		Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex2) {
		Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE, null, ex2);
		} finally {
			try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(MySqlCustomerDAO.class.getName()).log(Level.SEVERE,
					null, ex);
			}
		}
		return result;
	}
}