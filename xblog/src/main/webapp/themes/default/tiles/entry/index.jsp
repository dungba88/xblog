<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>${entry.title}</h1>

<h3>Posted by ${entry.userDisplayName} at ${entry.createdTime}</h3>

<div>
	${entry.content}
</div>