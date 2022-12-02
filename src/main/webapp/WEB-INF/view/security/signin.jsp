<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Sign in">
    <div class="intro">
    <div>${message}</div>
    <form id="loginForm" class="form-horizontal" action="<c:url value="/signin"/>" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-3" for="username">E-mail</label>
            <div class="controls col-sm-9">
                <input id="username" name="username" class="form-control" type="text" value=""/>
            </div>
        </div><div class="form-group">
        <label class="control-label col-sm-3" for="password">Password</label>
        <div class="controls col-sm-9">
            <input id="password" name="password" class="form-control" type="password" value=""/>
        </div>
    </div><button type="submit" class="btn btn-success">Sign in</button>
    </form>
    <div> </div>
    <div>Еще не зарегистрированы?</div>
    <div> </div>
    <div><input type="submit" value="Зарегистрироваться" class="wpcf7-form-control has-spinner wpcf7-submit btn" onclick="location.href ='registration' "/></div>
    </div>
</t:mainLayout>

