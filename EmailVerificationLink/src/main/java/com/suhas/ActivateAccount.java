package com.suhas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.suhas.DbConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

@WebServlet("/ActivateAccount")
public class ActivateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActivateAccount() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("key1");
		String hash = request.getParameter("key2");

		Connection conn = DbConnection.getConnection();

		try {

			PreparedStatement pst = conn.prepareStatement(
					"select Email, Hash, Active from user_details where Email=? and Hash=? and Active='0'");
			pst.setString(1, email);
			pst.setString(2, hash);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				PreparedStatement pst1 = conn
						.prepareStatement("update user_details set Active='1' where Email=? and Hash=?");
				pst1.setString(1, email);
				pst1.setString(2, hash);

				int i = pst1.executeUpdate();

				if (i == 1) {
					response.sendRedirect("Login.jsp");
					System.out.println("Account Successfully Verified.");
				} else {
					response.sendRedirect("index.jsp");
				}
			}

		} catch (Exception e) {
			System.out.println("Error at ActivateAccount.java: " + e);
		}
	}
}