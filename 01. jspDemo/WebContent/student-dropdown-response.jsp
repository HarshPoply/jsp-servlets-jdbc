<html>
<head>
<title>Student Confirmation</title>
</head>
<body>
The student is confirmed: <b> ${param.firstName.toUpperCase()} ${param.lastName.toUpperCase()} </b>
<br><br>
Gender: <b> ${param.gender}</b>
<br><br>
The student's Country: <b> ${param.country.toLowerCase()}</b>
<br><br>
Student's Favorite Language:
<br>

<!--  Display list of favorite programming languuages -->
<ul>
	<%
		String langs[] = request.getParameterValues("flang");
		
		if(langs!=null) {
			for(String temp: langs) {
				out.println("<li>"+temp+"</li>");
			}
		}
		
	%>
</ul>
</body>
</html>