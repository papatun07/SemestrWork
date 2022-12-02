<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Util.Utils" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<head>
    <title>Title</title>
</head>

<jsp:include page="/WEB-INF/_nav.jsp" />
<hr>
<t:mainLayout title="REVIEW">
<div class="w-50 mx-auto">
    <h2 class="mb-5">${post.getTitle()}</h2>
    <div class="mb-5">
        <img style="width: 75%; border-radius: 5%" src="http://localhost:8080/images/${post.getImgName()}" alt="img">
    </div>
    <p class="mb-5">${post.getText()}</p>

    <c:if test="${Utils.isPostBelongолдтьsToUser(post.getUserID()) || UserService.isAdmin()}">
        <form action="<c:url value="/posts/update"/>" method="get" class="d-inline-block mb-5">
            <button name="postID" value="${post.getId()}" class="btn btn-outline-info">Редактировать</button>
        </form>
        <form action="<c:url value="/posts/delete"/>" method="post" class="d-inline-block">
            <button name="postID" value="${post.getId()}" class="btn btn-outline-danger">Удалить</button>
        </form>
    </c:if>

    <h3 class="text-center">Комментарии</h3>
    <hr>

    <ul class="list-group mb-5">
        <c:forEach var="comment" items="${comments}">
            <li class="list-group-item list-group-item-secondary mb-3">
                <b>${Utils.getUsername(comment.getUserID())}</b>: ${comment.getText()}
            </li>
        </c:forEach>
    </ul>

    <c:if test="${UserService.isAuth()}">
        <form action="" method="post">
            <div class="input-group mb-3">
                <input name="text" type="text" class="form-control">
            </div>
            <button class="btn btn-success">Напишите отзыв</button>
        </form>
    </c:if>
</div>

</t:mainLayout>
