<html>
<head>
<title>Training Portal</title>
</head>
<!--  read the favourite programming language cookie -->
<%
	//the default..... if there are no cookies
	String favlang = "Java";

	// get cookies from the browser request
	Cookie[] theCookies = request.getCookies();
	
	//find out our favourite language cookie
	if(theCookies != null) {
		
		for(Cookie tempCookie: theCookies) {
			if("myApp.flang".equals(tempCookie.getName())) {
				favlang = tempCookie.getValue();
				break;
			}
		}
	}
%>
<body>
<h3><u>Training Portal</u></h3>

<!-- Show new books for fav lang -->
<h4>New books for <%= favlang %></h4>
<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>
<br><br>
<h4>Latest News Reports for <%= favlang %></h4>
<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>
<br><br>
<h4>Hot Jobs for <%= favlang %></h4>
<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>
</body>
</html>