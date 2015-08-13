<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Entries for ${user.displayName}</h1>

<div>
	<c:forEach items="${entries}" var="entry">
    	<div class="post-title">
    		<a href="/post/${entry.alias}">${entry.title}</a>
    	</div>
    	<div class="post-teaser">${entry.shortContent}</div>
	</c:forEach>	
</div>