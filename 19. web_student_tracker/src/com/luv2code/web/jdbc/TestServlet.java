package com.luv2code.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DbManager;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Step 1: Setup PrintWriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		// Step 2: Get a connection to the database
		DbManager db = new DbManager();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = db.getConnection();

			// Step 3: Create SQL Statements
			String sql = "select * from student";
			myStmt = myConn.createStatement();

			// Step 4: Execute SQL Query
			myRs = myStmt.executeQuery(sql);

			// Step 5: Process the ResultSet
			while (myRs.next()) {
				String email = myRs.getString("email");
				out.println(email);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			try {
				if(myRs!=null) {
					myRs.close();
				}
				if(myStmt!=null) {
					myStmt.close();
				}
				if(myConn!=null) {
					myConn.close();
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

}
