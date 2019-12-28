<html>
<body>
<%
String name = (String) session.getAttribute("sessname");
out.println("Hello User you have entered the name: "+"<b>"+name+"</b>");
%>
</body>
</html>