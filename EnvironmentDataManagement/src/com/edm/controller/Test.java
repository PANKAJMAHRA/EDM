package com.edm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	public static void main(String[] args) {
		try {
			System.out.println("in database");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("in ");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/environment_project", "root", "tiger");
			System.out.println("connecteddd");
			
			PreparedStatement pstmt = conn.prepareStatement(
					"select a.id,a.name,a.deployment_location,a.log_type,at.application_type from application a inner join application_type at on a.application_type_id=at.id where a.id=?");
			pstmt.setInt(1, 2);
			ResultSet rs = pstmt.executeQuery();
			String name = rs.getString("name");
			System.out.println("name=" + name);
			String dl = rs.getString("deployment_location");
			System.out.println("deployment location=" + dl);
			
			
			//Statement stat = conn.createStatement();
			/*ResultSet rs = stat.executeQuery("select * from application");
			if (rs.next()) {
				System.out.println("has record>>>");
			} else {
				System.out.println("no reord>>>>");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
