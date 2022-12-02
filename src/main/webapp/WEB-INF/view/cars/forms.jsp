<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="forms">
<%--    <div class="car-page">--%>
<%--    <h1 class="car-name">${car.getBrand()} ${car.getModel()}</h1>--%>
<%--    <div class="car-field">--%>
<%--    <span class="field-price">Price:</span>--%>
<%--    <span class="field-value">${car.getPrice()} ₽</span>--%>
<%--    <div class="btn-wrapper">--%>

<%--    <input type="submit" value="Арендовать" class="wpcf7-form-control has-spinner wpcf7-submit btn" onclick="location.href ='\\RentCar\\car\\list' "/>--%>
<div class="intro">
    <div class="mi-wrapper">
    <label>Ваш номер телефона *</label><br />
    <span class="wpcf7-form-control-wrap userPhone"><input type="tel" name="userPhone" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-tel wpcf7-validates-as-required wpcf7-validates-as-tel" aria-required="true" aria-invalid="false" /></span>
    </div>
    <div class="mi-wrapper">
    <label>Дата аренды</label><br />
    <span class="wpcf7-form-control-wrap userRentDate"><input type="text" name="userRentDate" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" id="orderdate" aria-required="true" aria-invalid="false" /></span>
    </div>
    <div class="mi-wrapper">
    <label>Срок аренды</label><br />
    <span class="wpcf7-form-control-wrap userRentDayCount"><input type="text" name="userRentDayCount" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" /></span>
    </div>
    <div class="btn-wrapper">
        <input type="submit" value="Отправить" class="wpcf7-form-control has-spinner wpcf7-submit btn" onclick="location.href ='list' "/>
    </div>

    </div>
    </div>
    </div>
</t:mainLayout>