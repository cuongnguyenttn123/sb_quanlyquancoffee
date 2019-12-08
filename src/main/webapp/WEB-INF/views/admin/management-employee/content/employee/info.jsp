<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <h3>Thông tin nhân viên:</h3>
        <span>Họ và tên: ${employee.getName()}</span>
        <br>
        <span>Địa chỉ: ${employee.getAddress()}</span>
        <br>
        <span>SDT: (+84) ${employee.getPhone()}</span>
    </div>
    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
        <h3>Các quyền:</h3>
        <ul>
            <c:forEach items="${employee.getAtpositions()}" var="position">
                <li>
                    ${position.getName()}
                </li>
            </c:forEach>
        </ul>
    </div>
</div>


