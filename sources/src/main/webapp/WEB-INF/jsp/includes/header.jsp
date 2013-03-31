<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<ul class="nav">
				<li class="active">
                    <a href="<c:url value="/" />" class="brand">
                        <img alt="" src="<c:url value="/resources/images/logo.gif" />" id="logo"/>
                        DevIn<span class="love">Love</span>
                    </a>
                </li>
				<!--<li><a href="<c:url value="/login" />">Login</a></li>-->
                <li><a href="<c:url value="/profiles" />">People</a></li>
                <li><a href="<c:url value="/sandbox" />"><i class="icon-warning-sign icon-white"></i> Sandbox</a></li>
			</ul>
			<form class="navbar-search pull-left" method="get" action="<c:url value="/search" />">
				<input type="text" class="search-query" id="search" firstName="search" placeholder="Search...">
			</form>
		</div>
	</div>
</div>