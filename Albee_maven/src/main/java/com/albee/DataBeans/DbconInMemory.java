package com.albee.DataBeans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.tools.Server;

public class DbconInMemory {
	
//	private LoginData loginData;
//	private ShippingData shippingData;
	public DbconInMemory() throws SQLException{
	//	this.loginData = getLoginData();
	//	this.shippingData = getUserDetails();
	}
	

	public LoginData getLoginData() throws SQLException {
		
//	 openServerModeInBrowser();
	 return insertWithPreparedStatementLogin();
	}
	
	public ShippingData getShippingData() throws SQLException {

		 return insertUserDetails();
		}
	

	// H2 Database Viewer Example
	

	    private static final String DB_DRIVER = "org.h2.Driver";
	   
	    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	    private static final String DB_USER = "";
	    private static final String DB_PASSWORD = "";

//	    public static void main(String[] args) throws Exception {
//	        try {
//	            openServerModeInBrowser();
//	            insertWithPreparedStatement();
//
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }

	    private static LoginData insertWithPreparedStatementLogin() throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement createPreparedStatement = null;
	        PreparedStatement insertPreparedStatement = null;
	        PreparedStatement selectPreparedStatement = null;
	        

	        String CreateQuery = "CREATE TABLE Albeelogin(email varchar(255) primary key, password varchar(255))";
	        String InsertQuery = "INSERT INTO Albeelogin" + "(email, password) values" + "(?,?)";
	        String SelectQuery = "select * from Albeelogin";
	        LoginData loginData = new LoginData();

	        try {
	            connection.setAutoCommit(false);

	            createPreparedStatement = connection.prepareStatement(CreateQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();

	            insertPreparedStatement = connection.prepareStatement(InsertQuery);
	            insertPreparedStatement.setString(1, "abcxyz@gmail.com");
	            insertPreparedStatement.setString(2, "abc123xyz");
	            insertPreparedStatement.executeUpdate();
	            insertPreparedStatement.close();

	            selectPreparedStatement = connection.prepareStatement(SelectQuery);
	            ResultSet rs = selectPreparedStatement.executeQuery();
	           
	            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
	            while (rs.next()) {
	                System.out.println("Email " + rs.getString("email") + " Password " + rs.getString("password"));
	                String email=rs.getString(1);
					String password = rs.getString(2);
	                loginData.setEmail(email);
					loginData.setPassword(password);
	                
	            }
	           
	            selectPreparedStatement.close();

	            connection.commit();
	            
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           connection.close();
	            System.out.println("Connection is closed");
	        }
	        return loginData;  
	    }

	    
	    private static ShippingData insertUserDetails() throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement createPreparedStatement = null;
	        PreparedStatement insertPreparedStatement = null;
	        PreparedStatement selectPreparedStatement = null;
	        

	        String CreateQuery = "CREATE TABLE AlbeeUser(fname varchar(25), lname varchar(25), company varchar(25), stadd1 varchar(50), stadd2 varchar(25), city varchar(25),zipcode varchar(10), state varchar(3), phone varchar(11))";
	        String InsertQuery = "INSERT INTO AlbeeUser" + "(fname, lname, company, stadd1, stadd2, city, zipcode, state, phone) values" + "(?,?,?,?,?,?,?,?,?)";
	        String SelectQuery = "select * from AlbeeUser";
	        ShippingData shippingData = new ShippingData();

	        try {
	            connection.setAutoCommit(false);

	            createPreparedStatement = connection.prepareStatement(CreateQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();

	            insertPreparedStatement = connection.prepareStatement(InsertQuery);
	            insertPreparedStatement.setString(1, "abc");
	            insertPreparedStatement.setString(2, "xyz");
	            insertPreparedStatement.setString(3, "abc corp");
	            insertPreparedStatement.setString(4, "100 north point st");
	            insertPreparedStatement.setString(5, "suite 200");
	            insertPreparedStatement.setString(6, "san francisco");
	            insertPreparedStatement.setString(7, "94133");
	            insertPreparedStatement.setString(8, "CA");
	            insertPreparedStatement.setString(9, "1111117890");
	            
	            insertPreparedStatement.executeUpdate();
	            insertPreparedStatement.close();

	            selectPreparedStatement = connection.prepareStatement(SelectQuery);
	            ResultSet rs = selectPreparedStatement.executeQuery();
	           
	            System.out.println("H2 In-Memory Database inserted through PreparedStatement for Albee user details");
	            while (rs.next()) {
	               System.out.println("fname " + rs.getString("fname") + " lname " + rs.getString("lname"));
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
	           
	            selectPreparedStatement.close();

	            connection.commit();
	            
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           connection.close();
	            System.out.println("Connection is closed");
	        }
	        return shippingData;  
	    }
	    private static Connection getDBConnection() {
	        Connection dbConnection = null;
	        try {
	            Class.forName(DB_DRIVER);
	        } catch (ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	        try {
	            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	            return dbConnection;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return dbConnection;
	    }
	   
//	    private static void openServerModeInBrowser() throws SQLException {
//	        Server server = Server.createTcpServer().start();
//	        System.out.println("Server started and connection is open.");
//	        System.out.println("URL: jdbc:h2:" + server.getURL() + "/mem:test");
//	    }
	}


