<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>DevInLove &middot; Tékitoi?</title>
    <c:import url="includes/head.jsp" />
</head>
<body>
	<c:import url="includes/header.jsp" />
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
			<h3>My Tools</h3>
			<c:choose>
				<c:when test="${empty guy.tools}">
					<p>No tools. I code with my feet anyway.</p>
				</c:when>
				<c:otherwise>
					<dl class="dl-horizontal">
					<c:forEach items="${tools}" var="tool">
							<dt><c:out value="${tool.tool.name}" /> (v<c:out value="${tool.tool.version}" />)</dt>
							<dd>
								<small>
									and I <c:out value="${tool.affinity}" /> it!
								</small>
							</dd>
					</c:forEach>
					</dl>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="misc-block" class="pull-right">
		
			<form:form modelAttribute="statusCommand" cssClass="well">
				<form:input path="message" cssClass="span7" placeholder="Say something interesting... for a change." />
				<input type="submit" class="btn btn-primary btn-danger" value="1,2,3... SHOUT!" />
			</form:form>
		
			<div class="span9">
				<h3>That's what YOU said!</h3>
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
				    <div class="pagination pagination-centered">
					    <ul>
					    	<c:if test="${hasPreviousPage}">
						    	<li><a href="?p=<c:out value="${statusCurrentPage-1}" />">Prev</a></li>
					    	</c:if>
						    <li class="active">
						    	<a href="?p=<c:out value="${statusCurrentPage}" />"><c:out value="${statusCurrentPage}" /></a>
						    </li>
					    	<c:if test="${hasNextPage}">
						    	<li><a href="?p=<c:out value="${statusCurrentPage+1}" />">Next</a></li>
					    	</c:if>
					    </ul>
				    </div>
			</div>
			
		</div>
	</div>
	<c:import url="includes/footer.jsp" />
</body>
</html>