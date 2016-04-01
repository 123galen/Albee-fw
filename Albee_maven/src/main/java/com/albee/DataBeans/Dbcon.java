package com.albee.DataBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;

public class Dbcon {
	
//		private LoginData loginData;
		private ShippingData shippingData;
		
		public Dbcon() throws SQLException{
			//this.loginData = getLoginDetails();
		//	this.shippingData = getUserDetails();
		}


//		public LoginData getLoginData() throws SQLException {
//			return getLoginDetails();
//		}
		
		public ShippingData getShippingData() throws SQLException {
			return getUserDetails();
		}


//		public void setLoginData(LoginData loginData) {
//			this.loginData = loginData;
//		}
//		
//		public void setShippingData(ShippingData shippingData) {
//			this.shippingData = shippingData;
//		}
		


		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "org.h2.Driver"; // org.h2.Driver
		static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";	
	

		// Database credentials
		static final String USER = "sa";
		static final String PASS = "";

	/*public static void main(String[] args) throws SQLException {
		    Dbcon dbcon = new Dbcon();
			java.sql.Connection conn = null;
			java.sql.Statement stmt = null;
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM AlbeeLogin");

			while (rs.next()) {
				System.out.println(rs.getString("email"));
				String email=rs.getString(1);
				String password = rs.getString(2);
				System.out.println(email+" "+password);
				System.out.println(rs.getString("password"));
				
				dbcon.getLoginData().setEmail(email);
				dbcon.getLoginData().setPassword(password);
			}
			conn.close();
		}*/
	
		LoginData getLoginDetails() throws SQLException{
			java.sql.Connection conn = null;
			java.sql.Statement stmt = null;
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM AlbeeLogin");
			
			LoginData loginData = new LoginData();

			while (rs.next()) {
				System.out.println(rs.getString("email"));
				String email=rs.getString(1);
				String password = rs.getString(2);
				System.out.println(email+" "+password);
				System.out.println(rs.getString("password"));
				
//				loginData.setEmail(email);
//				loginData.setPassword(password);
			}
			conn.close();
			return loginData;
			
		}
		
		ShippingData getUserDetails() throws SQLException{
			java.sql.Connection conn = null;
			java.sql.Statement stmt = null;
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from albeeuserdetails");
			
			ShippingData shippingData = new ShippingData();

			while (rs.next()) {
				System.out.println(rs.getString("fname"));
				String fname=rs.getString(1);
				String lname = rs.getString(2);
				String company = rs.getString(3);
				String stadd1 = rs.getString(4);
				String stadd2 = rs.getString(5);
				String city = rs.getString(6);
				String zipcode = rs.getString(7);
				String state = rs.getString(8);
				String phone = rs.getString(9);
		
				
				shippingData.setFname(fname);
				shippingData.setLname(lname);
				shippingData.setCompany(company);
				shippingData.setStAdd1(stadd1);
				shippingData.setStAdd2(stadd2);
				shippingData.setCity(city);
				shippingData.setZipCode(zipcode);
				shippingData.setState(state);
				shippingData.setPhone(phone);
				
			}
			conn.close();
			return shippingData;
			
		}
	
	    

		
		/*private void conn() throws SQLException {
			java.sql.Connection conn = null;
			java.sql.Statement stmt = null;

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM AlbeeLogin");

			while (rs.next()) {
				System.out.println(rs.getString("email"));
			
				String email=rs.getString(1);
				String password = rs.getString(2);
				
				System.out.println(rs.getString("password"));
			}
			conn.close();
		}*/
		
		
}
//}

	