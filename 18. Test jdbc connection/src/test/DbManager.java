package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker","root","root123");
			return conn;	
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
