package com.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminConnection {

	public boolean validate(String email, String password) 
	{
	     Connection con = MyConnection.getConnection();
	        String sql = "select email,password from schooladmin where email=?";
	        try {
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, email);
	            ResultSet rs = statement.executeQuery();
	            if(rs.next())
	            {
	            	if(rs.getString(1).equals(email) &&rs.getString(2).equals(password)) 
	            	{
	            		return true;
	            	}
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return false;
	        }
			finally 
			{
				MyConnection.closeConnection();
			}
	        return false;
	        
	}
	
}
