package com.edm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edm.model.ApplicationTypeBean;
import com.edm.util.Dbutil;

public class ApplicationTypeDao {
	private Connection connection;
	ResultSet rs;
	
	public ApplicationTypeDao() {
	connection=Dbutil.getConnection();
	}
	public boolean addApplicationType(ApplicationTypeBean applicationtypebean) {
		try {
			System.out.println("inside add applicationtype..");
			PreparedStatement preparedstatement = connection
					.prepareStatement("insert into application_type(application_type) values (?)");
			preparedstatement.setString(1, applicationtypebean.getApplicationType());
			//preparedstatement.setInt(2, applicationbean.getId());
			int res = preparedstatement.executeUpdate();
			if (res > 0) {
				System.out.println("data inserted sucessfully");
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<ApplicationTypeBean> getAllApplicationType(){
		List<ApplicationTypeBean> applicationtype= new ArrayList<ApplicationTypeBean>();
		try{
			Statement stmt= connection.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from application_type");
			while (rst.next()){
				ApplicationTypeBean applicationtypebean= new ApplicationTypeBean();
				applicationtypebean.setId(rst.getInt(1));
				applicationtypebean.setApplicationType(rst.getString(2));
				applicationtype.add(applicationtypebean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return applicationtype;
	}
}
