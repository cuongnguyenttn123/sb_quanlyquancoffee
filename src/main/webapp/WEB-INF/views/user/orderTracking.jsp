
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
        <!-- content -->
        <div id="content-index" class="content-wrapper dislpay-product" style="width: 100%; margin-left: 0;">
            <div class="row" style="height: 35px"></div>

            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <jsp:include page="content/content-orderTracking.jsp"/>
                </div>
            </div>
            <div class="row" style="height: 20px"></div>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <h3>Chi tiết hóa đơn:</h3>
                    <jsp:include page="content/bill/tBodyDetail.jsp"/>
                </div>
            </div>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <jsp:include page="content/infor_customer/information.jsp"></jsp:include>
                </div>
            </div>
        </div>

        <!-- content [END] -->
        <!-- content-wrapper ends -->
        <!-- messenger -->

        <!-- end messenger -->
        <!-- footer-->
        <%@ include file="./common/footer.jsp"%>
        <!-- footer [END] -->
        <!-- row-offcanvas ends -->
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