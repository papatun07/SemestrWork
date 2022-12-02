<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Util.Utils" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/_nav.jsp" />
<hr>
<t:mainLayout title="REVIEW">
<h2 class="text-center mb-5">Посты</h2>

<div style="display: flex; flex-direction: column; align-items: center">
    <c:forEach var="post" items="${posts}">
        <div class="card mb-5" style="width: 18rem;">
            <img src="http://localhost:8080/images/${post.getImgName()}" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${post.getTitle()}</h5>
                <a href="/posts/${post.getId()}" class="btn btn-primary">Читать</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</t:mainLayout>