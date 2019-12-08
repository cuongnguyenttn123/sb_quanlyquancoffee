<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
        <h4 class="result"></h4>
        <h1>Edit Password: </h1>
        <form action="/employee/editpassword" method="post">
            <div class="form-group row">
                <label for="inputPassword1" class="col-sm-2 col-form-label">Nhập mật khẩu cũ</label>
                <div class="col-sm-10">
                    <input type="password" name="oldpassword" class="form-control" id="inputPassword1" placeholder="Password">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputPassword2" class="col-sm-2 col-form-label">Nhập mật khẩu mới</label>
                <div class="col-sm-10">
                    <input type="password" name="newpassword" class="form-control" id="inputPassword2" placeholder="Password">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Nhập lại mật khẩu mới</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                </div>
            </div>
            <div class="form-group row">
                <div class="offset-sm-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Đổi mật khẩu</button>
                </div>
            </div>
        </form>
    </div>
</div>


