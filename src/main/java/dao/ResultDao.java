package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Result;

import util.DBConnection;

public class ResultDao {
		Connection con = DBConnection.getConnection();
	public boolean addResult(int rollNo, String subject, int marks){
		
		String query = "Insert Into result (roll_no, subject, marks) VALUES(?,?,?)";
		int rs;
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, rollNo);
			ps.setString(2, subject);
			ps.setInt(3, marks);
			rs = ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return rs==1;
		}
	
	
	public List<Result> getResultByRollNo(int rollNo) {
		
		String query = "SELECT roll_no, subject, marks FROM result WHERE roll_no =?";
		List<Result> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rollNo);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Result res = new Result();
				res.setRollno(rs.getInt(1));
				res.setSubject(rs.getString(2));
				res.setMarks(rs.getInt(3));
				list.add(res);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	 public boolean deleteMarks(int rollno, String sub) {
		String query = "delete from result where roll_no = ? AND subject = ?;";
		int rs =0 ;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rollno);
			ps.setString(2, sub);
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs == 1;
	 }
	 
}









