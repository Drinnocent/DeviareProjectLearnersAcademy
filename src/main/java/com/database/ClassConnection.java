package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.com.GradeClass;

public class ClassConnection {

	public List<GradeClass> getAllClasses() {
		Connection con = MyConnection.getConnection();
		String sql = "select * from class";
		List<GradeClass> customers = new ArrayList<GradeClass>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				GradeClass c = new GradeClass();
				c.setClassId(rs.getString(1));
				c.setName(rs.getString(2));

				customers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;

	}
}
