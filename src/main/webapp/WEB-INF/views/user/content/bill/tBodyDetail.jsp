<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table style="width: 100%">
	<colgroup>
		<col span="1" style="width: 20%;">
		<col span="1" style="width: 20%;">
		<col span="1" style="width: 20%;">
		<col span="1" style="width: 20%;">
	</colgroup>
	<tr>
		<th>Sản phẩm</th>
		<th>Số lượng</th>
		<th>Đơn giá</th>
		<th>Tổng tiền</th>
	</tr>
	<!-- Put <thead>, <tbody>, and <tr>'s here! -->
	<tbody>

		<c:forEach items="${productDTOs}" var="productDTOs">
			<tr>
				<td><c:out value="${productDTOs.getName()}" /></td>
				<td class="text-danger">  <c:out value="${productDTOs.getNumber()}" /></td>
				<td class="text-danger"><c:out value="${productDTOs.getPrice()}" /> VND</td>
				<td class="text-danger"><c:out value="${productDTOs.getPrice()*productDTOs.getNumber()}" /> VND</td>

			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<h5>Tổng tiền thanh toán: ${tongtien} VND</h5>