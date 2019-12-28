<%@page import="java.net.URLEncoder"%>
<html>
<head>
<title>Cookies Personalize Response</title>
</head>
<%
	//read form data
	String favLang = request.getParameter("flang");

	//encode cookie data
	favLang = URLEncoder.encode(favLang,"UTF-8");
	
	//create the cookie
	Cookie theCookie = new Cookie("myApp.flang",favLang);
	
	//set lifespan of cookie (in seconds)
	theCookie.setMaxAge(365*24*60*60);     // for one year
	
	// send cookie to the browser
	response.addCookie(theCookie);
%>
<body>
Thanks we have set your favorite Programming Language to : <b>${param.flang}</b>
<br><br>
<a href="cookies-homepage.jsp">Return to the Home page.</a>
</body>
</html>