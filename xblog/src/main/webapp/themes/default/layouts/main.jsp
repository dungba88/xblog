<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title>Helloworld!</title>
	</head>
	<body>
		<div>
			<tiles:insertAttribute name="header" />
		</div>
		<div>
			<tiles:insertAttribute name="content" />
		</div>
		<div>
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>