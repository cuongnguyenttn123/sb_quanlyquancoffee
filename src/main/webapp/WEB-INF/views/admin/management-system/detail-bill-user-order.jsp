<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 03/12/2019
  Time: 09:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEADER -->
<%@ include file="../public/header.jsp"%>
<!-- HEADER [END] -->
<!-- content-wrapper -->
<div id="content-index" class="content-wrapper" style="background: none">
    <jsp:include page="content/bill-user-order/content-bill-user-order.jsp"/>
    <h3>Chi tiết hóa đơn:</h3>
    <div class="row">
        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
            <jsp:include page="content/bill-user-order/tBodyDetail.jsp"/>
        </div>
    </div>
    <div class="row">
        <br>
    </div>

    <div class="row">
        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
            <div class="row">
                <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                    <h3>Thông tin tài khoản:</h3>
                    <span>Họ và tên: ${customer.getName()}</span>
                    <br>
                    <span>Địa chỉ nhận hàng: ${customer.getAddress()}</span>
                    <br>
                    <span>SDT: (+84) ${customer.getPhone()}</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- content-wrapper ends -->
<!-- my-js -->

<!-- my-js[END] -->
<!-- FOOTER -->
<script src="<c:url value="/resouces/ajax-jquery/order-tracking/1.js"/>"></script>
<%@ include file="../public/footer.jsp"%>
<!-- FOOTER [END]-->