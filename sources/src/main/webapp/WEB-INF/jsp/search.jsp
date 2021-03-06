<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html><html>
<head>
    <title>DevInLove &middot; Love is almost there :(</title>
    <style>
		#first { padding-bottom:20px;}
		#last { padding-top:30px}
	</style>
</head>
<body>
	<c:import url="includes/header.jsp" />
	<div class="container">
        <div class="hero-unit">
		    <h2>Well, almost there. With more time, we could have shown:</h2>
		    <ul class="tagline" style="list-style-type:none; text-align:left; margin-top:15px;">
		    	<li>
<pre id="first"><code>
START d=node(1), e=node(2)
MATCH p = shortestPath( d-[*..15]->e )
RETURN p</code></pre>
				</li>
				<li>
				<pre id="last"><code>Iterable&lt;Person&gt; teamMembers = personRepository.findWithinDistance("personLayer", 16,56,70);
				</code></pre>
				</li>
		    </ul>
	    </div>
	</div>
	<c:import url="includes/footer.jsp" />
</body>
</html>
