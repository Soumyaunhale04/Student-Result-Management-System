package util;

import java.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_result",
					"root", "Soumya02#");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
