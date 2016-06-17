package com.edm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edm.model.ApplicationBean;
import com.edm.model.ApplicationTypeBean;
import com.edm.model.CommonBean;
import com.edm.util.Dbutil;

public class CommonDao {
	private Connection connection;
	ResultSet rs;
	CommonBean commonbean = new CommonBean();

	public CommonDao() {
		Dbutil.getConnection();

	}

	public CommonBean viewAllData(int id) {
		ApplicationBean applicationbean = null;
		ApplicationTypeBean applicationtypebean = null;
		System.out.println("inside view all data");
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"select a.id,a.name,a.deployment_location,a.log_type,at.application_type from application a inner join application_type at on a.application_type_id=at.id where a.id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			String name = rs.getString("name");
			System.out.println("name=" + name);
			String dl = rs.getString("deployment_location");
			System.out.println("deployment location=" + dl);
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
