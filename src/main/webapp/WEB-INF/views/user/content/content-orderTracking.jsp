<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <h3>Theo dõi đơn hàng</h3>
    <div>
        <div class="container">
            <input id="valueid" type="hidden" value="${value}">
            <ul class="progressbar">
                <li class="active" id= "progressbar_1"> Đang Chờ</li>
                <li class="" id= "progressbar_2"> Xác Nhận</li>
                <li class=""id= "progressbar_3"> Đang Giao Hàng</li>
                <li class=" "id= "progressbar_4"> Đã Thanh Toán</li>
            </ul>
        </div>

    </div>
</div>