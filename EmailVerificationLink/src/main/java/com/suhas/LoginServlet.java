package com.suhas;

import java.io.IOException;
import com.suhas.LoginBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suhas.RegisterUser;
import com.suhas.RegisterDao;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
				if(RegisterDao.validate(email, password)){
					response.sendRedirect("Welcome.jsp");
				}
				else {
					response.sendRedirect("Fail.jsp");
				}
			}
			 catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
	
	}

}
