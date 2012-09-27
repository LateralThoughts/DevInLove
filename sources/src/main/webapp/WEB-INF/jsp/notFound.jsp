<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>DevInLove &middot; /dev/null</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<c:import url="includes/header.jsp" />
	<div class="container">
		<h1>Doh!
			<small>Dude, where is my page?</small>
		</h1>
		<c:import url="includes/doh.jsp" />
	</div>
</body>
</html>
