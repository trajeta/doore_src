package com.bit.java54th.softdrink.doore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.connector.Request;
import org.eclipse.jdt.internal.compiler.parser.CommitRollbackParser;





public class MySqlProductDAO implements ProductDAO {
	String databaseURL = "jdbc:mysql://182.211.145.33/doore";
	String username = "root";
	String password = "softdrink123";

	@Override
	public List<ProductVO> findAllProducts() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT *  FROM products INNER JOIN product_detail ON products.product_id = product_detail.product_id;";

					
			ResultSet rset = stmt.executeQuery(sqlStr);
			

			while (rset.next()) { // list all the authors
				int id = rset.getInt("product_id");
				String name = rset.getString("product_name");
				byte[] picture = rset.getBytes("product_picture");
				String registry = rset.getString("product_registry");
				String last_update = rset.getString("product_last_update");
				int cutomer_id = rset.getInt("customer_id");
				int category_id = rset.getInt("category_id");
				String detail_text_1 = rset.getString("detail_text_1");
				String detail_text_2 = rset.getString("detail_text_2");
				String detail_text_3 = rset.getString("detail_text_3");
				String detail_decription = rset.getString("detail_decription");
			
				productList.add(new ProductVO(id,name,picture,registry,last_update,cutomer_id,category_id,detail_text_1
						,detail_text_2,detail_text_3,detail_decription));
				
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		
	
		return productList;
	}
	@Override
	public List<ProductVO> findIDProdcuts(int customer_id){
		
		Connection conn = null;
		Statement stmt = null;
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from products Inner join product_detail on products.product_id = product_detail.product_id where products.customer_id="+customer_id+";";

					
			ResultSet rset = stmt.executeQuery(sqlStr);
			

			while (rset.next()) { // list all the authors
				int id = rset.getInt("product_id");
				String name = rset.getString("product_name");
				byte[] picture = rset.getBytes("product_picture");
				String registry = rset.getString("product_registry");
				String last_update = rset.getString("product_last_update");
				int cutomer_id = rset.getInt("customer_id");
				int category_id = rset.getInt("category_id");
				String detail_text_1 = rset.getString("detail_text_1");
				String detail_text_2 = rset.getString("detail_text_2");
				String detail_text_3 = rset.getString("detail_text_3");
				String detail_decription = rset.getString("detail_decription");
			
				productList.add(new ProductVO(id,name,picture,registry,last_update,cutomer_id,category_id,detail_text_1
						,detail_text_2,detail_text_3,detail_decription));
				
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		
	
		return productList;
	}
	@Override
	public CategoryVO findCategoryID(int category_id){
		Connection conn = null;
		Statement stmt = null;
		
		CategoryVO CategoryVO = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT *  FROM category where category_id ="+category_id+";";
					
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int id = rset.getInt("category_id");
				String name = rset.getString("category_name");
				String category_text1 = rset.getString("category_text1");
				String category_text2 = rset.getString("category_text2");
				String category_text3 = rset.getString("category_text3");
			
				CategoryVO = new CategoryVO(id,name,category_text1,category_text2,category_text3);
				
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return CategoryVO;
	}
	@Override
	public  List<ProductVO> findProductByVillageID(int village_id){
		Connection conn = null;
		Statement stmt = null;
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM product_village , products JOIN product_detail ON products.product_id = product_detail.product_id where product_village.village_id="+village_id+";";

					
			ResultSet rset = stmt.executeQuery(sqlStr);
			

			while (rset.next()) { // list all the authors
				int id = rset.getInt("product_id");
				String name = rset.getString("product_name");
				byte[] picture = rset.getBytes("product_picture");
				String registry = rset.getString("product_registry");
				String last_update = rset.getString("product_last_update");
				int cutomer_id = rset.getInt("customer_id");
				int category_id = rset.getInt("category_id");
				String detail_text_1 = rset.getString("detail_text_1");
				String detail_text_2 = rset.getString("detail_text_2");
				String detail_text_3 = rset.getString("detail_text_3");
				String detail_decription = rset.getString("detail_decription");
			
				productList.add(new ProductVO(id,name,picture,registry,last_update,cutomer_id,category_id,detail_text_1
						,detail_text_2,detail_text_3,detail_decription));
				
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		
	
		return productList;
	}
	@Override
	public ProductVO findProductByID(int product_id) {
		Connection conn = null;
		Statement stmt = null;
		
		ProductVO productVO = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT *  FROM products "
					+ "JOIN product_detail ON products.product_id = product_detail.product_id where products.product_id="+product_id+";";
					
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int id = rset.getInt("product_id");
				String name = rset.getString("product_name");
				byte[] picture = rset.getBytes("product_picture");
				String registry = rset.getString("product_registry");
				String last_update = rset.getString("product_last_update");
				int cutomer_id = rset.getInt("customer_id");
				int category_id = rset.getInt("category_id");
				String detail_text_1 = rset.getString("detail_text_1");
				String detail_text_2 = rset.getString("detail_text_2");
				String detail_text_3 = rset.getString("detail_text_3");
				String detail_decription = rset.getString("detail_decription");
			
				productVO = new ProductVO(id,name,picture,registry,last_update,cutomer_id,category_id,detail_text_1
						,detail_text_2,detail_text_3,detail_decription);
				
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return productVO;
	}
	
	
	@Override
	public int createProduct(String product_name, byte[] product_picture,int customer_id,int category_id,
			String detail_text_1,String detail_text_2, String detail_text_3, String detail_decription,
			int village_id) {
		Connection conn = null;
		Statement stmt = null;
		int success1 = 0, success2=0,success3=0;
		int product_id=0;
		ProductVO productVO = null;
		ResultSet rset;
		village_id=2;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			String sqlStr = "insert into products(product_name,product_picture,product_registry,customer_id,category_id)values('"
							+ product_name +"',"+product_picture+",now(),"+customer_id+","+category_id+")";
			success1 = stmt.executeUpdate(sqlStr);
			System.out.println("success1 : "+success1);
			
		
			if(success1 == 1){
				
				 sqlStr= " SELECT LAST_INSERT_ID() as product_id ";
				rset = stmt.executeQuery(sqlStr);
				while(rset.next()){
					product_id = rset.getInt("product_id");
				}
				System.out.println("product_id : "+product_id);
				sqlStr="insert into product_village(product_id , village_id) values("
						+product_id+","+village_id+")";
				success2 = stmt.executeUpdate(sqlStr);
				System.out.println("success2 : "+success2);
			}else{
				conn.rollback();
			}
			
			sqlStr = "insert into product_detail(product_id,detail_text_1,detail_text_2,detail_text_3,detail_decription) values ("
					+product_id+",'"+detail_text_1+"','"+detail_text_2+"','"+detail_text_3+"','"+detail_decription+"')";
			success3 = stmt.executeUpdate(sqlStr);
			System.out.println("success3 : "+success3);
			if(success1==1 && success2==1&&success3==1){
				conn.commit();	
			}else{
				conn.rollback();
			}
				
		
			
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		if(success1 ==1 && success2==1&&success3==1){
			return success1;
			}else {
				return 0;
			}

	}
	@Override
	public int createProduct(String product_name, byte[] product_picture,int customer_id,int category_id,
			String detail_text_1,String detail_text_2, String detail_text_3, String detail_decription
			) {
		Connection conn = null;
		Statement stmt = null;
		int success1 = 0, success2=0,success3=0;
		int product_id=0;
		ProductVO productVO = null;
		ResultSet rset;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			String sqlStr = "insert into products(product_name,product_picture,product_registry,customer_id,category_id)values('"
							+ product_name +"',"+product_picture+",now(),"+customer_id+","+category_id+")";
			success1 = stmt.executeUpdate(sqlStr);
			System.out.println("success1 : "+success1);
			
		
			
			sqlStr = "insert into product_detail(product_id,detail_text_1,detail_text_2,detail_text_3,detail_decription) values ("
					+product_id+",'"+detail_text_1+"','"+detail_text_2+"','"+detail_text_3+"','"+detail_decription+"')";
			success3 = stmt.executeUpdate(sqlStr);
			System.out.println("success3 : "+success3);
			if(success1==1 && success2==1&&success3==1){
				conn.commit();	
			}else{
				conn.rollback();
			}
				
		
			
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		if(success1 ==1 && success2==1&&success3==1){
			return success1;
			}else {
				return 0;
			}

	}

	@Override
	public int updateProduct(int product_id, String product_name, byte[] product_picture,String detail_text_1,String detail_text_2,String detail_text_3,
			String detail_decription, int village_id) {
		Connection conn = null;
		Statement stmt = null;
		int success1 = 0, success2 = 0, success3= 0;
		ProductVO productVO = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "update products set product_name = '"+product_name+"',product_picture="+product_picture+" where product_id="+product_id+";";
			success1 = stmt.executeUpdate(sqlStr);
			
			sqlStr= "update product_detail set detail_text_1 = '"+detail_text_1+"',detail_text_2='"+detail_text_2
				+"',detail_text_3='"+detail_text_3+"',detail_decription='"+detail_decription+"' where product_id="+product_id+";";
			success2 = stmt.executeUpdate(sqlStr);
			
			sqlStr= "update product_village set product_id="+product_id+",village_id="+village_id+" where product_id="+product_id+";";
				success2 = stmt.executeUpdate(sqlStr);
			
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		if(success1==1 && success2==1){
			return 1;
		}else return 0;
	}

	@Override
	public int deleteProduct(int product_id) {
		Connection conn = null;
		Statement stmt = null;
		int success1 = 0,success2=0;
		ProductVO productVO = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "DELETE FROM products WHERE product_id ="+product_id;

			success1 = stmt.executeUpdate(sqlStr);
		

			
		} catch (SQLException ex) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE, null,
					ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		
if(success1==1 ){
		return 1;
	}else return 0;

}
}
