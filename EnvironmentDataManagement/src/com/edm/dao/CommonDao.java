package com.edm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edm.model.ApplicationBean;
import com.edm.model.ApplicationTypeBean;
import com.edm.model.CommonBean;
import com.edm.util.Dbutil;

public class CommonDao {
	Connection connection;
	ResultSet rs;
	CommonBean commonbean = new CommonBean();

	public CommonDao() {
		connection = Dbutil.getConnection();

	}

	public CommonBean viewAllData(int id) {
		System.out.println(id);
		ApplicationBean applicationbean;
		ApplicationTypeBean applicationtypebean;
		String query = "select a.id,a.name,a.deployment_location,a.log_type,at.application_type from application a INNER join application_type at on a.application_type_id=at.id and a.id=3";
		// String query="select * from application where id=?";
		System.out.println("inside view all data");
		try {
			if (connection == null) {
				System.out.println("null");

			} else {
				System.out.println("else condition");
			}
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			// stmt.setInt(1, id);

			System.out.println("hello");
			// ResultSet rs = pstmt.executeQuery();
			// String name = rs.getString("name");
			// System.out.println("name=" + name);
			// String dl = rs.getString("deployment_location");
			// System.out.println("deployment location=" + dl);
			while (rs.next()) {
				applicationbean = new ApplicationBean();
				applicationtypebean = new ApplicationTypeBean();

				applicationbean.setId(rs.getInt(1));
				applicationbean.setName(rs.getString(2));
				applicationbean.setDeploymentLocation(rs.getString(3));
				applicationbean.setLogType(rs.getString(4));
				applicationtypebean.setApplicationType(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commonbean;
	}
}
