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
		<tiles:insertAttribute name="header" />
	</header>
	<main id="content" role="content">
		<tiles:insertAttribute name="content" />
	</main>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>