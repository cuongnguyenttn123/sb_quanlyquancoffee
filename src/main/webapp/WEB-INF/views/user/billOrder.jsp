
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- head -->
<%@ include file="./common/head.jsp"%>
<!-- head [END] -->

<body class="">
<div class="container-scroller">

    <!-- nav -->0

    <%@ include file="./common/nav.jsp"%>
    <!-- nav [END] -->

    <!-- content-wrapper -->
    <div class="container-fluid page-body-wrapper"
         style="background: url(../resources/images/background.jpg); background-size: cover;">
        <!-- content -->

        <div class="container">
            <div class="row">
                <H2>Quản Lý Tài Khoản</H2>
            </div>
            <div class="row">

                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <jsp:include page="content/infor_customer/information.jsp"/>
                </div>

                <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                    <jsp:include page="content/bill/content.jsp"></jsp:include>
                </div>


            </div>


        </div>
        <!-- content [END] -->


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

<!-- Modal -->
<script src="<c:out value="/resources/ajax-jquery/book-table.js"/>"></script>
<!-- End Modal -->

</body>

</html>