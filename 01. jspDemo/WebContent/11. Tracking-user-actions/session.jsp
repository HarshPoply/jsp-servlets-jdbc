<html>
<body>
<%
String uname= request.getParameter("iname");
out.println("Welcome "+ uname);
session.setAttribute("sessname", uname);
%>
<br>
<a href="output.jsp">Check Output Page Here!!!</a>
</body>
</html>