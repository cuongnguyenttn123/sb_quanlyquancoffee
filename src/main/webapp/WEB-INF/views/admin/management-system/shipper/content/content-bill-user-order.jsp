<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <h3>Theo dõi đơn hàng</h3>
    <div id="changer"></div>
    <div>
        <div class="progressbar-container">
            <input id="valueid" type="hidden" value="${value.getBillstatus().getBillstatusid()}">
            <c:if test="${value.getBillstatus().getBillstatusid() == 'HDH'}">
                <jsp:include page="progressbar_2.jsp"></jsp:include>
            </c:if>
            <c:if test="${value.getBillstatus().getBillstatusid() != 'HDH'}">
                <jsp:include page="progress_4.jsp"></jsp:include>
                <a href="/shipper/done/${value.getBillid()}">Xác Nhận Thanh Toán !</a>
                <br>
                <div class="row">
                    <br>
                    <br>
                </div>

            </c:if>
        </div>
    </div>
</div>