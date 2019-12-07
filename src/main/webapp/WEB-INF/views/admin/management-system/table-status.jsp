<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEADER -->
<%@ include file="../public/header.jsp"%>
<!-- HEADER [END] -->
<!-- content-wrapper -->
<div id="content-index" class="content-wrapper">
	<%@ include file="./content/table-status/content.jsp"%>
</div>
<!-- content-wrapper ends -->
<!-- my-js -->
<script src="../resources/ajax-jquery/loadTable.js"></script>
<script src="../resources/ajax-jquery/table-status/table-status.js"></script>
<!-- my-js[END] -->
<!-- FOOTER -->
<%@ include file="../public/footer.jsp"%>
<!-- FOOTER [END]-->