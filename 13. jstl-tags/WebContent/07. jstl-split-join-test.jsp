<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Split Demo</h2>
<c:set var="data" value="India,Nepal,Pakistan,Bhutan,Bangladesh,China" />
<c:set var="countryArray" value="${fn:split(data,',')}" />

<c:forEach var="tempCountry" items="${countryArray}">
${tempCountry}<br>
</c:forEach>

<br><br><br>

<h2>Join Demo</h2>
<c:set var="joinCountry" value="${fn:join(countryArray,'+')}" />
${joinCountry}
</body>
</html>