<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html><html>
<head>
    <title>DevInLove &middot; Lov'In</title>
    <c:import url="includes/head.jsp" />
</head>
<body>
<c:import url="includes/header.jsp" />
<div class="container">
    <form action="<c:url value='/authenticate.html' />" method="post" class="span6 offset3 form-horizontal">
        <legend>Lov'in</legend>
        <div class="control-group">
            <label class="control-label" for="inputEmail">Email</label>
            <div class="controls">
                <input type="text" id="inputEmail" placeholder="Email">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputPassword">Password</label>
            <div class="controls">
                <input type="password" id="inputPassword" placeholder="Password">
            </div>
        </div>
        <input type="submit" class="btn" value="Gogogo" />
    </form>
</div>
<c:import url="includes/footer.jsp" />
</body>
</html>
