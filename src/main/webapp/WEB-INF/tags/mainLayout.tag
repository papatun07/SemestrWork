<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" %>
<%@attribute name="jsGroup" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="<c:url value="/style/index.html"/>">
    <link rel="stylesheet" href="<c:url value="/style/_style.css"/>">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;500&display=swap" rel="stylesheet">
<%--    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" type="text/css" rel="stylesheet">--%>
    <%@include file="/WEB-INF/_nav.jsp"%>
</head>
<body>
    <jsp:doBody/>
</body>
</html>