<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<ul class="nav">
				<li class="active">
                    <a href="<c:url value="/index.html" />" class="brand">
                        <img alt="" src="<c:url value="/resources/img/logo.gif" />" id="logo"/>
                        DevIn<span class="love">Love</span>
                    </a>
                </li>
				<!--<li><a href="<c:url value="/login.html" />">Login</a></li>-->
                <li><a href="<c:url value="/profiles.html" />">People</a></li>
			</ul>
			<form class="navbar-search pull-left" method="get" action="<c:url value="/search.html" />">
				<input type="text" class="search-query" name="search" placeholder="Search...">
			</form>
		</div>
	</div>
</div>