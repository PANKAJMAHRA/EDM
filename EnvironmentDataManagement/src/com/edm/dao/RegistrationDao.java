package com.edm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.edm.model.RegistrationBean;
import com.edm.util.Dbutil;

public class RegistrationDao {
	private Connection connection;
	ResultSet rs;
	int counter;

	public RegistrationDao() {
		connection = Dbutil.getConnection();
	}

	public boolean newRegistration(RegistrationBean registrationbean) {
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into registration(first_name,last_name,email,password) values(?,?,?,?)");
			pstmt.setString(1, registrationbean.getFirstName());
			pstmt.setString(2, registrationbean.getLastName());
			pstmt.setString(3, registrationbean.getEmail());
			pstmt.setString(4, registrationbean.getPassword());
			int res = pstmt.executeUpdate();

			if (res > 0) {
				return true;
			} else {
				return false;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int checkUser(RegistrationBean registrationbean){
		try{
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT COUNT(*) from registration where email=? and password=?");
			pstmt.setString(1,registrationbean.getEmail());
			pstmt.setString(2, registrationbean.getPassword());
			ResultSet rs=pstmt.executeQuery();
			
			counter=0;
			while(rs.next()){
				counter=rs.getInt(1);
			}
			
			}catch(SQLException e){
			e.printStackTrace();
		}
		return counter;
	}
}
