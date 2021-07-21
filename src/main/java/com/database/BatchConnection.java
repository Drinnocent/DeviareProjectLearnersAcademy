package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.com.Batch;
import school.com.ClassCourse;

public class BatchConnection {
	public boolean assignTeacher(Batch batch) {
		ClassCourseConnection cla = new ClassCourseConnection();
		List<ClassCourse> classsubj = cla.getAllClassSubj();
		//List<Batch> list=getBatch();		
		boolean check=false;
		System.out.println("im in here");
		for (int i = 0; i < classsubj.size(); i++) {
			if (classsubj.get(i).getClassId().equalsIgnoreCase(batch.getClassId()) && classsubj.get(i).getIdsubject().equalsIgnoreCase(batch.getIdsubject())) {
				check=true;
				break;
			}
		}
		if(check==true) 
		{
			Connection con = MyConnection.getConnection();
			String sql = "insert into batch values(?,?,?,?)";
			try {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, batch.getIdbatch());
				statement.setString(2, batch.getClassId());
				statement.setString(3, batch.getIdsubject());
				statement.setString(4, batch.getIdteacher());
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

	public List<Batch> getBatch() {
		Connection con = MyConnection.getConnection();
		String sql = "select * from batch";
		List<Batch> batches = new ArrayList<Batch>();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Batch c = new Batch();
				c.setIdbatch(rs.getInt(1));
				c.setClassId(rs.getString(2));
				c.setIdsubject(rs.getString(3));
				c.setIdteacher(rs.getString(4));

				batches.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return batches;
	}

}
