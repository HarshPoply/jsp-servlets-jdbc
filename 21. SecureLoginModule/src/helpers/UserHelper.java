package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojos.User;

public class UserHelper {
	
	private PreparedStatement authenticateUserStatement;
	
	public UserHelper() {
		
		try {
			
			// Setup a connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/securelogin","root","root123");
			
			// SQL Query
			String sql = "select * from users where userName=? and passWord=?";
			
			// Create the PreparedStatement
			authenticateUserStatement = conn.prepareStatement(sql);
		}
		catch(Exception e) {
			System.out.println("Inside Constructor");
			System.out.println(e.getClass().getName()+": "+e.getMessage());
			System.out.println("Inside Constructor Last Line");
		}
	}
	
	public User authenticateUser(String username, String password) {
		User user = null;
		
		try {
			// Add parameters to the Prepared Statement
			authenticateUserStatement.setString(1,username);
			authenticateUserStatement.setString(2,password);
			
			ResultSet rs = authenticateUserStatement.executeQuery();
			
			// if we have returned a row, turn that row into a new user object
			if(rs.next()) {
				user = new User(rs.getInt("userId"),rs.getString("userName"),rs.getString("passWord"));
			}
		}
		catch(Exception e) {
			System.out.println("Inside authenticateUser");
			System.out.println(e.getClass().getName()+": "+e.getMessage());
			System.out.println("Inside authenticateUser last line");
		}
		return user;
	}
}
