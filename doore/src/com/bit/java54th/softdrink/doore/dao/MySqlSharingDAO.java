package com.bit.java54th.softdrink.doore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlSharingDAO implements SharingDAO {
	String databaseURL = "jdbc:mysql://182.211.145.33/doore";
	String username = "root";
	String password = "softdrink123";

	@Override
	public List<SharingVO> findAllSharings() {
		Connection conn = null;
		Statement stmt = null;
		List<SharingVO> sharings = new ArrayList<SharingVO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from sharings";
			System.out.println(sqlStr);
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int sharingID = rset.getInt("sharing_id");
				int applicationID = rset.getInt("sharing_application_id");
				int returnCheck = rset.getInt("sharing_return_check");
				String startDay = rset.getString("sharing_start_day");
				String endDay = rset.getString("sharing_end_day");
				int productID = rset.getInt("product_id");

				sharings.add(new SharingVO(sharingID, startDay, endDay,
						returnCheck, applicationID, productID));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return sharings;
	}

	@Override
	public SharingVO findSharingByID(int sharingID) {
		Connection conn = null;
		Statement stmt = null;

		SharingVO sharingVO = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM sharings where sharing_id="
					+ sharingID;
			System.out.println(sqlStr);
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int applicationID = rset.getInt("sharing_application_id");
				int returnCheck = rset.getInt("sharing_return_check");
				String startDay = rset.getString("sharing_start_day");
				String endDay = rset.getString("sharing_end_day");
				int productID = rset.getInt("product_id");

				sharingVO = new SharingVO(sharingID, startDay, endDay,
						returnCheck, applicationID, productID);

			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return sharingVO;
	}

	@Override
	public List<SharingVO> findSharingByApplicationID(int applicationID) {
		Connection conn = null;
		Statement stmt = null;

		List<SharingVO> sharings = new ArrayList<SharingVO>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM sharings where sharing_application_id="
					+ applicationID;
			System.out.println(sqlStr);
			ResultSet rset = stmt.executeQuery(sqlStr);
			while (rset.next()) { // list all the authors
				int sharingID = rset.getInt("sharing_id");
				int returnCheck = rset.getInt("sharing_return_check");
				String startDay = rset.getString("sharing_start_day");
				String endDay = rset.getString("sharing_end_day");
				int productID = rset.getInt("product_id");

				sharings.add(new SharingVO(sharingID, startDay, endDay,
						returnCheck, applicationID, productID));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return sharings;
	}

	@Override
	public int updateSharing(int sharingID, String startDay, String endDay) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "UPDATE sharings SET sharing_start_Day='"
					+ startDay + "', sharing_end_day='" + endDay + "'"
					+ " WHERE sharing_id = " + sharingID;
			System.out.println(sqlStr);
			result = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return result;
	}

	@Override
	public int deleteSharing(int sharingID) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "delete from sharings where sharing_id="
					+ sharingID;
			System.out.println(sqlStr);
			result = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return result;
	}

	@Override
	public int createSharing(int returnCheck, int applicationID,
			String startDay, String endDay, int productID) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "insert into sharings(sharing_application_id,sharing_return_check,sharing_start_day,sharing_end_day,product_id) values("
					+ applicationID
					+ ","
					+ returnCheck
					+ ",'"
					+ startDay
					+ "','" + endDay + "'," + productID + ")";

			System.out.println(sqlStr); // for debugging

			result = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return result;
	}

	@Override
	public int getLendingPeriod(int sharingID) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select datediff(s.sharing_end_day,s.sharing_start_day) as DiffDate from sharings as s where sharing_id ="
					+ sharingID;

			System.out.println(sqlStr); // for debugging

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				result = rset.getInt("DiffDate");
			}
			System.out.println("대여기간:" + result);
		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return result;
	}

	public int changeSharingState(int sharingID, int returnCheck) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "UPDATE sharings set sharing_return_check="
					+ returnCheck + " where sharing_id =" + sharingID;

			System.out.println(sqlStr); // for debugging
			result = stmt.executeUpdate(sqlStr);
		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return result;
	}

	@Override
	public int returnProduct(int sharingID) {
		Connection conn = null;
		Statement stmt = null;
		int result1 = 0, result2 = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "update sharings set sharing_end_day = curdate() where sharing_id="
					+ sharingID;
			System.out.println(sqlStr); // for debugging
			result1 = stmt.executeUpdate(sqlStr);
			sqlStr = "update sharings set sharing_return_check =1 where sharing_id="
					+ sharingID;
			System.out.println(sqlStr); // for debugging
			result2 = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		if (result1 == 1 && result2 == 1) {
			result1 = 1;
			return result1;
		} else {
			result1 = 0;
			return result1;
		}
	}

	@Override
	public List<SharingVO> findSharingByProductID(int productID) {
		Connection conn = null;
		Statement stmt = null;

		List<SharingVO> sharings = new ArrayList<SharingVO>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select s.sharing_id,s.sharing_application_id,s.sharing_return_check,s.sharing_start_day,s.sharing_end_day,p.product_id from sharings as s join products as p on s.product_id = p.product_id where p.product_id ="+productID;
			System.out.println(sqlStr);
			ResultSet rset = stmt.executeQuery(sqlStr);
			while (rset.next()) { // list all the authors
				int sharingID = rset.getInt("sharing_id");
				int applicationID = rset.getInt("sharing_application_id");
				int returnCheck = rset.getInt("sharing_return_check");
				String startDay = rset.getString("sharing_start_day");
				String endDay = rset.getString("sharing_end_day");
				
				sharings.add(new SharingVO(sharingID, startDay, endDay,
						returnCheck, applicationID, productID));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlSharingDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlSharingDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return sharings;
	}

}
