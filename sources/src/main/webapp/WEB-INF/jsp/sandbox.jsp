<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html><html>
<head>
    <title>DevInLove &middot; &iexcl;DangerZone!</title>
    <c:import url="includes/head.jsp" />
</head>
<body>
<c:import url="includes/header.jsp" />
<div class="container">
    <h1>&iexcl;this might void the warranty!</h1>
    <form method="post" class="form-horizontal" id="cyform">
        <legend>El Cypher 3xecut0r</legend>
        <div class="control-group">
            <label class="control-label" for="query">Cypher Query</label>
            <div class="controls">
                <textarea name="cypherQuery" class="span10" id="query" type="text"><c:out value="${query}" /></textarea>
            </div>
        </div>
        <input type="submit" class="btn" />
    </form>

    <div id="results" <c:if test="${isError == 'true'}">class="alert alert-error"</c:if>>
        <c:out value="${results}" />
    </div>
</div>
<c:import url="includes/footer.jsp" />
</body>
</html>