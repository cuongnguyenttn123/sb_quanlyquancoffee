<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 02/12/2019
  Time: 11:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${dtos}" var="bill">
    <a class="dropdown-item" href="/admin/getdetailbillid/${bill.getBill().getBillid()}">
        <div class="sender-img">
            <img src="" alt="">
            <span class="badge badge-success">&nbsp;</span>
        </div>
        <div class="sender">
            <div class="sender">
                <p class="Sende-name">${bill.getBill().getCustomer().getName()}</p>
                <p class="Sender-message">Đặt hàng vào lúc: ${bill.getBill().getStartdatetime()}</p>
            </div>
        </div>
    </a>
</c:forEach>
<a href="/admin/getlistuserorderall" class="dropdown-item view-all">Xem thêm</a>
