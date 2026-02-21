package dao;

import model.Student;
import util.DBConnection;
import java.sql.*;

public class StudentDao {
	public  Student validateStudent(int rollNo, String password) {
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
				ps.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean addStudent(Student student) {
		Connection con = DBConnection.getConnection();
		
		String query = "Insert Into student(roll_no, name, branch, semester, student_password) values(?,?,?,?,?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, student.getRollno());
			ps.setString(2, student.getName());
			ps.setString(3, student.getBranch());
			ps.setInt(4, student.getSemester());
			ps.setString(5, student.getPassword());
			
			if(ps.executeUpdate() == 1) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
