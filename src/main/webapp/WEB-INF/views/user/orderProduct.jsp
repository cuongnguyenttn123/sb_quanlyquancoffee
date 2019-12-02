
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		style="background: url(../resouces/images/background.jpg); background-size: cover;">
		<!-- content -->
		<div id="content-index" class="content-wrapper dislpay-product" style="width: 100%; margin-left: 0;">
		
			<%@ include file="./content/content-orderProduct.jsp"%>

		</div>
		<!-- content [END] -->
		<!-- content-wrapper ends -->

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
<script src="../resouces/ajax-jquery/pay-cart.js"></script>
<!-- End Modal -->

</body>

</html>