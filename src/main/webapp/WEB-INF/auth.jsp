<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<jsp:include page="/WEB-INF/_nav.jsp" />
<hr>
<t:mainLayout title="INSERT REVIEW">
<h2 class="text-center">Вход</h2>

<div class="w-25 mx-auto">
    <form action="" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">Имя</span>
            <input name="login" type="text" class="form-control"  aria-describedby="basic-addon1">
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon2">Пароль</span>
            <input name="password" type="password" class="form-control" aria-describedby="basic-addon2">
        </div>

        <button class="btn btn-primary">Войти</button>
    </form>
</div>
</t:mainLayout>