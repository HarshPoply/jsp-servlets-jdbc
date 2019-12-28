<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Home</title>
</head>
<body>



<h1>Welcome, <c:out value="${user.userName}"/>!</h1>
<p>You have successfully logged in, congratulations.<br>
Click <a href="LoginController?logout=true">here</a> to log back out.
</p>


</body>
</html>