<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/third/bootstrap.min.css" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
<script type="text/javascript" charset="utf-8"
        src="<c:url value="/resources/js/third/require-jquery.js" />"
        data-main="<c:url value="/resources/js/main.js" />"></script>
<script type="text/javascript">
    require.config({
        paths: {
            "css": "<c:url value="/resources/css" />"
        },
        map: {
            "*": {
                "text": "third/text"
            }
        },
        config: {
            autocomplete: {
                webappRoot: "<c:url value="/" />"
            }
        }
    });
</script>
