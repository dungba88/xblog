<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<c:forEach items="${plugins}" var="plugin">
		<div style="margin: 0 50px 10px 0">
			${plugin.id}
		</div>
	</c:forEach>
</div>