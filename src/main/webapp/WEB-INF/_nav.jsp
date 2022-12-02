<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <div class="container">
        <div class="header_innner">
            <div class="header_logo">Car Rental</div>

            <nav class="nav">
            <c:if test="${user != null}">
                ${user.getUsername()}
                <div><c:if test="${user.getRole() == 'admin'}">
                <a class="nav__link" href="/RentCar/create"/>New Car</a>
                </c:if>
            </c:if>
                <a class="nav__link" href="/RentCar/home">Home</a>
                <a class="nav__link" href="/RentCar/signin">Sign In</a>
                <a class="nav__link" href="/RentCar/registration">Register</a>
                <a class="nav__link" href="/RentCar/car/list">Cars</a>

<%--            <c:if test="${user == null}">--%>
<%--            <div class="head"> <a href="<c:url value="/signin"/>">Sign in</a>--%>
<%--                <a href="/RentCar/registration">Register</a>--%>
<%--                </c:if>--%>
<%--                <c:if test="${user.getRole() == 'admin'}">--%>
<%--                </c:if>--%>
<%--                &lt;%&ndash;<li><a href="/user/list">Users list</a></li>&ndash;%&gt;--%>
<%--                &lt;%&ndash;<li><a href="/login">Log in</a></li>&ndash;%&gt;--%>
<%--                <a href="/RentCar/car/list">Home</a>--%>
<%--            </div>--%>
        </div>
            </nav>
        </div>
    </div>
</header>
<%--<div class="intro">--%>
