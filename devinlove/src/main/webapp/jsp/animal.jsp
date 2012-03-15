<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>DevInLove</title>
    <link rel="stylesheet" type="text/css" charset="utf-8" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" type="text/css" charset="utf-8" href="<c:url value="/resources/css/style.css" />"/>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <div class="row">
    <div class="span12">
        <img id="hearts" src="<c:url value="/resources/img/ncvg19qw.gif" />"/>
        <h1>DevInLove</h1>
        <h2>The best way to find your soulmate <strong>programatically</strong> !</h2>
    </div>
    <div class="span6">
    <h3>Nom : ${mascot.name}</h3>
    <
    </div>
    <div class="span6">No ? :'( ? <a href="<c:url value="/register.html" />">Register and join the fun !</a></div>
    </div>
    <div class="span3">
        With already so much mascots :
        <ul>
           <c:forEach items="${latestMascots}" var="mascot">
             <li><c:out value="${mascot.name}" /></li>
           </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>