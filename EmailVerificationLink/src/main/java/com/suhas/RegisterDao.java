package com.suhas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class RegisterDao {

	public String RegisterUser(LoginBean rb) throws SQLException {

		String firstName = rb.getFirstName();
		String lastName = rb.getLastName();
		String email = rb.getEmail();
		String phone = rb.getPhone();
		String gender = rb.getGender();
		String location = rb.getLocation();
		String dob = rb.getDob();
		String password = rb.getPassword();
		String myHash = rb.getMyHash();

		Connection conn = DbConnection.getConnection();
		try {

			String sqlQuery = "insert into user_details (First_Name,Last_Name,Email,Password,phone,gender,location,dob,Hash) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.setString(5, phone);
			pst.setString(6, gender);
			pst.setString(7, location);
			pst.setString(8, dob);
			pst.setString(9, myHash);

			int i = pst.executeUpdate();
			
			 if (i != 0) {
				System.out.println("Succesfully created new user.");
				System.out.println("Sending Mail... ");

				SendingEmail se = new SendingEmail(email, myHash);
				se.sendMail();

				return "Success";
			}

		} catch (NullPointerException e) {
			System.out.println("Error at RegisterDAO.java: " + e);
		}

		return "error";
	}

	public static boolean validate(String email, String password) {
          boolean status=false;
          try {
        	  Connection conn = DbConnection.getConnection();
        	  PreparedStatement ps=conn.prepareStatement(  
        			  "select * from user_details where email=? and password=?");  
        			  ps.setString(1,email);  
        			  ps.setString(2,password);  
        			        
        			  ResultSet rs=ps.executeQuery();  
        			  status=rs.next();  
        	  
        	  
        	  
        	  
          }
          catch(Exception e){System.out.println(e);}  
          return status;  
          }  
	}
