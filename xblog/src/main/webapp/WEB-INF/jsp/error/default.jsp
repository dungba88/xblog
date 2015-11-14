<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Xblog Internal Error</h2>

<h3>${exception}</h3>

<div>
	<c:forEach var="trace" items="${exception.stackTrace}">
		<div style="margin-left: 50px; margin-bottom: 5px">at <a href="">${trace}</a></div>
	</c:forEach>
</div>