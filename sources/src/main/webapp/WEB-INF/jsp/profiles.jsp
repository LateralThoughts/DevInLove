<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html><html>
<head>
    <title>DevInLove &middot; stars &amp; scars</title>
    <c:import url="includes/head.jsp" />
</head>
<body>
	<c:import url="includes/header.jsp" />
	<div class="container">
		<c:choose>
			<c:when test="${empty profiles}">
				<h1>Nobody! <small><a href="<c:url value="/import" />">Import...</a></small></h1>
			</c:when>
			<c:otherwise>
			    <ul class="row profiles">
		           <c:forEach items="${profiles}" var="profile">
		             <li class="span3">
		             	<a href="<c:url value="/profile-${profile.id}" />">
		             		<img src="<c:url value="resources/images/default_avatar_large.png" />" alt="" />
		             	</a>
		             	<span class="profileOwner"><c:out value="${profile.firstName}" /> <c:out value="${profile.lastName}" /></span>
		             </li>
		           </c:forEach>
			    </ul>
		    </c:otherwise>
		</c:choose>
	</div>
	<c:import url="includes/footer.jsp" />
</body>
</html>
