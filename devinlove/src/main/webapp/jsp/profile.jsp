<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>DevInLove &middot; Tékitoi?</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<c:import url="/jsp/header.jsp" />
	<div class="container">
		<div class="page-heading well" id="profile-heading">
			<div class="span2"><img class="pull-left" src="<c:url value="/resources/img/default_avatar.jpg" />" alt=""/></div>
			<div id="profile-headings" class="pull-right span9">
				<h1><c:out value="${guy.firstName}" /> <c:out value="${guy.lastName}" />!</h1>
				<h2><small><c:out value="${guy.profoundIdentity}" /></small></h2>
			</div>
		</div>
		<div id="personal-info-block" class="pull-left span2">
			<h3>Highly boring facts</h3>
			<dl class="dl-horizontal">
				<dt>Shoe size</dt>
				<dd><c:out value="${guy.shoeSize}" /></dd>
				<dt>Favorite color</dt>
				<dd><c:out value="${guy.favoriteColor}" /></dd>
				<dt>Cannot live without</dt>
				<dd><c:out value="${guy.mascot.name}" /></dd>
			</dl>
		</div>
		
		<div id="misc-block" class="pull-right">
		
			<form:form modelAttribute="statusCommand" cssClass="well">
				<form:input path="message" cssClass="span7" placeholder="Say something interesting... for a change." />
				<input type="submit" class="btn btn-primary" value="1,2,3... SHOUT!" />
			</form:form>
		
			<div class="span9">
				<h3>Previously stated</h3>
				<c:choose>
					<c:when test="${empty guy.statuses}">
						<p>Well, well, well... nothing.</p>
					</c:when>
					<c:otherwise>
						<c:forEach items="${statuses}" var="status">
							<blockquote>
								<p>&ldquo;<c:out value="${status.statusMessage}" />&rdquo;</p>
								<small><c:out value="${status.formattedDate}" /></small>
							</blockquote>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			
		</div>
	</div>
	<c:import url="/jsp/footer.jsp" />
</body>
</html>