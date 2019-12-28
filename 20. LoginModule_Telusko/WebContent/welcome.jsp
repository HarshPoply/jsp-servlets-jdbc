<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	// To prevent back page after logout
	// the below method supports HTTP 1.1
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	// For HTTP 1.0
	response.setHeader("Pragma", "no-cache");
	
	// For Proxy Servers
	response.setHeader("Expires", "0");

	if(session.getAttribute("username")==null) {
		
		response.sendRedirect("login.jsp");
	}
%>

WELCOME ${username}

<a href="videos.jsp">Videos here</a>

<form action="Logout" method="POST">
	<input type="submit" value="Logout"/>
</form>
</body>
</html>