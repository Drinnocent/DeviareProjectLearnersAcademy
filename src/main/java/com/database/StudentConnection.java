package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.com.Student;

public class StudentConnection {

	public List<Student> getAllStudents() {
		Connection con = MyConnection.getConnection();
		String sql = "select * from schoolstudent";
		List<Student> students = new ArrayList<Student>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Student c = new Student();
				c.setIdstudent(rs.getString(1));
				c.setClassId(rs.getString(2));
				c.setFirstName(rs.getString(3));
				c.setLastName(rs.getString(4));
				c.setIdNumber(rs.getString(5));

				students.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;

	}
	public boolean insertStudent(Student student)
    {
        Connection con = MyConnection.getConnection();
        String sql = "insert into schoolstudent values(?,?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, student.getIdstudent());
            statement.setString(2, student.getClassId());
            statement.setString(3, student.getFirstName());
            statement.setString(4, student.getLastName());
            statement.setString(5, student.getIdNumber());
            statement.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        
    }

}
