<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="test.DbManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		DbManager db = new DbManager();
		Connection conn = db.getConnection();
		Statement myStmt = null;
		ResultSet myRes = null;
		if (conn == null) {
			out.print("Not Connected!!");
		} else {
			out.println("Connected!!<br>");
			// Step 3: Create a SQL statement
			String sql = "SELECT * FROM student";
			myStmt = conn.createStatement();

			// Step 4: Execute SQL Query
			myRes = myStmt.executeQuery(sql);

			// Step 5: Process the ResultSet
			while (myRes.next()) {
				String email = myRes.getString("email");
				out.println(email+"<br>");
			}
		}
	%>
</body>
</html>