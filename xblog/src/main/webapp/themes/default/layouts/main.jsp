<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title>Helloworld!</title>
<link type="text/css" rel="stylesheet"
	href="/themes/default/css/main.css" />
</head>
<link type="text/css" rel="stylesheet"
	href="/themes/default/css/fonts.css" />
</head>
<body>
	<header class="main-header">
		${hooks.beforeHeader}
		<tiles:insertAttribute name="header" />
		${hooks.afterHeader}
	</header>
	<main id="content" role="content">
		${hooks.beforeContent}
		<tiles:insertAttribute name="content" />
		${hooks.afterContent}
	</main>
	<footer>
		${hooks.beforeFooter}
		<tiles:insertAttribute name="footer" />
		${hooks.afterFooter}
	</footer>
</body>
</html>