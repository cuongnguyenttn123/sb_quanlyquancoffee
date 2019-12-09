
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- head -->
<%@ include file="./common/head.jsp"%>
<!-- head [END] -->

<body style="background-color: white">
<div class="container">

    <!-- nav -->0

    <%@ include file="./common/nav.jsp"%>
    <!-- nav [END] -->

    <!-- content-wrapper -->
    <div class="container-fluid">
        <div class="row" style="height: 20px"></div>
        <div class="row">
            <div class="col-3" style="color: red">
                <h3>CƯờng nguyen</h3>
            </div>
            <div class="col-9">
                <div class="row" style="height: 35px"></div>

                <div class="container">
                    <jsp:include page="content/content-bill-user-order.jsp"/>
                </div>

                <div class="container">
                    <h3>Chi tiết hóa đơn:</h3>
                    <div class="row">
                        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                            <jsp:include page="content/tBodyDetail.jsp"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                            <jsp:include page="content/information.jsp"></jsp:include>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content -->
        </div>
    </div>
    <!-- page-body-wrapper ends -->
</div>

<!-- js libary-->
<%@ include file="./common/jsLibary.jsp"%>
<!-- js libary [END] -->

<!-- my-js -->

<!-- my-js[END] -->

</body>

</html>