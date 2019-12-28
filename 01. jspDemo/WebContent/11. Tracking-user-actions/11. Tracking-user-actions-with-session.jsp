<%@ page import="java.util.*" %>
<html>

<body>

<!-- Step 1: Create HTML Form -->

<form action="11. Tracking-user-actions-with-session.jsp">

Add New Item: <input type="text" name="myItem">
<input type="submit" value="Submit">

</form>

<!-- Step 2: Add new item to "To-Do" List -->

<%
	// get the To Do items from the session
	List<String> items = (List<String>) session.getAttribute("myTodoList"); 


	// if the to do item does'nt exist, then create a new one
	if(items==null) {
		items = new ArrayList<String>();
		session.setAttribute("myTodoList",items);
	}
	
	
	// see if there is form data to add
	String theItem = request.getParameter("myItem");
	if(theItem!=null) {
		items.add(theItem);
	}
%>


<!-- Step 3: Display all "To-Do" items from session -->
<hr>
<b>To List Items: </b> <br>

<ol>
<%
	for(String temp: items) {
		out.println("<li>"+temp+"</li>");
	}
%>
</ol>

</body>

</html>