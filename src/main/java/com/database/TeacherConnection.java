package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.com.Student;
import school.com.Teacher;

public class TeacherConnection {

	public List<Teacher> getAllTeachers() {
		Connection con = MyConnection.getConnection();
		String sql = "select * from teacher";
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Teacher c = new Teacher();
				c.setIdteacher(rs.getString(1));
				c.setFirstname(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setIdNumber(rs.getString(4));

				teachers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}
	public boolean insertTeacher(Teacher teacher)
    {
        Connection con = MyConnection.getConnection();
        String sql = "insert into schoolstudent values(?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, teacher.getIdteacher());
            statement.setString(2, teacher.getFirstname());
            statement.setString(3, teacher.getLastName());
            statement.setString(4, teacher.getIdNumber());
            statement.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        
    }

}
