 package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.com.ClassCourse;
import school.com.Subject;

public class ClassCourseConnection {
	public boolean assignSubjectToGrade(ClassCourse classcourse) {
		Boolean check = false;
		List<ClassCourse> classsubj = getAllClassSubj();
		for (int i = 0; i < classsubj.size(); i++) {
			if (classsubj.get(i).getClassId() == classcourse.getClassId()
					&& classsubj.get(i).equals(classcourse.getIdsubject())) {
				check = true;
				break;

			}
		}
		if (check == false) {
			Connection con = MyConnection.getConnection();
			String sql = "insert into classsubject values(?,?,?)";
			try {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, classsubj.size()+1);
				statement.setString(2, classcourse.getClassId());
				statement.setString(3, classcourse.getIdsubject());
				statement.execute();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;

	}

	public List<ClassCourse> getAllClassSubj() {
		Connection con = MyConnection.getConnection();
		String sql = "select * from classsubject";
		List<ClassCourse> classcourse = new ArrayList<ClassCourse>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ClassCourse c = new ClassCourse();
				c.setIdclasssubject(rs.getInt(1));
				c.setClassId(rs.getString(2));
				c.setIdsubject(rs.getString(3));

				classcourse.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classcourse;
	}

}
