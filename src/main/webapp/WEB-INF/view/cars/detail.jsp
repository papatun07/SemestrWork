<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${user != null}">

</c:if>

<t:mainLayout title="car/detail">
    <div class="intro">
    <body>
    <div class="car-page">
        <h1 class="car-name">${car.getBrand()} ${car.getModel()}</h1>
        <div class="car-field">

            <c:if test="${car.getId() == 1}">
            <img src="../style/photo/mustang.png" width="650" height="350" >
            </c:if>
            <c:if test="${car.getId() == 2}">
                <img src="../style/photo/camaro.png"  width="700" height="350" >
            </c:if>
            <c:if test="${car.getId() == 3}">
                <div class="element-style"><img src="../style/photo/corvette.png"  width="700" height="350" ></div>
            </c:if>
            <c:if test="${car.getId() == 4}">
                <div class="element-style"><img src="../style/photo/BMW-7.png"  width="600" height="280"></div>


            </c:if>
        </div>
            <span class="field-price">Price:</span>
            <span class="field-value" align=”right”>${car.getPrice()} ₽</span>
                <div class="btn-wrapper">

                        <input type="submit" align=”right” value="Арендовать" class="wpcf7-form-control has-spinner wpcf7-submit btn"
                               <c:if test="${user == null}">onclick="location.href ='/RentCar/signin' "/></c:if>
                                <c:if test="${user != null}"> onclick="location.href ='forms' "/></c:if>
<%--            <label>Ваше имя</label><br />--%>
<%--            <span class="wpcf7-form-control-wrap userName"><input type="text" name="userName" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" /></span>--%>
<%--        </div>--%>
<%--        <div class="mi-wrapper">--%>
<%--            <label>Ваш номер телефона *</label><br />--%>
<%--            <span class="wpcf7-form-control-wrap userPhone"><input type="tel" name="userPhone" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-tel wpcf7-validates-as-required wpcf7-validates-as-tel" aria-required="true" aria-invalid="false" /></span>--%>
<%--        </div>--%>
<%--        <div class="mi-wrapper">--%>
<%--            <label>Дата аренды</label><br />--%>
<%--            <span class="wpcf7-form-control-wrap userRentDate"><input type="text" name="userRentDate" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" id="orderdate" aria-required="true" aria-invalid="false" /></span>--%>
<%--        </div>--%>
<%--        <div class="mi-wrapper">--%>
<%--            <label>Срок аренды</label><br />--%>
<%--            <span class="wpcf7-form-control-wrap userRentDayCount"><input type="text" name="userRentDayCount" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" /></span>--%>
<%--        </div>--%>
<%--        <div class="mi-wrapper">--%>
<%--            <label>Куда доставить автомобиль?</label><br />--%>
<%--            <span class="wpcf7-form-control-wrap userPlace"><input type="text" name="userPlace" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" /></span>--%>
<%--        </div>--%>
<%--        <div style="display: none">--%>
<%--            <input type="hidden" name="utm_source" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="utm_medium" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="utm_term" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="utm_campaign" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="utm_content" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="pm_source" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="pm_block" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="pm_position" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <input type="hidden" name="yclid" value="" class="wpcf7-form-control wpcf7-hidden" />--%>
<%--            <p><span class="wpcf7-form-control-wrap carName"><input type="text" name="carName" value="" size="40" class="wpcf7-form-control wpcf7-text" aria-invalid="false" /></span>--%>
<%--            </p></div>--%>
<%--        <div class="btn-wrapper">--%>
<%--            <input type="submit" value="Отправить" class="wpcf7-form-control has-spinner wpcf7-submit btn" />--%>
<%--            <a href="/rus/Auto/Auto/Ford/Others_Ford/wallpaper-139042.htm"><img src="/pictures/originals/2020Auto___Ford___Others_Ford_White_Ford_Mustang_GT_car__2019_rear_view_139042_.jpg"></a>--%>
        </div>
        </div>
    </body>
    </div>
</t:mainLayout>
