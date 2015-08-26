<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<article class="post content">
	<header class="post-header">
		<h1 class="post-title">${entry.title}</h1>
		<section class="post-meta">
			<time class="post-date">
				<fmt:formatDate value="${entry.createdTime}" pattern="MMMM dd, y"/>
			</time>
			on
			<a href="/category/${entry.categoryAlias}">${entry.categoryName}</a>
		</section>
	</header>
	<section class="markdown">
		<p></p>
		${entry.content}
	</section>
</article>