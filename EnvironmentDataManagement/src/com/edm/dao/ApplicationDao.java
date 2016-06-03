package com.edm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edm.model.ApplicationBean;
import com.edm.util.Dbutil;

public class ApplicationDao {
	private Connection connection;
	ResultSet rs;

	public ApplicationDao() {
		connection = Dbutil.getConnection();
	}

	public boolean addApplication(ApplicationBean applicationbean) {
		try {
			System.out.println("inside add application ");
			PreparedStatement preparedstatement = connection
					.prepareStatement("insert into application(id,name,deployment_location,log_type) values (?,?,?,?)");
			preparedstatement.setInt(1, applicationbean.getId());
			preparedstatement.setString(2, applicationbean.getName());
			preparedstatement.setString(3, applicationbean.getDeploymentLocation());
			preparedstatement.setString(4, applicationbean.getLogType());
			int res = preparedstatement.executeUpdate();

			if (res > 0) {
				System.out.println("student data inserted");
				return true;
			} else {
				return false;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	public List<ApplicationBean> getAllApplication() {
		List<ApplicationBean> application = new ArrayList<ApplicationBean>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from application");
			while (resultset.next()) {
				ApplicationBean applicationbean = new ApplicationBean();
				applicationbean.setId(resultset.getInt(1));
				applicationbean.setName(resultset.getString(2));
				applicationbean.setDeploymentLocation(resultset.getString(3));
				applicationbean.setLogType(resultset.getString(4));

				application.add(applicationbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return application;
	}
}
