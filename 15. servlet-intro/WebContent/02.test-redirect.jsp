<html>
<body>
<h1>Hello Engineer's</h1>
<form>
<input type="text" name="val">
<br>
<input type="submit" value="Submit">
</form>
<%
	int s = 1;
	if(s==1)
		response.sendRedirect(request.getContextPath()+"/HelloWorldServlet");
%>
</body>
</html>
