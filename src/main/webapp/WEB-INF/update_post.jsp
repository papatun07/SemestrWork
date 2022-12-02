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
<h2 class="text-center mb-5">Редактировать пост</h2>
<form action="" method="post" enctype="multipart/form-data" class="w-75 mx-auto">
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Название</label>
        <input value="${post.getTitle()}" name="title" type="text" class="form-control" id="exampleFormControlInput1">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Описание упражнения</label>
        <textarea name="text" class="form-control" id="exampleFormControlTextarea1" rows="3">
            ${post.getText()}
        </textarea>
    </div>

    <div class="mb-3">
        <label for="formFile" class="form-label">Загрузите картинку тренажера</label>
        <input name="img" class="form-control" type="file" id="formFile">
    </div>

    <button class="btn btn-outline-primary mt-5">Сохранить</button>
</form>


</t:mainLayout>