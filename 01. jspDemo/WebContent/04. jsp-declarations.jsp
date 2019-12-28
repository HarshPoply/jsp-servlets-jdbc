<html>

<body>
<h2>JSP Declarations Example</h2>

<h3>Declare a method in JSP</h3>
<h3>Call the method is same JSP page</h3>

<%!
String makeItLower(String data) {
	return data.toLowerCase();
}
%>

<h4>Lower case of "Harsh Poplay" is:  <%= makeItLower("Harsh Poplay") %></h4>
</body>
</html>