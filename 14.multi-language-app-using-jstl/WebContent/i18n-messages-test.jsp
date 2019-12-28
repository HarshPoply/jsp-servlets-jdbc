<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="theLocale" value="${not empty param.theLocale? param.theLocale : pageContext.request.locale }" scope="session"/>

<fmt:setLocale value="${theLocale}"/>

<fmt:setBundle basename="com.test.jsp.tagdemo.i18n.resources.mylabels" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I18N Messages Testing</title>
</head>
<body>

<a href="i18n-messages-test.jsp?theLocale=en_GB">English (GB)</a>
|
<a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a>
|
<a href="i18n-messages-test.jsp?theLocale=de_DE">German (DE)</a>

<hr>

<fmt:message key="label.greeting"/>	<br><br>
<fmt:message key="label.firstname"/> <i>HARSH</i>	<br>
<fmt:message key="label.lastname"/>	 <i>POPLAY</i>	<br><br>
<fmt:message key="label.welcome"/> <br>

<hr>
Selected Locale: <b>${theLocale}</b>
</body>
</html>