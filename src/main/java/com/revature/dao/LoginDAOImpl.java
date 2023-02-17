package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.model.Login;
import com.revature.util.DataBaseConnection;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public String loginCheck(Login login) {
		String query="select * from admin where user_id=? and password=?";
		
		try{
			Connection con=DataBaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,login.getEmail());
			ps.setString(2,login.getPassword());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				return "true";
			}
			else{
				return "false";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "error";
	}

}
