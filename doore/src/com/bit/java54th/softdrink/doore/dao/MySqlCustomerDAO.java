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
						+ customerEmail + "', password('"
						+ customerPassword + "'), "
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
			
			String sqlStr = "UPDATE customers SET customer_name='"
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
	
	//로그인을 위한 이메일과 패스워드의 일치여부 확인
		public CustomerVO findCustomerByLogin(String customer_email, String customer_password) {
			Connection conn = null;
			Statement stmt = null;
			
			CustomerVO customerVO = null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(databaseURL, username, password);
				stmt = conn.createStatement();
				StringBuilder sqlStr = new StringBuilder();
				
				sqlStr.append("SELECT * FROM customers WHERE ");
				sqlStr.append("STRCMP(customer_email, '").append(customer_email)
						.append("') = 0 ");
				sqlStr.append("AND STRCMP(customer_password, PASSWORD('")
						.append(customer_password).append("')) = 0");
						
				
				ResultSet rset = stmt.executeQuery(sqlStr.toString());

				while (rset.next()) {
					int customerId = rset.getInt("customer_id");
					String customerName = rset.getString("customer_name");
					int customerConnection = rset.getInt("customer_connection");//테스트위해서 바꾼것 다시 바꿔야함 커스터머브이오도 마찬가지
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
		
		//이름과 이메일이 일치하는 사용자 찾기
		public CustomerVO findCustomerByNameEmail(String customer_email, String customer_name) {
			Connection conn = null;
			Statement stmt = null;
			
			CustomerVO customerVO = null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(databaseURL, username, password);
				stmt = conn.createStatement();
				StringBuilder sqlStr = new StringBuilder();
				
				sqlStr.append("SELECT * FROM customers WHERE ");
				sqlStr.append("STRCMP(customer_email, '").append(customer_email)
						.append("') = 0 ");
				sqlStr.append("AND STRCMP(customer_name, '")
						.append(customer_name).append("')) = 0");
						
				
				ResultSet rset = stmt.executeQuery(sqlStr.toString());

				while (rset.next()) {
					int customerId = rset.getInt("customer_id");
					String customerName = rset.getString("customer_name");
					int customerConnection = rset.getInt("customer_connection");//테스트위해서 바꾼것 다시 바꿔야함 커스터머브이오도 마찬가지
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
}