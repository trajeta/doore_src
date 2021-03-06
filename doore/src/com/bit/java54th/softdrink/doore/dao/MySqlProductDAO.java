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
         String sqlStr = "SELECT *  FROM products INNER JOIN product_detail ON products.product_id = product_detail.product_id order by product_detail.product_id;";

         ResultSet rset = stmt.executeQuery(sqlStr);

         while (rset.next()) { // list all the authors
            // list all the authors
            int id = rset.getInt("product_id");
            String name = rset.getString("product_name");
            byte[] picture = rset.getBytes("product_picture");
            String registry = rset.getString("product_registry");
            String last_update = rset.getString("product_last_update");
            int cutomer_id = rset.getInt("customer_id");
            int category_id = rset.getInt("category_id");
            String detail_key1 = rset.getString("detail_key");
            String detail_value1 = rset.getString("detail_value");
            rset.next();

            String detail_key2 = rset.getString("detail_key");
            String detail_value2 = rset.getString("detail_value");
            rset.next();
            String detail_key3 = rset.getString("detail_key");
            String detail_value3 = rset.getString("detail_value");

            productList.add(new ProductVO(id, name, picture, registry,
                  last_update, cutomer_id, category_id, detail_key1,
                  detail_value1, detail_key2, detail_value2, detail_key3,
                  detail_value3));
         }
      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }

      return productList;
   }

   @Override
   public List<ProductVO> findIDProdcuts(int customer_id) {

      Connection conn = null;
      Statement stmt = null;
      ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
      try {

         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = conn.createStatement();
         String sqlStr = "select * from products Inner join product_detail on products.product_id = product_detail.product_id where products.customer_id="
               + customer_id + "order by product_detail.product_id;";

         ResultSet rset = stmt.executeQuery(sqlStr);

         while (rset.next()) { // list all the authors
            // list all the authors
            int id = rset.getInt("product_id");
            String name = rset.getString("product_name");
            byte[] picture = rset.getBytes("product_picture");
            String registry = rset.getString("product_registry");
            String last_update = rset.getString("product_last_update");
            int cutomer_id = rset.getInt("customer_id");
            int category_id = rset.getInt("category_id");
            String detail_key1 = rset.getString("detail_key");
            String detail_value1 = rset.getString("detail_value");
            rset.next();

            String detail_key2 = rset.getString("detail_key");
            String detail_value2 = rset.getString("detail_value");
            rset.next();
            String detail_key3 = rset.getString("detail_key");
            String detail_value3 = rset.getString("detail_value");

            productList.add(new ProductVO(id, name, picture, registry,
                  last_update, cutomer_id, category_id, detail_key1,
                  detail_value1, detail_key2, detail_value2, detail_key3,
                  detail_value3));

         }
      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }

      return productList;
   }

   @Override
   public CategoryVO findCategoryID(int category_id) {
      Connection conn = null;
      Statement stmt = null;

      CategoryVO CategoryVO = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = conn.createStatement();
         String sqlStr = "SELECT *  FROM category where category_id ="
               + category_id + ";";

         ResultSet rset = stmt.executeQuery(sqlStr);

         while (rset.next()) { // list all the authors
            int id = rset.getInt("category_id");
            String name = rset.getString("category_name");
            CategoryVO = new CategoryVO(id, name);

         }
      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }
      return CategoryVO;
   }

   @Override
   public List<ProductVO> findProductByVillageID(int village_id) {
      Connection conn = null;
      Statement stmt = null;
      ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
      try {

         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = conn.createStatement();
         String sqlStr = "SELECT * FROM products join product_village on products.product_id = product_village.product_id JOIN product_detail ON products.product_id = product_detail.product_id where product_village.village_id="
               + village_id + " ORDER BY product_detail.product_id";
         ResultSet rset = stmt.executeQuery(sqlStr);

         while (rset.next()) { // list all the authors
            // list all the authors
            int id = rset.getInt("product_id");
            String name = rset.getString("product_name");
            byte[] picture = rset.getBytes("product_picture");
            String registry = rset.getString("product_registry");
            String last_update = rset.getString("product_last_update");
            int cutomer_id = rset.getInt("customer_id");
            int category_id = rset.getInt("category_id");
            String detail_key1 = rset.getString("detail_key");
            String detail_value1 = rset.getString("detail_value");
            rset.next();

            String detail_key2 = rset.getString("detail_key");
            String detail_value2 = rset.getString("detail_value");
            rset.next();
            String detail_key3 = rset.getString("detail_key");
            String detail_value3 = rset.getString("detail_value");

            productList.add(new ProductVO(id, name, picture, registry,
                  last_update, cutomer_id, category_id, detail_key1,
                  detail_value1, detail_key2, detail_value2, detail_key3,
                  detail_value3));

         }
      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
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
               + "JOIN product_detail ON products.product_id = product_detail.product_id where products.product_id="
               + product_id + ";";

         ResultSet rset = stmt.executeQuery(sqlStr);

         rset.first(); // list all the authors
         int id = rset.getInt("product_id");
         String name = rset.getString("product_name");
         byte[] picture = rset.getBytes("product_picture");
         String registry = rset.getString("product_registry");
         String last_update = rset.getString("product_last_update");
         int cutomer_id = rset.getInt("customer_id");
         int category_id = rset.getInt("category_id");
         String detail_key1 = rset.getString("detail_key");
         String detail_value1 = rset.getString("detail_value");
         rset.next();

         String detail_key2 = rset.getString("detail_key");
         String detail_value2 = rset.getString("detail_value");
         rset.next();
         String detail_key3 = rset.getString("detail_key");
         String detail_value3 = rset.getString("detail_value");

         productVO = new ProductVO(id, name, picture, registry, last_update,
               cutomer_id, category_id, detail_key1, detail_value1,
               detail_key2, detail_value2, detail_key3, detail_value3);

      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }
      return productVO;
   }

   @Override
   public int createProduct(String product_name, byte[] product_picture,
         int customer_id, int category_id, String detail_key1,
         String detail_value1, String detail_key2, String detail_value2,
         String detail_key3, String detail_value3, int village_id) {
      Connection conn = null;
      Statement stmt = null;
      int success1 = 0, success2 = 0, success3 = 0;
      int product_id = 0;
      ProductVO productVO = null;
      ResultSet rset;
      try {

         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = conn.createStatement();
         conn.setAutoCommit(false);

         String sqlStr = "insert into products(product_name,product_picture,product_registry,customer_id,category_id)values('"
               + product_name
               + "',"
               + product_picture
               + ",now(),"
               + customer_id + "," + category_id + ")";
         success1 = stmt.executeUpdate(sqlStr);
         System.out.println("success1 : " + success1);

         if (success1 == 1) {

            sqlStr = " SELECT LAST_INSERT_ID() as product_id ";
            rset = stmt.executeQuery(sqlStr);
            while (rset.next()) {
               product_id = rset.getInt("product_id");
            }
            System.out.println("product_id : " + product_id);
            sqlStr = "insert into product_village(product_id , village_id) values("
                  + product_id + "," + village_id + ")";
            success2 = stmt.executeUpdate(sqlStr);
            System.out.println("success2 : " + success2);
         } else {
            conn.rollback();
         }

         sqlStr = "insert into product_detail(product_id,detail_key,detail_value) values ("
               + product_id
               + ",'"
               + detail_key1
               + "','"
               + detail_value1
               + "')";
         success3 = stmt.executeUpdate(sqlStr);
         sqlStr = "insert into product_detail(product_id,detail_key,detail_value) values ("
               + product_id
               + ",'"
               + detail_key2
               + "','"
               + detail_value2
               + "')";
         success3 = stmt.executeUpdate(sqlStr);
         sqlStr = "insert into product_detail(product_id,detail_key,detail_value) values ("
               + product_id
               + ",'"
               + detail_key3
               + "','"
               + detail_value3
               + "')";
         success3 = stmt.executeUpdate(sqlStr);
         System.out.println("success3 : " + success3);
         if (success1 == 1 && success2 == 1 && success3 == 1) {
            conn.commit();
         } else {
            conn.rollback();
         }

      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }
      if (success1 == 1 && success2 == 1 && success3 == 1) {
         return success1;
      } else {
         return 0;
      }

   }

   @Override
   public int createProduct(String product_name, byte[] product_picture,
         int customer_id, int category_id, String detail_key1,
         String detail_value1, String detail_key2, String detail_value2,
         String detail_key3, String detail_value3) {
      Connection conn = null;
      Statement stmt = null;
      int success1 = 0, success2 = 0, success3 = 0;
      int product_id = 0;
      ProductVO productVO = null;
      ResultSet rset;

      try {

         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = conn.createStatement();
         conn.setAutoCommit(false);

         String sqlStr = "insert into products(product_name,product_picture,product_registry,customer_id,category_id)values('"
               + product_name
               + "',"
               + product_picture
               + ",now(),"
               + customer_id + "," + category_id + ")";
         success1 = stmt.executeUpdate(sqlStr);
         System.out.println("success1 : " + success1);

         sqlStr = "insert into product_detail(product_id,detail_key,detail_value) values ("
               + product_id
               + ",'"
               + detail_key1
               + "','"
               + detail_value1
               + "')";
         success3 = stmt.executeUpdate(sqlStr);
         sqlStr = "insert into product_detail(product_id,detail_key,detail_value) values ("
               + product_id
               + ",'"
               + detail_key2
               + "','"
               + detail_value2
               + "')";
         success3 = stmt.executeUpdate(sqlStr);
         sqlStr = "insert into product_detail(product_id,detail_key,detail_value) values ("
               + product_id
               + ",'"
               + detail_key3
               + "','"
               + detail_value3
               + "')";
         System.out.println("success3 : " + success3);
         if (success1 == 1 && success2 == 1 && success3 == 1) {
            conn.commit();
         } else {
            conn.rollback();
         }

      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }
      if (success1 == 1 && success2 == 1 && success3 == 1) {
         return success1;
      } else {
         return 0;
      }

   }

   @Override
   public int updateProduct(int product_id, String product_name,
         byte[] product_picture, String detail_key1, String detail_value1,
         String detail_key2, String detail_value2, String detail_key3,
         String detail_value3, int village_id) {
      Connection conn = null;
      Statement stmt = null;
      int success1 = 0, success2 = 0, success3 = 0;
      ProductVO productVO = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = conn.createStatement();
         String sqlStr = "update products set product_name = '"
               + product_name + "',product_picture=" + product_picture
               + " where product_id=" + product_id + ";";
         success1 = stmt.executeUpdate(sqlStr);

         sqlStr = "update product_detail set detail_value='" + detail_value1
               + "' where product_id=" + product_id
               + " and detail_key = '" + detail_key1 + "';";
         success2 = stmt.executeUpdate(sqlStr);
         sqlStr = "update product_detail set detail_value='" + detail_value2
               + "' where product_id=" + product_id
               + " and detail_key = '" + detail_key2 + "';";
         success2 = stmt.executeUpdate(sqlStr);
         sqlStr = "update product_detail set detail_value='" + detail_value3
               + "' where product_id=" + product_id
               + " and detail_key = '" + detail_key3 + "';";
         success2 = stmt.executeUpdate(sqlStr);

         sqlStr = "update product_village set product_id=" + product_id
               + ",village_id=" + village_id + " where product_id="
               + product_id + ";";
         success2 = stmt.executeUpdate(sqlStr);

      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }
      if (success1 == 1 && success2 == 1) {
         return 1;
      } else
         return 0;
   }

   @Override
   public int deleteProduct(int product_id) {
      Connection conn = null;
      Statement stmt = null;
      int success1 = 0, success2 = 0;
      ProductVO productVO = null;
      try {

         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = conn.createStatement();
         String sqlStr = "DELETE FROM products WHERE product_id ="
               + product_id;

         success1 = stmt.executeUpdate(sqlStr);

      } catch (SQLException ex) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex);
      } catch (ClassNotFoundException ex2) {
         Logger.getLogger(MySqlProductDAO.class.getName()).log(Level.SEVERE,
               null, ex2);
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(MySqlProductDAO.class.getName()).log(
                  Level.SEVERE, null, ex);
         }
      }

      if (success1 == 1) {
         return 1;
      } else
         return 0;

   }
}