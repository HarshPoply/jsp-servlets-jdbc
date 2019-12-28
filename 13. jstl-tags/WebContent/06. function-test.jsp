<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

<c:set var="data" value="HARSH POPLAY"/>
The length of the string <b>${data}</b>: ${fn:length(data)}
<br><br>
Lower case of string <b>${data}</b> is: ${fn:toLowerCase(data)}
<br><br>
Does the string <b>${data}</b> starts with <b>HAR</b>: ${fn:startsWith(data,"HAR")}
<br><br>
<b>Note: The result of function startsWith is always case sensitive.</b>
</body>
</html>