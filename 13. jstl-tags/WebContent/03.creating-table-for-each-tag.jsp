<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.jstltags.fun.Student,java.util.*"%>

<%
	//Let's create some sample data...normally provided by MVC
	List<Student> data = new ArrayList<>();

	data.add(new Student("Harsh", "Poplay", true));
	data.add(new Student("Hitika", "Taggar", false));
	data.add(new Student("Jasmine", "Kalsi", false));
	data.add(new Student("Rahul", "Parkash", true));

	pageContext.setAttribute("myStudent", data);
%>

<html>
<body>

	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gold Customer</th>
		</tr>
		<c:forEach var="tempStudent" items="${myStudent}">
			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>${tempStudent.goldCustomer}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>