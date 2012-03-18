<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>DevInLove &middot; mvn pet:love</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<c:import url="/jsp/header.jsp" />
	<div class="container">
	    <div class="row">
		    <div class="span3">
	        So many mascots!
	        <ul>
	           <c:forEach items="${latestMascots}" var="mascot">
	             <li><c:out value="${mascot.name}" /></li>
	           </c:forEach>
	        </ul>
        </div>
    </div>
	<c:import url="/jsp/footer.jsp" />
</div>
</body>
</html>