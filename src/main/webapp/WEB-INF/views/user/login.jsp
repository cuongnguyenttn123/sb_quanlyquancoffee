<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 01/12/2019
  Time: 03:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login user</title>
    <jsp:include page="common/head.jsp"/>
</head>
<body>
    <div class="container text-white">
        <br>
        <br>
        <br>
        <br>
        <div class="row">
            <div class="col-3">

            </div>
            <div class="col-6">
                    <div class="form-group">
                        <label for="sdt">Email address</label>
                        <input type="text" class="form-control" id="sdt" aria-describedby="emailHelp" placeholder="Enter Số Điện Thoại">
                    </div>
                    <div class="form-group">
                        <label for="pass">Password</label>
                        <input type="password" class="form-control" id="pass" placeholder="Enter Password">
                    </div>
                    <button class="btn btn-primary" id="btn-login-user">Submit</button>
            </div>
        </div>

    </div>

<jsp:include page="common/jsLibary.jsp"/>
</body>
</html>
