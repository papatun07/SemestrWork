<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Create">
    <div class="intro">
        Brand: <input brand="brand" />
        <br><br>
        Model: <input name="model"  />
        <br></br>
        Price: <input name="model"  />
        <br></br>
        <div><input type="submit" value="Создать" class="button-submit" onclick="location.href ='car/list' "/></div>

</t:mainLayout>