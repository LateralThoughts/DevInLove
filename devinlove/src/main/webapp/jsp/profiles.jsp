<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>DevInLove &middot; stars &amp; scars</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<c:import url="/jsp/header.jsp" />
	<div class="container">
	    <div class="row">
           <c:forEach items="${profiles}" var="profile">
             <li>
             	<c:out value="${profile.firstName}" /> [<c:out value="${profile.id}" />]
             </li>
           </c:forEach>
	    </div>
	</div>
	<c:import url="/jsp/footer.jsp" />
</body>
</html>
