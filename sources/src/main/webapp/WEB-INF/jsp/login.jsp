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
    <form action="<c:url value="j_spring_security_check" />" method="POST" class="span6 offset3 form-horizontal">
        <legend>Lov'in</legend>
        <div class="control-group">
            <label class="control-label" for="username">Login</label>
            <div class="controls">
                <input type="text" id="username" name="j_username" placeholder="Login">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="password" name="j_password" placeholder="Password">
            </div>
        </div>
        <input type="submit" class="btn" value="Gogogo" />
    </form>
</div>
<c:import url="includes/footer.jsp" />
</body>
</html>
