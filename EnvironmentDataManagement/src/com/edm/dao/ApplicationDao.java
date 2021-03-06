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
			PreparedStatement preparedstatement = connection.prepareStatement(
					"insert into application(name,deployment_location,log_type,application_type_id) values (?,?,?,?)");
			// preparedstatement.setInt(1, applicationbean.getId());
			preparedstatement.setString(1, applicationbean.getName());
			preparedstatement.setString(2, applicationbean.getDeploymentLocation());
			preparedstatement.setString(3, applicationbean.getLogType());
			preparedstatement.setInt(4, applicationbean.getApplicationTypeId());
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

	public boolean updateApplication(ApplicationBean applicationbean) {
		try {
			System.out.println("syso");
			PreparedStatement preparedstatement = connection.prepareStatement(
					"update application set name=?,deployment_location=?,log_type=?,application_type_id=? where id=?");
			System.out.println("inside prepared statement");
			preparedstatement.setString(1, applicationbean.getName());
			preparedstatement.setString(2, applicationbean.getDeploymentLocation());
			preparedstatement.setString(3, applicationbean.getLogType());
			preparedstatement.setInt(4, applicationbean.getApplicationTypeId());
			preparedstatement.setInt(5, applicationbean.getId());
			int res = preparedstatement.executeUpdate();
			if (res > 0) {
				System.out.println("system updated");
				return true;
			}

			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteApplication(ApplicationBean applicationbean) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("delete from application where id=?");
			preparedstatement.setInt(1, applicationbean.getId());
			int res = preparedstatement.executeUpdate();
			if (res > 0) {
				System.out.println("deleted...");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	public List<ApplicationBean> getAllApplication() {
		List<ApplicationBean> application = new ArrayList<ApplicationBean>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from application");
			while (resultset.next()) {
				ApplicationBean applicationbean = new ApplicationBean();
				// ApplicationTypeBean applicationtypebean= new
				// ApplicationTypeBean();
				applicationbean.setId(resultset.getInt(1));
				applicationbean.setName(resultset.getString(2));
				applicationbean.setDeploymentLocation(resultset.getString(3));
				applicationbean.setLogType(resultset.getString(4));
				applicationbean.setApplicationTypeId(resultset.getInt(5));
				// applicationtypebean.setApplicationId(resultset.getInt(5));

				application.add(applicationbean);
				// application.add(applicationtypebean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return application;
	}

	public ApplicationBean getApplicationById(int id) {
		ApplicationBean applicationbean = null;

		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select * from application where id=?");
			preparedstatement.setInt(1, id);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				applicationbean = new ApplicationBean();

				applicationbean.setId(resultset.getInt(1));
				applicationbean.setName(resultset.getString(2));
				applicationbean.setDeploymentLocation(resultset.getString(3));
				applicationbean.setLogType(resultset.getString(4));
				applicationbean.setApplicationTypeId(resultset.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicationbean;

	}

}
