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

public class MySqlVillageDAO implements VillageDAO {
	String databaseURL = "jdbc:mysql://182.211.145.33/doore";
	String username = "root";
	String password = "softdrink123";

	// 주민에 따른 마을조회
	public List<VillageVO> getVillageByCustID(int customer_id) {
		Connection conn = null;
		Statement stmt = null;

		List<VillageVO> villageList = new ArrayList<VillageVO>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			System.out.println(customer_id);
			String sqlStr = "select * from villages as v"
					+ " join village_person as vp on v.village_id = vp.village_id"
					+ " where vp.customer_id =" + customer_id;
			System.out.println(sqlStr);
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int id = rset.getInt("village_id");
				String name = rset.getString("village_name");
				int count = rset.getInt("village_person_count");

				villageList.add(new VillageVO(id, name, count));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return villageList;
	}

	// 마을생성
	public void createVillage(int customer_id, String village_name) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// autocommit 해제 필요함
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			// 중복처리 클라이언트단에서 name을 가지고 처리(빌리지id를 모르기 때문에 빌리지name을 쓰기위해)
			// 빌리지 네임을 중복이 가능하도록 하면 synchronized 필요함

			conn.setAutoCommit(false);
			String sqlStr = "insert into villages (village_id, village_name, village_person_count, village_registry) values(null"
					+ ", '" + village_name + "'," + 1 + ", now())";

			int insertVNum = stmt.executeUpdate(sqlStr);

			sqlStr = "select village_id from villages where village_name = '"
					+ village_name + "'";

			ResultSet rset = stmt.executeQuery(sqlStr);

			int id = 0;

			while (rset.next()) {
				id = rset.getInt("village_id");
			}

			sqlStr = "insert into village_leader values(" + id + ","
					+ customer_id + ")";
			int insertVLNum = stmt.executeUpdate(sqlStr);

			sqlStr = "insert into village_person values(" + id + ","
					+ customer_id + ")";
			int insertVPNum = stmt.executeUpdate(sqlStr);

			if (insertVNum == 0 || insertVLNum == 0 || insertVPNum == 0) {
				conn.rollback();
			} else {
				conn.commit();
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	// 마을 수정(디비에 따라 아직 이름만 수정)
	public void modifyVillage(int village_id, String village_name) {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "update villages set village_name = '"
					+ village_name + "'" + " where village_id = " + village_id;

			int updateVNum = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	// 마을 삭제 cascade옵션을 이용해 로직을 적게
	public void deleteVillage(int village_id) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// cascade 옵션으로 인해 빌리지 테이블의 마을 삭제 시 자식테이블의 행들도 삭제가 될 것.(product_village, village_leader, village_person)
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "delete from villages where village_id = "
					+ village_id;

			int deleteVNum = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	// 해당 마을의 주민들을 가져오는 메소드
	public List<CustomerVO> viewVillageCust(int village_id) {
		Connection conn = null;
		Statement stmt = null;

		List<CustomerVO> vcustomerList = new ArrayList<CustomerVO>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from customers as c"
					+ " join village_person as vp on c.customer_id = vp.customer_id"
					+ " where vp.village_id =" + village_id;

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				
				int customerId = rset.getInt("customer_id");
				String customerName = rset.getString("customer_name");
				int customerConnection = rset.getInt("customer_connection");
				boolean customerAutoLogin = rset.getBoolean("customer_auto_login");
				String customerEmail = rset.getString("customer_email");
				String customerPassword = rset.getString("customer_password");
				String customerRegistryDay = rset.getString("customer_registry");
				String customerLastUpdate = rset.getString("customer_last_update");
				
				vcustomerList.add(new CustomerVO(customerId, customerName, customerConnection, customerAutoLogin, customerEmail, customerPassword, customerRegistryDay, customerLastUpdate));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return vcustomerList;
	}

	// 마을로 초대한 주민이 수락했을때
	public void inviteCustomer(int customer_id, int village_id) {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			conn.setAutoCommit(false);
			String sqlStr = "insert into village_person values(" + village_id
					+ ", " + customer_id + ")";

			int insertVPNum = stmt.executeUpdate(sqlStr);

			sqlStr = "update villages set village_person_count = village_person_count + "
					+ 1 + " where village_id = " + village_id;

			int updateVNum = stmt.executeUpdate(sqlStr);

			if (insertVPNum == 0 || updateVNum == 0) {
				conn.rollback();
			} else {
				conn.commit();
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	// 마을의 특정한 주민을 삭제할때
	public void deleteCustomer(int customer_id, int village_id) {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			conn.setAutoCommit(false);
			String sqlStr = "delete from village_person where customer_id = "
					+ customer_id + " and village_id = " + village_id;

			int insertVPNum = stmt.executeUpdate(sqlStr);

			sqlStr = "update villages set village_person_count = village_person_count - "
					+ 1 + " where village_id = " + village_id;

			int updateVNum = stmt.executeUpdate(sqlStr);

			if (insertVPNum == 0 || updateVNum == 0) {
				conn.rollback();
			} else {
				conn.commit();
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	// 주민을 초대하기 위한 회원검색(마을의 주민을 제외하고)
	public List<CustomerVO> searchCustomer(String searchWord, int village_id) {
		Connection conn = null;
		Statement stmt = null;

		List<CustomerVO> customerList = new ArrayList<CustomerVO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "select * from customers where customer_id not in"
					+ " (select c.customer_id from customers as c join village_person as vp"
					+ " on c.customer_id = vp.customer_id where vp.village_id = "
					+ village_id + ") and (customer_name like '%" + searchWord
					+ "%' or customer_email like '%" + searchWord + "%')";

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int customerId = rset.getInt("customer_id");
				String customerName = rset.getString("customer_name");
				int customerConnection = rset.getInt("customer_connection");
				boolean customerAutoLogin = rset.getBoolean("customer_auto_login");
				String customerEmail = rset.getString("customer_email");
				String customerPassword = rset.getString("customer_password");
				String customerRegistryDay = rset.getString("customer_registry");
				String customerLastUpdate = rset.getString("customer_last_update");
				
				customerList.add(new CustomerVO(customerId, customerName, customerConnection, customerAutoLogin, customerEmail, customerPassword, customerRegistryDay, customerLastUpdate));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return customerList;
	}

	// 이장위임
	public void trustLeader(int customer_id, int village_id) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "update village_leader set customer_id = "
					+ customer_id + " where village_id = " + village_id;

			int updateVLNum = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlVillageDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlVillageDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}
	
	//깃 테스트
}
