package com.suhas;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection conn;

	public static Connection getConnection() {

		try {

			System.out.println("Connecting... ");

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "admin");

			return conn;

		} catch (Exception e) {
			System.out.println(" Error at SqlConnection.java: " + e);
		}

		return conn;
	}

}