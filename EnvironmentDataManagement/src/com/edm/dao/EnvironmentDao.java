package com.edm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edm.model.EnvironmentBean;
import com.edm.util.Dbutil;

public class EnvironmentDao {
private Connection connection;
ResultSet rs;

public EnvironmentDao(){
	Dbutil.getConnection();
}

public boolean addEnvironment(EnvironmentBean environmentbean){
	try{
	PreparedStatement pstmt=connection.prepareStatement("insert into application(name,location) values (?,?)");
	pstmt.setString(1,environmentbean.getName());
	pstmt.setString(2,environmentbean.getLocation());
	int res=pstmt.executeUpdate();
	if(res>0){
		System.out.println("data sucessfully inserted in environment table");
		return true;
	}else {
		return false;
	}
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
}

public boolean updateEnvironment(EnvironmentBean environmentbean){
	try{
		PreparedStatement pstmt=connection.prepareStatement("update environment set name=?,location=? where id=?");
		pstmt.setString(1, environmentbean.getName());
		pstmt.setString(2, environmentbean.getLocation());
		pstmt.setInt(3, environmentbean.getId());
		int res= pstmt.executeUpdate();
		if(res>0){
			System.out.println("environment updated sucessfully");
			return true;
			
		}else{
			return false;
		}
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
}

public boolean deleteEnvironment(EnvironmentBean environmentbean){
	try{
		PreparedStatement pstmt=connection.prepareStatement("delete * from environment where id=?");
		pstmt.setInt(1,environmentbean.getId());
		int res= pstmt.executeUpdate();
		if(res>0){
			System.out.println("Environment data deleted sucessfully");
			return true;
		}else
		{
			return false;
		}
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
}


}
