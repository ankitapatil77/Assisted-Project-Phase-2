package com.javaProgram.Phase2;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;




public class ConnectWithJDBC  {

	public static final String URLTOCONNECT = "jdbc:mysql://localhost:3306/product";


    public static final String USERNAME = "root";


    public static final String PASSWORD = "";


	private Connection connection;

    public static PreparedStatement statement ;
   public static ResultSet resultSet ; 
   public static int ProductId;

   public static void main(String[] args) throws ClassNotFoundException{
	
	   {
	        // Step 2: Establishing a connection
	    	ConnectWithJDBC connection = new ConnectWithJDBC();
	         
	        // Try block to check exceptions
	        try {
	        	  // 1. Load the Driver
	               Class.forName("com.mysql.cj.jdbc.Driver");

	               //	               2. Try to establish the connection to database
	
	               Connection dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, PASSWORD);
	
	               System.out.println("Successfully connected to the database now ...");
	               System.out.println();
	               System.out.println("*************Welcome To Ecommerce Application***************");
	               System.out.println();
	               System.out.println("*************We are Finding Product Details Using Product Id**********");
	               System.out.println();
	               
	               Scanner scan=new Scanner(System.in);
	               
	               System.out.println("Enter ProductId: ");
	               ProductId=scan.nextInt();
	               ConnectWithJDBC theMenu=new ConnectWithJDBC();
	               theMenu.getProductDtailsById(dbCon, ProductId);
	             
	        }catch (ClassNotFoundException|SQLException e) {
		
	        	System.out.println(e.getMessage());
		
	        }finally {
				
			}
	   }
	   }
	        void getProductDtailsById(Connection dbCon,int ProductId) throws SQLException {
	               // Step 3: Write a statement
	
	               String qry = "select * from productdetails where ProductId=?";
	                
	               statement = dbCon.prepareStatement(qry);
	               
				    statement.setInt(1, ProductId);
	            
	               
	            
	               resultSet = statement.executeQuery();
	 
	               System.out.println("ProductId      ProductName    ProductPrice");
	
	               if (resultSet.next()) {
	     
	            	    ProductId = resultSet.getInt("ProductId");
	     
	            	   String ProductName = resultSet.getString("ProductName");
	     
	            	   int ProductPrice = resultSet.getInt("ProductPrice");
	   
	            	   // Print and display productId,productName,ProductPrice
	  
	            	   System.out.println(ProductId + "       " + ProductName+ "     " + ProductPrice);
	   
	               }
	    
	        
	    }
   }

       
