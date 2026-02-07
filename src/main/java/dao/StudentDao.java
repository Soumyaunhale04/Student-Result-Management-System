package dao;

import model.Student;
import util.DBConnection;
import java.sql.*;

public class StudentDao {
	public Student validateStudent(int rollNo, String password) {
		Student s = null;
		Connection con = DBConnection.getConnection();
		
		String query = "SELECT * FROM student WHERE roll_no=? AND student_password =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rollNo);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				s = new Student();
				s.setRollno(rs.getInt("roll_no"));
				s.setName(rs.getString("name"));
				s.setBranch(rs.getString("branch"));
				s.setSemester(rs.getInt("semester"));
				s.setPassword(rs.getString("student_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
