<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 30/11/2019
  Time: 04:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

