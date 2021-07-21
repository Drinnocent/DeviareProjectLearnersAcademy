package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.com.Student;
import school.com.Subject;

public class SubjectConnection {
	public List<Subject> getAllSubjects() {
		Connection con = MyConnection.getConnection();
		String sql = "select * from subject";
		List<Subject> subjects = new ArrayList<Subject>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Subject c = new Subject();
				c.setIdsubject(rs.getString(1));
				c.setName(rs.getString(2));
				subjects.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjects;

	}
	public boolean insertSubject(Subject subject)
    {
        Connection con = MyConnection.getConnection();
        String sql = "insert into subject values(?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, subject.getIdsubject());
            statement.setString(2, subject.getName());
            statement.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        
    }
}
