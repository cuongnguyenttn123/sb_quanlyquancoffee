<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${dtos}" var="dto">
	<tr>
		<td><label
			data-voucherid='<c:out value="${dto.getVoucher().getVoucherid()}" />'
			class="badge badge-info edit"><i class="fa fa-wrench x"></i></label>
			<c:if test="${!dto.getCanDelete()}">
				<label
					data-voucherid='<c:out value="${dto.getVoucher().getVoucherid()}" />'
					class="badge badge-danger remove"><i class="fa fa-times"></i></label>
			</c:if></td>
		<td><c:out value="${dto.getVoucher().getName()}" /></td>
		<td><c:out value="${dto.getVoucher().getStartdatetime()}" /></td>
		<td><c:out value="${dto.getVoucher().getEnddate()}" /></td>
		<td><c:out value="${dto.getVoucher().getNumber()}" /></td>
		<td><c:out value="${dto.getVoucher().getCount()}" /></td>
		<td><c:out value="${dto.getVoucher().getSaleoff()}" /></td>

	</tr>
</c:forEach>
<script src="../resources/ajax-jquery/voucher/voucher-add.js"></script>