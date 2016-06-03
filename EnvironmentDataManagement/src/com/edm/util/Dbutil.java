package com.edm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {

	public static Connection conn = null;

	public static Connection getConnection() {
		try {
			System.out.println("in database");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/environment_project", "root", "tiger");
			System.out.println("connection setup");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		return conn;
	}

}
