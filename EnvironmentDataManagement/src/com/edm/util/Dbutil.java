package com.edm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {

	public static Connection conn = null;

	public static Connection getConnection() {
		try {
			System.out.println("in database");
			Class.forName("com.mysql.jdbc.driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "tiger");

		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		return conn;
	}

}
