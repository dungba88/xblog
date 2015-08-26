<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<c:forEach items="${entries}" var="entry">
		<article class="post">
			<header class="post-header">
				<h2 class="post-title">
					<a href="/post/${entry.alias}">${entry.title}</a>
				</h2>
			</header>
			<section class="markdown">
				${entry.shortContent}
			</section>
			<footer class="post-meta">
				<p>
					<a href="/author/${entry.userAlias}">${entry.userDisplayName}</a>
					on
					<a href="/category/${entry.categoryAlias}">${entry.categoryName}</a>
					
					<time class="post-date">
						<fmt:formatDate value="${entry.createdTime}" pattern="MMMM dd, y"/>
					</time>
				</p>
			</footer>
		</article>
	</c:forEach>
</div>