package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import util.DBConnection;

public class AdminDao {
	public Admin validateAdmin(int admin_id, String password) {
		Admin ad = null;
		
		Connection con = DBConnection.getConnection();
		String query = "SELECT * FROM admin WHERE admin_id=? AND admin_password =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, admin_id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ad = new Admin();
				ad.setAdmin_id(rs.getInt("admin_id"));
				ad.setAdmin_name(rs.getString("admin_name"));
				ad.setPassword(rs.getString("admin_password"));
				ps.close();
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ad;
	}
}
