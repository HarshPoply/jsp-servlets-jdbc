<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="Login" method="POST">
		Enter Username: <input type="text" name="uname" placeholder="Username" required/><br>
		Enter Password: <input type="password" name="pass" placeholder="Password" required/><br>
		<input type="submit" name="login" value="Login"/>
	</form>
</body>
</html>