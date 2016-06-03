package com.edm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		try {
			System.out.println("in database");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("in ");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/environment_project", "root", "tiger");
			System.out.println("connecteddd");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from server");
			if (rs.next()) {
				System.out.println("has record>>>");
			} else {
				System.out.println("no reord>>>>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
