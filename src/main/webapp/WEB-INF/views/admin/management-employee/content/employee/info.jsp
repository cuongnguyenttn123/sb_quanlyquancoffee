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

<div class="row">
    <div class="col-10">
        <div class="well well-sm">
            <div class="row">
                <div class="col-6">
                    <img src="http://placehold.it/300x450" alt="" class="img-rounded img-responsive" />
                </div>
                <div class="col-6">
                    <h4>
                        Bhaumik Patel</h4>
                    <small><cite title="San Francisco, USA">San Francisco, USA <i class="glyphicon glyphicon-map-marker">
                    </i></cite></small>
                    <p>
                        <i class="glyphicon glyphicon-envelope"></i>email@example.com
                        <br />
                        <i class="glyphicon glyphicon-globe"></i><a href="http://www.jquery2dotnet.com">www.jquery2dotnet.com</a>
                        <br />
                        <i class="glyphicon glyphicon-gift"></i>June 02, 1988</p>
                    <!-- Split button -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-primary">
                            Social</button>
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span><span class="sr-only">Social</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Twitter</a></li>
                            <li><a href="https://plus.google.com/+Jquery2dotnet/posts">Google +</a></li>
                            <li><a href="https://www.facebook.com/jquery2dotnet">Facebook</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Github</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


