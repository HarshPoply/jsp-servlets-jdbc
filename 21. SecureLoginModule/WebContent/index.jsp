<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form id="loginForm" action="LoginController" method="POST">
		<h1>Login</h1>
		<input type="text" name="username" autocomplete="off" placeholder="Username" required/><br/>
		<input type="password" name="pass" autocomplete="off" placeholder="Password" required/><br/>
		<input type="submit" value="Login"/><br>
		${errorMessage}
	</form>

</body>
</html>