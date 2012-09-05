<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>DevInLove</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp" />
	<div class="container">
        <div class="hero-unit">
		    <h1>Dev... In &hearts;!</h1>
		    <p class="tagline">Find your soulmate programatically. Now.</p>
		    <p>
	    </div>
        <div class="alert alert-info">
        	<a class="close" data-dismiss="alert">&times;</a>
        	Well. Actually. This is just a demo about SpringData/Neo4J. Really.
	    </div>
	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>
