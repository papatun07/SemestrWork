<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<link rel="stylesheet" href="<c:url value="/style/index.html"/>">--%>

<%--<link rel="stylesheet" href="<c:url value="/style/_style.css"/>">--%>
<t:mainLayout title="Car list">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
    <div class="body">
    <div class="intro">
        <div class="container">
            <h1></h1>
            <div class="text-info">Доступных машин на сайте : ${carCount}</div>
            <div class="cars-list"></div>
            <c:forEach items="${cars}" var="car">
                <div class="car-card">
                    <div class="car-header">
                        <h3 class="car-name"><a href="<c:url value="/car/detail?id=${car.id}"/>">${car.getBrand()} ${car.getModel()} </a></h3>
                        <div class="price"> <span class="car-info">${car.getPrice()} ₽</span></div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
    </div>
</t:mainLayout>