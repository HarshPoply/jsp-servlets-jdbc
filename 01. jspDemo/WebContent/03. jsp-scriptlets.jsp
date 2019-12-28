<html>

<body>
<h3>JSP Scriptlets Example</h3>

<h4>Insert 1 to many lines of Java Code </h4>
<h4>To include content in the page use: out.println(...) </h4>


<h1> Hello World of Java </h1>

<%
for(int i=1;i<=5;i++) {
	out.println("<br>I love Java: "+i);
}
%>

<h1>Note: Use JSP Scriptlets as best practice.</h1>
</body>
</html>