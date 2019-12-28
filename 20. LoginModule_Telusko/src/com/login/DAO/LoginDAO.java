package com.login.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	public boolean check(String uname, String pass) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker","root","root123");
			
			String sql = "select * from student where first_name=? and last_name=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
