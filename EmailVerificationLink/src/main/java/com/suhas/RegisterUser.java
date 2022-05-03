package com.suhas;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
		
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			String location = request.getParameter("location");
			String dob = request.getParameter("dob");
			

			Random theRandom = new Random();
			theRandom.nextInt(999999);
			String myHash = DigestUtils.md5Hex("" + theRandom);

			LoginBean rb = new LoginBean();
			rb.setFirstName(firstName);
			rb.setLastName(lastName);
			rb.setEmail(email);
			rb.setPassword(password);
			rb.setPhone(phone);
			rb.setGender(gender);
			rb.setLocation(location);
			rb.setDob(dob);
			rb.setMyHash(myHash);
			
			   LocalDate Dob;      
	           Dob = LocalDate.parse(dob);
		       LocalDate currentDate = LocalDate.now();
	     	   int age = Period.between(Dob,currentDate).getYears();
	     	   
	     	if(age<18)   {
	     		response.sendRedirect("Age.jsp");
	     	}
	     	else {

			RegisterDao regDAO = new RegisterDao();
			String s1 = regDAO.RegisterUser(rb);   
			if (s1.equals("Success") ) {
				response.sendRedirect("verify.jsp");
			} 
			 else {
				response.sendRedirect("index.jsp");
			}
	     	
	     	}
	     	}
		catch (Exception e) {
			System.out.println("Error at RegisterUser.java: " + e);
		}
	
}
}